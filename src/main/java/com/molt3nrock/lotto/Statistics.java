package com.molt3nrock.lotto;

import static com.molt3nrock.lotto.Constants.PRICE_PER_LOTTO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 당첨 통계를 나타내는 클래스.
 */
class Statistics {

    private Map<Rank, Integer> rankState;

    private Statistics(Map<Rank, Integer> rankState) {
        this.rankState = rankState;
    }

    static Statistics valueOf(List<Lotto> lottoList, WinningLotto winningLotto) {
        final int DEFAULT_RANK_COUNT = 0;
        HashMap<Rank, Integer> hashMap = new HashMap<>();
        Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH, Rank.MISS)
            .forEach(rank -> hashMap.putIfAbsent(rank, DEFAULT_RANK_COUNT));
        Statistics statistics = new Statistics(hashMap);
        lottoList.forEach(lotto -> statistics.classifyLotto(lotto, winningLotto));
        return statistics;
    }

    void displayRankState() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        rankState.entrySet().stream()
            .filter(entry -> !entry.getKey().equals(Rank.MISS))
            .sorted(Comparator.comparingInt(rank -> rank.getKey().getWinningMoney()))
            .map(Statistics::formatRankStateEntry)
            .forEach(System.out::println);
    }

    void displayRossGainRation() {
        System.out.println(String.format("총 수익률은 %.3f입니다.", calculateRossRatio()));
    }

    void displayStatistics() {
        displayRankState();
        displayRossGainRation();
    }

    /**
     * 로또 수익률 계산 메쏘드.
     *
     * rankState: {@code Map<Rank, Integer>}
     * - Rank: Lotto 의 Rank
     * - Integer: Rank 에 해당하는 Lotto 의 갯수.
     *
     * 총 이득 = rankState.keys().getWinningMoney() 의 합
     * 총 투자 = PRICE_PER_LOTTO * 모든 rankState.values() 의 합
     *
     * 수익률 = 총 이득 / 총 투자
     */
    private float calculateRossRatio() {
        int totalGain = rankState.entrySet().stream()
            .map(entry -> entry.getValue() * entry.getKey().getWinningMoney())
            .reduce(0, (accumulation, prizeMoney) -> accumulation + prizeMoney);
        int totalCost = rankState.values().stream()
            .reduce(0, (accumulation, count) -> accumulation + count * PRICE_PER_LOTTO);
        return (float) totalGain / totalCost;
    }

    private static String formatRankStateEntry(Entry<Rank, Integer> entry) {
        return String.format("%s- %d개", entry.getKey(), entry.getValue());
    }

    private void classifyLotto(Lotto lotto, WinningLotto winningLotto) {
        Rank rank = winningLotto.match(lotto);
        rankState.computeIfPresent(rank, (rankKey, count) -> count + 1);
    }
}

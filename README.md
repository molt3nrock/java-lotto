
# 3주차 미션 로또

# 로또 규칙
  - 유효한 숫자 범위: 1 부터 45 사이의 숫자.
  - 추첨 숫자의 갯수: 6 + 1. 한개의 숫자 보너스 숫자와 나머지 일반 당첨 숫자.
  - 구입방법: 사용자는 로또 한 게임당 6개의 유효한 숫자를 고를 수 있으며, 로또 한 회차에 여러게임을 동시에 시도할 수 있다.
  - 당첨결과 계산법:
    * 5등: 3개의 숫자 일치.
    * 4등: 4개의 숫자 일치.
    * 3등: 5개의 숫자 일치.
    * 2등: 5개의 숫자 일치 + 보너스 숫자 일치.
    * 1등: 6개의 숫자 일치.

# 기능 목록
  1. 로또 구입: 사용자의 입력을 기반으로 한 Lotto 객체 생성.
     - [x] 로또 규칙에 맞는 임의의 숫자 생성하기.
     - [x] 로또 구입에 사용할 돈 입력받기. 유효한 로또구입 최소 금액은 로또 한장의 금액임을 유의.
     - [x] 구입한 돈으로 Lotto 리스트 생성.
     - [x] 생성한 Lotto 클래스 출력.

  2. 당첨번호 및 보너스 번호
     - [x] 로또 규칙에 맞는 당첨번호 입력받기.
     - [x] 보너스 번호 입력 받기. 당첨번호로 사용된 번호는 유효한 보너스 번호가 아님을 주의.
     - [x] WinningLotto 클래스 생성.

  3. 당첨통계
     - [x] 당첨번호와 사용자의 Lotto 번호 비교.
     - [x] 당첨 통계 클래스 정의.
     - [x] 당첨 Rank 에 따른 Lotto 클래스 분류.
     - [x] Rank 에 따른 Lotto 당첨현황 출력. 당첨 현황 출력의 순서는 당첨금액 기준 오름차순임을 유의.
     - [x] Rank 에 따른 Lotto 손익 계산. 수익률 = (당첨금액/구입금액)

  4. 전체 게임 흐름
     - 각 단계마다 오류시 오류 메세지를 출력하고 종료.
     1.  로또 구입 가격을 입력받음.
     2.  구입된 로또를 출력.
     3.  당첨번호 및 보너스 번호 입력 받음.
     4.  로또 Rank 계산.
     5.  당첨 통계 출력.
     6.  수익률 출력.


# 로또 게임 기능
  - 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  - 로또 1장의 가격은 1000원이다.
  - 로또 당첨 금액은 고정되어 있는 것으로 가정한다.
  - 수익률을 계산해 출력해야 한다.


# 프로그래밍 요구사항
  ## Lotto 객체를 활용해 구현해야 한다.
    - Lotto 기본 생성자를 추가할 수 없다.
    - numbers 변수의 접근 제어자인 private 을 변경할 수 없다.
    - Lotto 에 필드(인스턴스 변수)를 추가할 수 없다.
```java
 /**
  * 로또 한장을 의미하는 객체
  */
  public class Lotto {
      private final List<Integer> numbers;

      public Lotto(List<Integer> numbers) {
          this.numbers = numbers;
      }
  }
```

  ## WinningLotto 객체를 활용해 구현해야 한다.
    - match() 메소드의 반환 값인 Rank 는 저장소에서 제공한다.
    - WinningLotto 기본 생성자를 추가할 수 없다.
    - lotto, bonusNo 변수의 접근 제어자인 private 을 변경할 수 없다.
    - WinningLotto 에 필드(인스턴스 변수)를 추가할 수 없다.
```java
  /**
   * 당첨 번호를 담당하는 객체
   */

  public class WinningLotto {
      private final Lotto lotto;
      private final int bonusNo;

      public WinningLotto(Lotto lotto,int bonusNo) {
          this.lotto = lotto;
          this.bonusNo = bonusNo;
      }

      public Rank match(Lotto userLotto) {
          // TODO 로직 구현
          return null;
      }
  }
```

  ## 코딩 규칙
    - 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - else 예약어를 쓰지 않는다.
    - public/protected/private/package 접근 제어자를 용도에 적합하게 사용해 구현한다.
    - 함수(또는 메소드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
    - indent(인덴트, 들여쓰기) depth를 2가 넘지 않도록 구현한다. 1까지만 허용한다.
    - 함수(또는 메소드)의 인자 수를 3개까지만 허용한다. 4개 이상은 허용하지 않는다.

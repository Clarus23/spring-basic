package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/*
## 관심사를 분리하자
    - service는 실제 비지니스 로직에 집중
    - service는 어떤 구현체가 오더라도 똑같은 작업을 수행 가능해야함
    - 구현체를 생성하고, 이를 주입(연결)해줄 별도의 class가 필요한 시점
    - 구현체 주입과 비지니스 로직의 책임을 확실하게 분리하자
  ## 정리
    - AppConfig를 통해서 관심사를 확실히 분리
    - 배역, 배우를 생각해보자
    - AppConfig는 공연 기획자다.
    - AppConfig는 구체 클래스를 선택한다.
                  배역에 맞는 담당 배우를 선택한다.
                  애플리케이션이 어떻게 동작할지 전체 구성을 책임진다.
    - 이제 각 배우(Service)들은 담당 기능을 실행하는 책임만 지면 된다.
    - OrderServiceImpl은 기능을 실행하는 책임만 지면된다.
 */
public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private static DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
/*
## AppConfig refactoring
  ## refactoring 이전
    - AppConfig를 보면 **중복**이 존재하고, **역할**에 따른 **구현**이 잘 안보임.
      => 중복을 제거하고, 역할에 따른 구현이 보이도록 리팩토링 수행.

  ## refactoring 이후
    - memberRepository를 **중복으로 생성**하는 부분이 제거됨.
      => 이제 memberRepository의 구현체를 변경할 시, 한 부분만 변경하면 됨.
    - AppConfig를 보면 역할과 구현 클래스가 한눈에 들어온다.
      => 애플리케이션 전체 구성이 어떻게 되어있는지 빠르게 파악 가능하다.
 */

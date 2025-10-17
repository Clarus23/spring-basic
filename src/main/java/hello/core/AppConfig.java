package hello.core;

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
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}

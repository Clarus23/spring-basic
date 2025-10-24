package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    // 인터페이스에만 의존하도록 코드를 변경. (구현체 코드( new ~~() 를 들어냄)
    // ## 문제제기
    //     - 그런데 구현체가 없는데 어떻게 코드가 실행될 수 있을까???
    // ## 해결방안
    //     - 누군가가 클라이언트인 OrderServiceImpl에 DiscountPolicy의 구현체를 "대신" 생성하고 주입해줘야함.
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}

package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
## 스프링으로 전환하기
    - 이전에는 개발자가 AppConfig를 사용해서 직접 조회 했지만, 이제부터는 스프링 컨테이너를 사용하여 필요한 스프링 빈 객체를 찾아야 한다.
    - 스프링 빈은 applicationContext.getBean() 메서드를 사용하여 찾을 수 있다.
    - 기존에는 개발자가 직접 자바코드로 모든 것을 했다면, 이제부터는 스프링 컨테이너에 객체를 스프링 빈으로 등록하고, 스프링 컨테이너에서 스프링 빈을 찾아서 사용하도록 변경되었다.

    => 코드가 더 복잡해진거 같은데... "스프링 컨테이너를 사용하면 어떤 장점이 있을까??"
*/
public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order);
    }
}

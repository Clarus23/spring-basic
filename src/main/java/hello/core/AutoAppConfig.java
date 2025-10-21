package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/*
## 컴포넌트 스캔과 의존관계 자동주입 시작하기
    - 컴포넌트 스캔을 사용하려면 먼저 `@ComponentScan`을 설정 정보에 붙여주면 된다.
    - 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스가 하나도 없다

    - 컴포넌트 스캔의 대상이 될 클래스에 `@Component` 애노테이션을 붙여준다.
    - 또한, 의존관계 주입이 필요할 경우 `@Autowired` 애노테이션을 사용하면 자동으로 의존관계를 주입해준다.
 */
@Configuration
@ComponentScan(  // @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록
        // 기존 예제코드를 남기기 위한 excludeFilter
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {}

package hello.core.singleton;

/*
## 싱글톤 패턴
    ### 싱글톤 패턴의 문제점
        - 구현 코드 자체가 많이 들어감.
        - 의존관계상 클라이언트가 구체 클래스에 의존 => DIP 위반
        - OCP 원칙을 위반할 가능성 높음
        - 테스트 어려움
        - 내부 속성 변경 및 초기화 어려움
        - 자식 클래스를 만들기 어려움
        => 결론적으로 유연성이 떨어짐
        - **안티패턴**이라 불리기도 함
 */
public class SingletonService {
    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}

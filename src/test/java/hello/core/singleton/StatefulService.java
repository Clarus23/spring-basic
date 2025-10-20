package hello.core.singleton;

public class StatefulService {

    private int price;  // 상태를 유지하는 필드

    public void order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
        this.price = price;  // 여기가 문제!! (공유 필드를 특정 클라이언트가 변경 시도)
    }

    public int getPrice() {
        return price;
    }
}

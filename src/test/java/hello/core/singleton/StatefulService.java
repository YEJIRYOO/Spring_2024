package hello.core.singleton;

//상태 유지 경우 발생 문제점
public class StatefulService {

    private int price; //상태 유지하는 필드

//    public void order(String name,int price){
//        System.out.println("name="+name+"price="+price);
//        this.price=price; //문제 발생!
//    }

    public int order(String name,int price){
        System.out.println("name="+name+"price="+price);
        return price;
    }

    public int getPrice() {
        return price;
    }
}

package hello.core.singleton;

public class SingletonService {

    //메모리 영역
    //1. static 영역에 하나의 객체 생성해둠
    private static final SingletonService instance=new SingletonService();

    //2. public으로 열어 객체 인스턴스 필요 시 해당 static  매서드 통해서만 조회하도록 허용
    public static SingletonService getInstance(){
        return instance;
    }

    //3. 생성자를 private으로 선언하여 외부에서 new 키워드 이용한 객체 생성 차단
    private SingletonService(){}

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}

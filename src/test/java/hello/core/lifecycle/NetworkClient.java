package hello.core.lifecycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/*
//LifeCycle CallBack 1 : Using interface

public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url= "+url);
    }

    public void setUrl(String url){
        this.url=url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: "+url);
    }

    public void call(String message){
        System.out.println("call: "+url+" message= "+message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: "+url);
    }

    //InitializingBean의 메서드 초기화 지원 메서드
    @Override
    public void afterPropertiesSet() throws Exception{
        connect();
        call("초기화 연결 메시지");
    }

    //DisposableBean의 메서드 소멸 지원 메서드
    @Override
    public void destroy() throws Exception{
        disconnect();
    }
}
 */

public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url= "+url);
    }

    public void setUrl(String url){
        this.url=url;
    }

    //서비스 시작시 호출
    public void connect(){
        System.out.println("connect: "+url);
    }

    public void call(String message){
        System.out.println("call: "+url+" message= "+message);
    }

    //서비스 종료시 호출
    public void disconnect(){
        System.out.println("close: "+url);
    }

    /*
//LifeCycle CallBack 2 : Using Bean Option
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
     */

//LifeCycle CallBack 3: Using Annotation
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
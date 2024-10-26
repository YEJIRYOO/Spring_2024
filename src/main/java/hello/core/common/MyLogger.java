package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Setter
@Component
@Scope(value = "request")
public class MyLogger {

    private String uuid;
    private String requestURL;

    //request url 은 빈 생성 시점에는 알 수 없으므로 외부에서 입력 받음
//    public void setRequestURL(String requestURL) {
//        this.requestURL = requestURL;
//    }

    public void log(String message){
        System.out.println("["+uuid+"]"+"["+requestURL+"]"+message);
    }

    @PostConstruct
    public void init(){
        uuid= UUID.randomUUID().toString();
        System.out.println("["+uuid+"] request scope bean create:"+this);
    }

    @PreDestroy
    public void close(){
        System.out.println("["+uuid+"] request scope bean close:"+this);
    }
}

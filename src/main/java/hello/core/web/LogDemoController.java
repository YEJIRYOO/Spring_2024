package hello.core.web;

import hello.core.common.MyLogger;
import hello.core.logdemo.LogDemoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;

    /*
    private final MyLogger myLogger; //request scope
    //문제 상황: request scope의 myLogger와 singleton의 요청 시점 불일치
     */

    //sol1: ObjectProvider
    //ObjectProvider 통해 getObject() 호출 시점까지 request scope 빈의 생성 지연
    private final ObjectProvider<MyLogger> myLoggerProvider;

    @RequestMapping("log-demo")
    @ResponseBody //뷰 없이 문자 반환
    public String logDemo(HttpServletRequest request){
        String requestURL=request.getRequestURL().toString();
        MyLogger myLogger= myLoggerProvider.getObject(); //sol1:ObjectProvider
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}

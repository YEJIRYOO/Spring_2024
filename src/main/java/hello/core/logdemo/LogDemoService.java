package hello.core.logdemo;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    //초기값&sol2
    private final MyLogger myLogger;

    //sol1: ObjectProvider
    //private final ObjectProvider<MyLogger> myLoggerProvider;

    public void logic(String id){
//        MyLogger myLogger= myLoggerProvider.getObject();//sol1
        myLogger.log("service id="+id);
    }
}

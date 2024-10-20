package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac=new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client=ac.getBean(NetworkClient.class);
        ac.close(); //스프링 컨테이너 종료 - ConfigurableApplicationContext 필요
    }

    @Configuration
    static class LifeCycleConfig{

        /*
        //CallBack 2: Bean Option -> Setting initial method & destroy method
        @Bean(initMethod = "init",destroyMethod = "close")
        public NetworkClient networkClient(){
            NetworkClient networkClient=new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
         */

        //CallBack 1 & 3: Without Bean Option
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}

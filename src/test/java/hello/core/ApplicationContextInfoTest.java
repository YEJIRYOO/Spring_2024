package hello.core;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames(); //스프링에 등록된 모든 빈 이름 조회
        for(String beanDefinitionName :beanDefinitionNames){
            Object bean=ac.getBean(beanDefinitionName); //빈 이름으로 빈 객체(인스턴스) 조회
            //beanDefinition-> 빈에 대한 메타데이터
            System.out.println("name="+beanDefinitionName+"object="+bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){
        String[] beanDefinitionNames=ac.getBeanDefinitionNames();
        for(String beanDefinitionName :beanDefinitionNames){
            BeanDefinition beanDefinition=
                    ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 or 외부 라이브러리 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean=ac.getBean(beanDefinitionName);
                System.out.println("name="+beanDefinitionName+"object"+bean);
            }
        }
    }

}

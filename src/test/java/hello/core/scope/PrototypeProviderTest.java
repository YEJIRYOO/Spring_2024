package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.inject.Provider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeProviderTest {

    @Test
    void providerTest(){
        AnnotationConfigApplicationContext ac=
                new AnnotationConfigApplicationContext(ClientBean.class,PrototypeBean.class);

        ClientBean clientBean1=ac.getBean(ClientBean.class);
        int count1=clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        ClientBean clientBean2=ac.getBean(ClientBean.class);
        int count2=clientBean2.logic();
        assertThat(count2).isEqualTo(1);

    }

    static class ClientBean{
        /*
        //sol1: using provider_ApplicationContext DL

        @Autowired
        private ApplicationContext ac;

        public int logic(){
            //항상 새로운 프로토타입 빈 생성
            PrototypeBean prototypeBean=ac.getBean(PrototypeBean.class);
            prototypeBean.addCount();
            int count= prototypeBean.getCount();
            return count;
        }
        //문제점: 스프링 컨테이너에 종속적
         */

        /*
        //sol2: using ObjectProvider
        @Autowired
        private ObjectProvider<PrototypeBean> prototypeBeanProvider;

        public int logic(){
            PrototypeBean prototypeBean= prototypeBeanProvider.getObject();
            prototypeBean.addCount();
            int count= prototypeBean.getCount();
            return count;
        }
         */

        //sol3: using JSR-330 Provider
        @Autowired
        private Provider<PrototypeBean> provider;

        public int logic(){
            PrototypeBean prototypeBean=provider.get();
            prototypeBean.addCount();
            int count=prototypeBean.getCount();
            return count;
        }
    }

    @Scope("prototype")
    static class PrototypeBean{

        private int count=0;

        public void addCount(){
            count++;
        }

        public int getCount(){
            return count;
        }

        @PostConstruct
        public void init(){
            System.out.println("PrototypeBean.init"+this);
        }

        @PreDestroy
        public void destroy(){
            System.out.println("PrototypeBean.destroy");
        }
    }
}

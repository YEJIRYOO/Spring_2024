package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
    //ComponentScan -> @Configuration 붙은 설정 정보 자동 등록됨
    //              -> @Component 애노테이션 붙은 클래스 스캔하여 스프링 빈으로 등록
    //그래서 excludeFilter-> 설정정보는 컴포넌트 스캔 대상에서 제외 (기본 예제 코드 최대한 유지 위해 예외적으로 사용한거)

    //기존의 AppConfig와는 다르게 @Bean 으로 등록된 클래스가 없음

}

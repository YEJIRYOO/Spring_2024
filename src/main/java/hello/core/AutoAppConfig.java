package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정정보
@ComponentScan(
        basePackages = "hello.core.member", //탐색 패키지 지점 설정
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    //ComponentScan -> @Configuration 붙은 설정 정보 자동 등록됨 _ 자동으로 스프링 빈 끌어올림
    //              -> @Component 애노테이션 붙은 클래스 스캔하여 스프링 빈으로 등록
    //그래서 excludeFilter-> 설정정보는 컴포넌트 스캔 대상에서 제외 (기본 예제 코드 최대한 유지 위해 예외적으로 사용한거)
    //-> AppConfig 제외

    //기존의 AppConfig와는 다르게 @Bean 으로 등록된 클래스가 없음
    //수동 의존관계 등록 x => @Autowired 이용하여 자동 의존관계 주입 
}

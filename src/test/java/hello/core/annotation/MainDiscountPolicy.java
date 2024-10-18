package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import java.lang.annotation.*;

//Qualifier 어노테이션
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.ANNOTATION_TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
    //문자열의 오류를 컴파일 상에서 잡을 수 있도록 해줌
    //@Qualifier("mainDiscountPolicy")-> @MainDiscountPolicy 로 적용
}

package com.studytodo.web.support.method;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import com.studytodo.core.foundation.NotImplementedException;
import com.studytodo.security.UserSessionHolder;

import java.util.Objects;

/**
 * 스프링 MVC 핸들러 인수로 사용자 세션 객체를 제공하기 위해 작성된 컴포넌트입니다.
 *
 * @author springrunner.kr@gmail.com
 */
public class UserSessionHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final UserSessionHolder userSessionHolder;

    public UserSessionHandlerMethodArgumentResolver(UserSessionHolder userSessionHolder) {
        this.userSessionHolder = Objects.requireNonNull(userSessionHolder);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        throw new NotImplementedException();
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        throw new NotImplementedException();
    }

}

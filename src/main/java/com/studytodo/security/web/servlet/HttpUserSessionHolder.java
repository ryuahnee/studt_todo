package com.studytodo.security.web.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import com.studytodo.security.UserSession;
import com.studytodo.security.UserSessionHolder;

import java.util.Objects;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_SESSION;

/**
 * {@link jakarta.servlet.http.HttpSession}을 사용자 세션 저장소로 사용하는 구현체이다.
 *
 * @author springrunner.kr@gmail.com
 */
@Component
class HttpUserSessionHolder implements UserSessionHolder {

    static final String USER_SESSION_KEY = HttpUserSessionHolder.class.getName();

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public UserSession get() {
        return (UserSession) currentRequestAttributes().getAttribute(USER_SESSION_KEY, SCOPE_SESSION);
    }

    @Override
    public void set(UserSession session) {
        Objects.requireNonNull(session, "session object must be not null");
        currentRequestAttributes().setAttribute(USER_SESSION_KEY, session, SCOPE_SESSION);
        log.info("saved new session. username is `{}`", session.getName());
    }

    @Override
    public void reset() {
        UserSession session = get();
        if (Objects.nonNull(session)) {
            currentRequestAttributes().removeAttribute(USER_SESSION_KEY, SCOPE_SESSION);
            log.info("reset session. username is `{}`", session.getName());
        }
    }

    private RequestAttributes currentRequestAttributes() {
        return Objects.requireNonNull(RequestContextHolder.getRequestAttributes());
    }

}

package com.studytodo.core.foundation.crypto.support;

import com.studytodo.core.foundation.crypto.PasswordEncoder;

/**
 * 아무 처리를 하지 않는 {@link PasswordEncoder} 구현체이다.
 *
 * @author springrunner.kr@gmail.com
 */
public class NoOpPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return password;
    }

}

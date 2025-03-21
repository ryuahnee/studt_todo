package com.studytodo.core.foundation.crypto;

/**
 * 비밀번호 암호화 인터페이스이다.
 *
 * @author springrunner.kr@gmail.com
 */
public interface PasswordEncoder {

    /**
     * 입력된 비밀번호를 암호화한다. 복호화 불가능한 방식으로 암호화 처리가 되어야 한다.
     *
     * @param password 비밀번호
     * @return 암호화된 비밀번호
     */
    String encode(String password);

}

package com.studytodo.core.user.domain;

import com.studytodo.core.shared.identifier.UserId;

/**
 * 사용자 식별자 생성기
 *
 * @author springrunner.kr@gmail.com
 */
public interface UserIdGenerator {

    UserId generateId();

}

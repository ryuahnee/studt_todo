package com.studytodo.core.todo.domain;

import com.studytodo.core.shared.identifier.TodoId;

/**
 * 할일 식별자 생성기
 *
 * @author springrunner.kr@gmail.com
 */
public interface TodoIdGenerator {

    TodoId generateId();

}

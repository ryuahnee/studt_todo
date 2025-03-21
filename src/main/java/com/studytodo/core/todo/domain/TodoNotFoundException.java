package com.studytodo.core.todo.domain;

import com.studytodo.core.foundation.SystemException;
import com.studytodo.core.shared.identifier.TodoId;

/**
 * 할일 저장소에서 할일 도메인 모델을 찾을 수 없을 때 발생 가능한 예외 클래스이다.
 *
 * @author springrunner.kr@gmail.com
 */
public class TodoNotFoundException extends SystemException {

    private final TodoId id;

    public TodoNotFoundException(TodoId id) {
        super("todo not found (id: %s)", id);
        this.id = id;
    }

    public TodoId getId() {
        return id;
    }


    @Override
    public Object[] getArguments() {
        return new Object[]{id};
    }
}

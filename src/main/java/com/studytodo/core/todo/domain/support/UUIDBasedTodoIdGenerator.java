package com.studytodo.core.todo.domain.support;

import org.springframework.stereotype.Component;
import com.studytodo.core.shared.identifier.TodoId;
import com.studytodo.core.todo.domain.TodoIdGenerator;

import java.util.UUID;

/**
 * UUID 기반 할일 식별자 생성기
 *
 * @author springrunner.kr@gmail.com
 */
@Component
class UUIDBasedTodoIdGenerator implements TodoIdGenerator {

    @Override
    public TodoId generateId() {
        return TodoId.of(UUID.randomUUID().toString());
    }

}

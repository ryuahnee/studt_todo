package com.studytodo.data.jpa;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import com.studytodo.core.foundation.Constant;
import com.studytodo.core.shared.identifier.TodoId;
import com.studytodo.core.todo.domain.Todo;
import com.studytodo.core.todo.domain.TodoRepository;

/**
 * Spring Data JPA 기반 할일 저장소 구현체이다.
 *
 * @author springrunner.kr@gmail.com
 */
@Profile(Constant.PROFILE_PRODUCTION)
interface JpaTodoRepository extends TodoRepository, JpaRepository<Todo, TodoId> {

}

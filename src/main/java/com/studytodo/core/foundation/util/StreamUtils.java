package com.studytodo.core.foundation.util;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * {@link Stream} 지원용 유틸리티 클래스이다.
 *
 * @author springrunner.kr@gmail.com
 */
public interface StreamUtils {

    /**
     * {@link Iterator}로 {@link Stream}을 생성한다.
     *
     * @param iterator null 값이 아닌 이터레이터 객체
     * @return 스트림 객체
     */
    static <T> Stream<T> createStreamFromIterator(Iterator<T> iterator) {
        var spliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.NONNULL);
        return StreamSupport.stream(spliterator, false);
    }

}

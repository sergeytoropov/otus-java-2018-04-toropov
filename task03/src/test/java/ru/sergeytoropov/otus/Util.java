package ru.sergeytoropov.otus;

import java.util.stream.IntStream;

/**
 * @author sergeytoropov
 * @since 17.05.18
 */
public class Util {

    public static Integer[] getIncreaseIntegerArray(int length) {
        Integer[] array = new Integer[length];
        IntStream.range(0, array.length).forEach(index -> array[index] = index);
        return array;
    }

    public static Integer[] getDecreaseIntegerArray(int length) {
        Integer[] array = new Integer[length];
        IntStream.range(0, array.length).forEach(index -> array[index] = array.length - index - 1);
        return array;
    }
}

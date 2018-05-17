package ru.sergeytoropov.otus;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 16.05.18
 */
public class CollectionsSimpleArrayListTest {

    private int ARRAY_SIZE = 100000;

    List<Integer> digits;

    @Before
    public void init() {
        digits = new SimpleArrayList<>();
    }

    @Test
    public void addAll() {
        Collections.addAll(digits, Util.getIncreaseIntegerArray(ARRAY_SIZE));
        Collections.addAll(digits, Util.getIncreaseIntegerArray(ARRAY_SIZE));
        Collections.addAll(digits, Util.getIncreaseIntegerArray(ARRAY_SIZE));

        List<Integer> result = new java.util.ArrayList<>();
        Collections.addAll(result, Util.getIncreaseIntegerArray(ARRAY_SIZE));
        Collections.addAll(result, Util.getIncreaseIntegerArray(ARRAY_SIZE));
        Collections.addAll(result, Util.getIncreaseIntegerArray(ARRAY_SIZE));

        assertThat(digits, contains(result.toArray()));
    }

    @Test
    public void copy() {
        List<Integer> result = new java.util.ArrayList<>(Arrays.asList(Util.getIncreaseIntegerArray(ARRAY_SIZE)));

        Collections.addAll(digits, Util.getDecreaseIntegerArray(ARRAY_SIZE));
        Collections.copy(digits, result);

        assertThat(digits, contains(result.toArray()));
    }

    @Test
    public void sort() {
        Collections.addAll(digits, Util.getDecreaseIntegerArray(ARRAY_SIZE));
        Collections.sort(digits);

        assertThat(digits, contains(Util.getIncreaseIntegerArray(ARRAY_SIZE)));
    }
}

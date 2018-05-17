package ru.sergeytoropov.otus;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;

/**
 * @author sergeytoropov
 * @since 17.05.18
 */
public class SimpleArrayListTest {

    private int ARRAY_SIZE = 1000;

    private List<Integer> digits;

    @Before
    public void init() {
        digits = new SimpleArrayList<>();
        Arrays.stream(Util.getIncreaseIntegerArray(ARRAY_SIZE)).forEach(digits::add);
    }

    @Test
    public void size() {
        assertThat(digits.size(), is(ARRAY_SIZE));
    }

    @Test
    public void add() {
        assertThat(digits, contains(Util.getIncreaseIntegerArray(ARRAY_SIZE)));
    }

    @Test
    public void remove() {
        for (Integer value: Util.getIncreaseIntegerArray(ARRAY_SIZE)) {
            digits.remove(value);
        }
        assertThat(digits.size(), is(0));
    }

    @Test
    public void removeIndex() {
        while (digits.size() > 0) {
            digits.remove(0);
        }
        assertThat(digits.size(), is(0));
    }

    @Test
    public void removeIter() {
        Iterator<Integer> iter = digits.iterator();
        while (iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        assertThat(digits.size(), is(0));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void removeIterException() {
        Iterator<Integer> iter = digits.iterator();
        if (iter.hasNext()) {
            iter.next();
            digits.add(100);
            iter.remove();
        }
    }

    @Test
    public void set() {
        digits.set(0, 100);
        digits.set(1, 100);
        digits.set(digits.size() - 1, 0);

        assertThat(digits.get(0), is(100));
        assertThat(digits.get(1), is(100));
        assertThat(digits.get(digits.size() - 1), is(0));

    }
}
package radishevskii.generic;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SimpleArrayTest {

    @Test
    public void shouldReturnEvenNumbersSequentially () {
        SimpleArray<Integer> array = new SimpleArray<>(3);

        array.add(10);
        array.add(20);
        array.add(30);

        assertThat(array.get(0), is(10));
        assertThat(array.get(1), is(20));
        assertThat(array.get(2), is(30));
    }

    @Test
    public void shouldUpdateElements () {
        SimpleArray<Integer> array = new SimpleArray<>(3);

        array.add(10);
        array.add(20);
        array.add(30);
        array.update(1, 40);

        assertThat(array.get(0), is(10));
        assertThat(array.get(1), is(40));
        assertThat(array.get(2), is(30));
    }

    @Test
    public void shouldDeleteElements () {
        SimpleArray<Integer> array = new SimpleArray<>(3);

        array.add(10);
        array.add(20);
        array.add(30);
        array.delete(1);

        assertThat(array.get(0), is(10));
        assertThat(Optional.ofNullable(array.get(1)).isPresent(), is(false));
        assertThat(array.get(2), is(30));
    }
}

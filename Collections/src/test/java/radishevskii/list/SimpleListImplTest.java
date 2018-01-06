package radishevskii.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class SimpleListImplTest {

    private SimpleListImpl<String> simpleList;

    @Before
    public void setUp() {
        simpleList = new SimpleListImpl<String>(3);
    }

    @Test
    public void shouldAddElements() {
        simpleList.add("zeros");
        simpleList.add("first");
        simpleList.add("second");

        assertThat(simpleList.get(0), is("zeros"));
        assertThat(simpleList.get(1), is("first"));
        assertThat(simpleList.get(2), is("second"));

        // More elements
        simpleList.add("3");
        simpleList.add("4");
        simpleList.add("5");
        simpleList.add("6");

        assertThat(simpleList.get(3), is("3"));
        assertThat(simpleList.get(4), is("4"));
        assertThat(simpleList.get(5), is("5"));
        assertThat(simpleList.get(6), is("6"));
    }

    @Test
    public void shouldCreateIteratorOfElements() {
        simpleList.add("0");
        simpleList.add("1");
        simpleList.add("2");
        Iterator<String> it = simpleList.iterator();
        assertThat(it.next(), is("0"));
        assertThat(it.next(), is("1"));
        assertThat(it.next(), is("2"));
    }

    @Test
    public void whenIterateLastElementThenHasNextShouldReturnFalse() {
        simpleList.add("0");
        simpleList.add("1");
        simpleList.add("2");
        Iterator<String> it = simpleList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("0"));
        assertThat(it.next(), is("1"));
        assertThat(it.next(), is("2"));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorHasBeenModifiedThenThrowConcurrentModificationException() {
        simpleList.add("0");
        simpleList.add("1");
        Iterator<String> it = simpleList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("0"));
        simpleList.add("2");
        it.next();
    }
    //(expected = ConcurrentModificationException.class)
}
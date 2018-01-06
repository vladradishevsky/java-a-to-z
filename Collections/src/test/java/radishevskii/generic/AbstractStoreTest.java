package radishevskii.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class AbstractStoreTest {

    private AbstractStore<Base> storage;

    @Before
    public void setUp() {
        storage = new UserStore<User>();
        storage.add(new User("first"));
        storage.add(new User("second"));
        storage.add(new User("third"));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldAddElements() {

        assertThat(Optional.ofNullable(storage.findById("first")).isPresent(), is(true));
        assertThat(Optional.ofNullable(storage.findById("second")).isPresent(), is(true));
        assertThat(Optional.ofNullable(storage.findById("third")).isPresent(), is(true));
        assertThat(Optional.ofNullable(storage.findById("another")).isPresent(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReplaceElements() {

        assertThat(Optional.ofNullable(storage.findById("first")).isPresent(), is(true));

        storage.replace("first", new User("another_first"));

        assertThat(Optional.ofNullable(storage.findById("another_first")).isPresent(), is(true));
        assertThat(Optional.ofNullable(storage.findById("first")).isPresent(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldDeleteElements() {

        assertThat(Optional.ofNullable(storage.findById("second")).isPresent(), is(true));
        storage.delete("second");
        assertThat(Optional.ofNullable(storage.findById("second")).isPresent(), is(false));
    }

    @Test
    public void shouldFindElements() {
        assertThat(Optional.ofNullable(storage.findById("first")).isPresent(), is(true));
        assertThat(Optional.ofNullable(storage.findById("second")).isPresent(), is(true));
        assertThat(Optional.ofNullable(storage.findById("third")).isPresent(), is(true));
    }
}
package radishevsky.FileFilters;

import java.io.File;
import java.io.FileFilter;

/**
 * Фильтр по полному совпадению
 *
 * @author Vlad Radishevsky
 * @since 08.02.2017
 * @version 1.0
 */
public class FullMatch implements FileFilter {

    private final String KEY_WORD;

    public FullMatch(String KEY_WORD) {
        this.KEY_WORD = KEY_WORD;
    }

    /**
     * Tests whether or not the specified abstract pathname should be
     * included in a pathname list.
     *
     * @param pathname The abstract pathname to be tested
     * @return <code>true</code> if and only if <code>pathname</code>
     * should be included
     */
    @Override
    public boolean accept(File pathname) {

        return pathname.getName().equals(this.KEY_WORD);
    }

    @Override
    public String toString() {
        return "полному совпадению";
    }
}

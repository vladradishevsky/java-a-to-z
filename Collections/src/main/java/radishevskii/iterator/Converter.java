package radishevskii.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Converter.
 * Convert iterator of iterators of integers to iterator of integers.
 *
 * @author Radishevskii Vladislav.
 * @version 1.00.
 * @since 24.12.2017.
 */
public class Converter {

    /**
     * Constructor of class Converter.
     * @param it Iterator of Iterators of Integers
     * @return Iterator of Integers
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private final Iterator<Iterator<Integer>> iteratorOfIterator = it;
            private Iterator<Integer> currentIterator = null;

            /**
             * Override method hasNext.
             * @return true if the iteration has more elements.
             */
            @Override
            public boolean hasNext() {
                while (currentIterator == null || !currentIterator.hasNext()) {
                    if (!iteratorOfIterator.hasNext()) return false;
                    currentIterator = iteratorOfIterator.next();
                }
                return true;
            }

            /**
             * Override method next.
             * @return the next Integer in the iteration.
             */
            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }

            /**
             * Override method next.
             * Unsupported Operation.
             */
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

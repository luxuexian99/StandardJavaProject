package org.hsian.thinkinjava.util;

import java.util.ArrayList;

/**
 * Created by Hsian on 15/7/13.
 */
public class CollectionData<T> extends ArrayList<T> {

    /**
     *
     * @param gen
     * @param quantity
     */
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    // A generic convenience method.
    public static <T> CollectionData<T> list(Generator<T> gen, int quantity) {
        return new CollectionData<>(gen, quantity);
    }
}

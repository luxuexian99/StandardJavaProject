package org.hsian.thinkinjava.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections.nCopies();
 * Collections.fill();
 * Created by Hsian on 15/6/11.
 */
public class FillingLists {

    public static void main(String[] args) {
        List<StringAddress> list = new ArrayList<>(
            Collections.nCopies(4, new StringAddress("Hello"))
        );
        System.out.println(list);
        Collections.fill(list, new StringAddress("Hsian"));
        System.out.println(list);
    }
}

class StringAddress {
    private String s;

    public StringAddress(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return super.toString() + " " + s;
    }
}
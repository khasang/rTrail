package io.khasang.rtrail.model;

import java.util.Arrays;
import java.util.Vector;

public class UniversalEntity extends Vector {
    public UniversalEntity(int initialCapacity) {
        super(initialCapacity-1);
    }

    @Override
    public String toString() {
        return Arrays.toString(elementData) +
                "<br>";
    }
}

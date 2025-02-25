
package ch.epfl.sweng.contracts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.java.contract.Ensures;

public class SwengArrayList implements SwengVector {
    private int capacity;
    private int nextFreeSlot;
    private int[] elements;

    private void expandArray() {
        capacity *= 2;
        elements = Arrays.copyOf(elements, capacity);
        //nextFreeSlot--;
    }

    public SwengArrayList(int initial_capacity) {
        capacity = initial_capacity;
        elements = new int[initial_capacity];
        nextFreeSlot = 0;
    }

    public boolean contains(int element) {
        for (int i = 0; i < nextFreeSlot; ++i) {
            if (elements[i] == element) return true;
        }
        return false;
    }

    public int get(int i) {
        return elements[i];
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>(nextFreeSlot);
        for (int i = 0; i < nextFreeSlot; ++i) {
            list.add(elements[i]);
        }
        return list;
    }

    public void add(int element) {
        if (nextFreeSlot == capacity) {
            expandArray();
        }
        elements[nextFreeSlot++] = element;
    }
}

package az.edu.turing.module3.lesson04;

import az.edu.turing.module3.lesson04.exceptions.OutOfBoundCheckException;

import java.util.Arrays;

public class MyArrayList<E> {
    private Object[] object = new Object[0];
    private int size = 0;

    public void add(E t) {
        Object[] newObj = Arrays.copyOf(object, object.length + 1);
        newObj[newObj.length - 1] = t;

        object = newObj;

        size++;
    }

    public void set(int index, E t) {
        if (index < 0 || index >= size) {
            throw new OutOfBoundCheckException("size: " + size + " index: " + index);
        }

        object[index] = t;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new OutOfBoundCheckException("size: " + size + " index: " + index);
        }

        return (E) object[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new OutOfBoundCheckException("size: " + size + " index: " + index);
        }
        Object[] newObj = new Object[object.length - 1];
        for (int i = 0, j = 0; i < object.length; i++) {
            if (i != index) {
                newObj[j++] = object[i];
            }

        }
        object = newObj;

        size--;
    }


    public int size() {
        return size;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < object.length; i++) {
            if(i!=0){
                builder.append(",").append(object[i]);
            }else{
                builder.append(object[i]);
            }

        }

        builder.append("]");

        return "object=" + builder;
    }
}

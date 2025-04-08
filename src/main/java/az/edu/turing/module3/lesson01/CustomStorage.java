package az.edu.turing.module3.lesson01;


public class CustomStorage {
    private Object[] storage = new Object[0];

    public void add(Object a) {
        Object[] newStorage = new Object[storage.length + 1];

        for (int i = 0; i < storage.length; i++) {
            newStorage[i] = storage[i];
        }
        storage = newStorage;

        storage[storage.length - 1] = a;
    }

    public Object get(int index) {
        if (index >= storage.length) {
            System.out.println("index is higher than array length");
            return null;
        }

        return storage[index];
    }

    public void remove(int index) {
        Object[] newStorage = new Object[storage.length - 1];
        boolean isIndexSame = false;

        for (int i = 0; i < storage.length; i++) {
            if (i == index) {
                isIndexSame = true;
            } else {
                if (!isIndexSame) {
                    newStorage[i] = storage[i];
                } else {
                    newStorage[i] = storage[i + 1];
                }
            }

        }

        storage = newStorage;
    }


}

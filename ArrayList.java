import java.util.Iterator;

public class ArrayList<T> implements List<T> {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayList that = (ArrayList)o;
        if (this.size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!items[i].equals(that.items[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(T item) {

    }

    @Override
    public void clear() {
        
    }

    @Override
    public boolean contains(T item) {
        return false;
    }

    @Override
    public T get(int i) {
        return null;
    }

    @Override
    public int indexOf(T item) {
        return 0;
    }

    @Override
    public void removeAt(int i) {

    }

    @Override
    public void set(int i, T item) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

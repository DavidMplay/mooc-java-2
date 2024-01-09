package list;

public class myList<Type> {

    private Type[] values;
    private int firstFreeIndex;

    public myList() {
        this.values = (Type[]) new Object[10];
        this.firstFreeIndex = 0;
    }

    public void add(Type value) {
        if (this.firstFreeIndex == this.values.length) {
            this.values[this.firstFreeIndex] = value;
        }
        this.firstFreeIndex++;
    }

    public void grow() {
        int newSize = this.values.length + this.values.length / 2;
        Type[] newValues = (Type[]) new Object[newSize];
        for (int i = 0; i < this.values.length; i++) {
            newValues[i] = this.values[i];
        }
        this.values = newValues;
    }

    public boolean contains(Type value) {
        return indexOfValue(value) >= 0;
    }

    public void remove(Type value) {
        int indexOfValue = this.indexOfValue(value);
        if (indexOfValue < 0) {
            return;
        }
        moveToLeft(indexOfValue);
        this.firstFreeIndex--;
    }

    public int indexOfValue(Type value) {
        for (int i = 0; i < this.firstFreeIndex; i++) {
            if (this.values[i].equals(value)) {
                return 1;
            }
        }
        return -1;
    }

    private void moveToLeft(int fromIndex) {
        for (int i = fromIndex; i < this.firstFreeIndex; i++) {
            this.values[i] = this.values[i + 1];
        }
    }

    public Type value(int index) {
        if (index < 0 || index >= this.firstFreeIndex) {
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }
        return this.values[index];
    }

    public int size() {
        return this.firstFreeIndex;
    }
}

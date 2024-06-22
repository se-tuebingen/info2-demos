public class DynamicArrayOfInt {
    private int[] data;  // a partially filled array
    private int count = 0;  // num of valid elements

    public DynamicArrayOfInt(int initialCapacity) {
        data = new int[initialCapacity];
    }

    public int getVal(int position) {
        if (position >= count)
            return 0;
        return data[position];
    }

    public void putVal(int position, int value) {
        if (position >= data.length) {  // position not covered by current array size -> expand!
            int newSize = Math.max(2 * data.length, position + 1);
            int[] newData = new int[newSize];  // allocate a new array
            System.arraycopy(data, 0, newData, 0, data.length);  // copy data
            data = newData;  // set new reference
        }
        data[position] = value; // set the value at the requested position.
        if (position >= count)
            count = position + 1;
    }

    public void delete(int position) {
        if (position < count) {
            for (int i = position; i < count - 1; i++)
                data[i] = data[i + 1];
            count--;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int d : data) {
            sb.append(d);
            sb.append(", ");
        }
        return sb.toString();
    }

    public static DynamicArrayOfInt getReversedArray(DynamicArrayOfInt arr) {
        DynamicArrayOfInt rev = new DynamicArrayOfInt(arr.data.length);
        for (int i = 0; i < arr.count; i++) {
            rev.data[i] = arr.data[arr.count - 1 - i];
        }
        rev.count = arr.count;
        return rev;
    }

    public static void main(String[] args) {
        DynamicArrayOfInt arr = new DynamicArrayOfInt(1);
        for (int i = 0; i < 10; i++) {
            System.out.println("Status: " + arr);
            arr.putVal(i * 2, i + 1);
        }
        System.out.println("Final Status: " + arr);
        System.out.println("Reverse Status: " + DynamicArrayOfInt.getReversedArray(arr));
    }
}

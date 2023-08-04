// Define HoorayList to be a Generic class
// Accept any Reference Data Type

// E represents any type of element
public class HoorayList<E> {

    // Define fields
    private static final int DEFAULT_CAPACITY = 10;
    private int mCapacity;
    private int mSize;

    // Array of data
    private E[] mData;

    // Two constructors: default constructor + parameterized
    public HoorayList()
    {
        // Call the parameterized constructor in the same class
        // using keyword this:
        this(DEFAULT_CAPACITY);
    }

    public HoorayList(int initialCapacity)
    {
        mCapacity = initialCapacity;
        mSize = 0;
        //Have to do this because E is just a generic type and is not an 'actual' data type yet until specified
        mData = (E[]) new Object[mCapacity];
    }

    public E get(int index)
    {
        if (index < 0 || index >= mSize)
            throw new IndexOutOfBoundsException("Index must be between 0 and < " + mSize);
        return mData[index];
    }

    public E set(int index, E element)
    {
        if (index < 0 || index >= mSize)
            throw new IndexOutOfBoundsException("Index must be between 0 and < " + mSize);
        E temp = mData[index];
        mData[index] = element;
        // return the element that "was" at that index
        return temp;
    }

    public void ensureCapacity(int minCapacity)
    {
        if (minCapacity > mCapacity)
        {
            // Make a new array length (minCapacity)
            E[] newData = (E[]) new Object[minCapacity];
            // Filled with nulls (so far)

            // Copy old values to the new array
            for (int i = 0; i < mSize; i++) {
                newData[i] = mData[i];
            }

            // Update the capacity and the mData array
            mCapacity = minCapacity;
            mData = newData;
        }
    }

    public int indexOf(E element)
    {
        // Loop through mData array
        for (int i = 0; i < mSize; i++)
            if (element.equals(mData[i]))
                return i;

        // No match found
        return -1;
    }

    public boolean contains(E element)
    {
        return indexOf(element) >= 0;
    }

    public boolean add(int index, E element)
    {
        if (index < 0 || index > mSize)
            throw new IndexOutOfBoundsException("Index must be between 0 and " + mSize);

        // First we ensure the capacity
        if (mSize >= mCapacity)
            ensureCapacity(mCapacity * 2);
        // Shift (slide) everything down by one
        for (int i = mSize; i > index; i--)
            mData[i] = mData[i-1];

        mData[index] = element;
        // New element added,
        mSize++;
        return true;
    }

    public boolean add(E element)
    {
        return add(mSize, element);
    }

    public E remove (int index) {

        E temp = mData[index];

        for (int i = index; i < mSize; i++)
            mData[i] = mData[i+1];

        mData[mSize - 1] = null;
        //Element removed,
        mSize--;
        return temp;
    }

    public boolean remove(E element) {

        int index = indexOf(element);

        if (index == -1)
            return false;

        remove(index);

        return true;
    }

    public void clear() {
        //Wipe out all data
        //Either loop through the array and set all to nulls
        //Or create a new array with the same reference

        mData = (E[]) new Object[mCapacity];

        //Update mSize
        mSize = 0;
    }

    public int size() {
        return mSize;
    }

    @Override
    public String toString() {
        String output = "[";
        //Loop through data and concatenate it
        for (int i = 0; i < mSize; i++) {
            output += mData[i] + ", ";
        }
        output += "Hooray!]";
        return output;
    }

}

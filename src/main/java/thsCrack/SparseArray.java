package thsCrack;
//
//package com.olekdia.androidcollection;

public class SparseArray<E> implements Cloneable {

    private static final Object DELETED = new Object();
    private boolean mGarbage = false;

    private long[] mKeys;
    private Object[] mValues;
    private int mSize;

    public SparseArray() {
        this(10);
    }
    public static int idealIntArraySize(final int need) {
        return idealByteArraySize(need * 4) / 4;
    }
    public static int idealByteArraySize(final int need) {
        for (int i = 4; i < 32; i++)
            if (need <= (1 << i) - 12)
                return (1 << i) - 12;

        return need;
    }

    /**
     * Creates a new SparseArray containing no mappings that will not
     * require any additional memory allocation to store the specified
     * number of mappings.  If you supply an initial capacity of 0, the
     * sparse array will be initialized with a light-weight representation
     * not requiring any additional array allocations.
     */
    public SparseArray(int initialCapacity) {
        if (initialCapacity == 0) {
            mKeys = new long[]{};
            mValues = new Object[]{};
        } else {
            initialCapacity = idealIntArraySize(initialCapacity);
            mKeys = new long[initialCapacity];
            mValues = new Object[initialCapacity];
        }
        mSize = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SparseArray<E> clone() {
        SparseArray<E> clone = null;
        try {
            clone = (SparseArray<E>) super.clone();
            clone.mKeys = mKeys.clone();
            clone.mValues = mValues.clone();
        } catch (CloneNotSupportedException cnse) {
            /* ignore */
        }
        return clone;
    }

    /**
     * Gets the Object mapped from the specified key, or <code>null</code>
     * if no such mapping has been made.
     */
    public final E get(final long key) {
        return get(key, null);
    }

    /**
     * Gets the Object mapped from the specified key, or the specified Object
     * if no such mapping has been made.
     */
    public static int binarySearch(final long[] array, final int size, final long value) {
        int lo = 0;
        int hi = size - 1;

        int mid;
        long midVal;
        while (lo <= hi) {
            mid = (lo + hi) >>> 1;
            midVal = array[mid];

            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal > value) {
                hi = mid - 1;
            } else {
                return mid;  // value found
            }
        }
        return ~lo;  // value not present
    }

    @SuppressWarnings("unchecked")
    public final E get(final long key, final E valueIfKeyNotFound) {
        final int i =  binarySearch(mKeys, mSize, key);

        if (i < 0 || mValues[i] == DELETED) {
            return valueIfKeyNotFound;
        } else {
            return (E) mValues[i];
        }
    }

    /**
     * Removes the mapping from the specified key, if there was any.
     * @return true if item was found and deleted, false otherwise
     */
    public final boolean delete(final long key) {
        int i =  binarySearch(mKeys, mSize, key);

        if (i >= 0) {
            if (mValues[i] != DELETED) {
                mValues[i] = DELETED;
                mGarbage = true;
                return true;
            }
        }
        return false;
    }

    public final void remove(final long key) {
        delete(key);
    }

    /**
     * Removes the mapping at the specified index.
     */
    public final void removeAt(final int index) {
        if (mValues[index] != DELETED) {
            mValues[index] = DELETED;
            mGarbage = true;
        }
    }

    /**
     * Remove a range of mappings as a batch.
     *
     * @param index Index to begin at
     * @param size Number of mappings to remove
     */
    public final void removeAtRange(final int index, final int size) {
        final int end = Math.min(mSize, index + size);
        for (int i = index; i < end; i++) {
            removeAt(i);
        }
    }

    private void gc() {
        // Log.e("SparseArray", "gc start with " + mSize);

        final int n = mSize;
        int o = 0;
        final long[] keys = mKeys;
        final Object[] values = mValues;

        for (int i = 0; i < n; i++) {
            Object val = values[i];

            if (val != DELETED) {
                if (i != o) {
                    keys[o] = keys[i];
                    values[o] = val;
                    values[i] = null;
                }

                o++;
            }
        }

        mGarbage = false;
        mSize = o;
    }

    /**
     * Adds a mapping from the specified key to the specified value,
     * replacing the previous mapping from the specified key if there
     * was one.
     */
    public final void put(final long key, final E value) {
        int i =  binarySearch(mKeys, mSize, key);

        if (i >= 0) {
            mValues[i] = value;
        } else {
            i = ~i;

            if (i < mSize && mValues[i] == DELETED) {
                mKeys[i] = key;
                mValues[i] = value;
                return;
            }

            if (mGarbage && mSize >= mKeys.length) {
                gc();

                // Search again because indices may have changed.
                i = ~ binarySearch(mKeys, mSize, key);
            }

            if (mSize >= mKeys.length) {
                expandToCapacity(idealIntArraySize(mSize + 1));
            }

            if (mSize - i != 0) {
                System.arraycopy(mKeys, i, mKeys, i + 1, mSize - i);
                System.arraycopy(mValues, i, mValues, i + 1, mSize - i);
            }

            mKeys[i] = key;
            mValues[i] = value;
            mSize++;
        }
    }

    /**
     * Returns the number of key-value mappings that this SparseArray
     * currently stores.
     */
    public final int size() {
        if (mGarbage) gc();

        return mSize;
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, returns
     * the key from the <code>index</code>th key-value mapping that this
     * SparseArray stores.
     */
    public final long keyAt(final int index) {
        if (mGarbage) gc();

        return mKeys[index];
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, returns
     * the value from the <code>index</code>th key-value mapping that this
     * SparseArray stores.
     */
    @SuppressWarnings("unchecked")
    public final E valueAt(final int index) {
        if (mGarbage) gc();

        return (E) mValues[index];
    }

    /**
     * Given an index in the range <code>0...size()-1</code>, sets a new
     * value for the <code>index</code>th key-value mapping that this
     * SparseArray stores.
     */
    public final void setValueAt(final int index, final E value) {
        if (mGarbage) gc();

        mValues[index] = value;
    }

    /**
     * Returns the index for which {@link #keyAt} would return the
     * specified key, or a negative number if the specified
     * key is not mapped.
     */
    public final int indexOfKey(final long key) {
        if (mGarbage) gc();

        return binarySearch(mKeys, mSize, key);
    }

    /**
     * Returns an index for which {@link #valueAt} would return the
     * specified key, or a negative number if no keys map to the
     * specified value.
     * <p>Beware that this is a linear search, unlike lookups by key,
     * and that multiple keys can map to the same value and this will
     * find only one of them.
     * <p>Note also that unlike most collections' {@code indexOf} methods,
     * this method compares values using {@code ==} rather than {@code equals}.
     */
    public final int indexOfValue(final E value) {
        if (mGarbage) gc();

        for (int i = 0; i < mSize; i++)
            if (mValues[i] == value) return i;

        return -1;
    }

    public final int indexOfEqualValue(final E value) {
        if (mGarbage) gc();

        if (value == null) {
            for (int i = 0; i < mSize; i++)
                if (mValues[i]== null) return i;
        } else {
            for (int i = 0; i < mSize; i++)
                if (value.equals(mValues[i])) return i;
        }

        return -1;
    }

    /**
     * Removes all key-value mappings from this SparseArray.
     */
    public final void clear() {
        final int n = mSize;
        final Object[] values = mValues;

        for (int i = 0; i < n; i++) {
            values[i] = null;
        }

        mSize = 0;
        mGarbage = false;
    }

    /**
     * Puts a key/value pair into the array, optimizing for the case where
     * the key is greater than all existing keys in the array.
     */
    public final void append(final long key, final E value) {
        if (mSize != 0 && key <= mKeys[mSize - 1]) {
            put(key, value);
            return;
        }

        if (mGarbage && mSize >= mKeys.length) gc();

        final int pos = mSize;
        if (pos >= mKeys.length) {
            expandToCapacity(idealIntArraySize(pos + 1));
        }

        mKeys[pos] = key;
        mValues[pos] = value;
        mSize = pos + 1;
    }

    /**
     * Increases the size of the underlying storage if needed, to ensure that it can
     * hold the specified number of items without having to allocate additional memory
     * @param capacity the number of items
     */
    public final void ensureCapacity(final int capacity) {
        if (mGarbage && mSize >= mKeys.length) gc();

        if (mKeys.length < capacity) {
            expandToCapacity(capacity);
        }
    }

    private void expandToCapacity(final int capacity) {
        final long[] nkeys = new long[capacity];
        final Object[] nvalues = new Object[capacity];

        System.arraycopy(mKeys, 0, nkeys, 0, mKeys.length);
        System.arraycopy(mValues, 0, nvalues, 0, mValues.length);

        mKeys = nkeys;
        mValues = nvalues;
    }
}
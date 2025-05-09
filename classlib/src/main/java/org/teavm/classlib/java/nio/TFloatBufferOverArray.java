/*
 *  Copyright 2014 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.classlib.java.nio;

class TFloatBufferOverArray extends TFloatBufferImpl {
    private boolean readOnly;
    private int start;
    private int capacity;
    private float[] array;

    public TFloatBufferOverArray(int capacity) {
        this(0, capacity, new float[capacity], 0, capacity, false);
    }

    public TFloatBufferOverArray(int start, int capacity, float[] array, int position, int limit, boolean readOnly) {
        super(position, limit);
        this.start = start;
        this.capacity = capacity;
        this.readOnly = readOnly;
        this.array = array;
    }

    @Override
    TFloatBuffer duplicate(int start, int capacity, int position, int limit, boolean readOnly) {
        return new TFloatBufferOverArray(this.start + start, capacity, array, position, limit, readOnly);
    }

    @Override
    int capacityImpl() {
        return capacity;
    }

    @Override
    float getElement(int index) {
        return array[index + start];
    }

    @Override
    void putElement(int index, float value) {
        array[index + start] = value;
    }

    @Override
    boolean isArrayPresent() {
        return true;
    }

    @Override
    float[] getArray() {
        return array;
    }

    @Override
    int getArrayOffset() {
        return start;
    }

    @Override
    boolean readOnly() {
        return readOnly;
    }

    @Override
    public TByteOrder order() {
        return TByteOrder.nativeOrder();
    }

    @Override
    void getImpl(int index, float[] dst, int offset, int length) {
        System.arraycopy(array, start + index, dst, offset, length);
    }

    @Override
    void putImpl(int index, float[] src, int offset, int length) {
        System.arraycopy(src, offset, array, start + index, length);
    }

    @Override
    void putImpl(int index, TFloatBuffer src, int offset, int length) {
        if (src.hasArray()) {
            System.arraycopy(src.array(), src.arrayOffset() + offset, array, start + index, length);
        } else {
            while (length-- > 0) {
                src.putElement(offset++, getElement(index++));
            }
        }
    }
}

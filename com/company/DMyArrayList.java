package com.company;

import java.util.Collection;

public class DMyArrayList<T> implements MyList<T>
{
    private Object[] arr;
    private int size;

    public DMyArrayList(){
        this.arr = (Object[]) new Object[5];
        this.size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void add(T item) {
        if(size == arr.length){
            increaseBuffer();
        }
        arr[size++] = item;
    }
    private void increaseBuffer(){
        Object[] newArr = (Object[]) new Object[arr.length*2];
        for(int i=0; i<size; i++){
            newArr[i]=arr[i];
        }
        arr = newArr;
    }
    @Override
    public void add(T item, int index) {
        checkIndex(index);
        if(size == arr.length){
            increaseBuffer();
        }
        for(int i = size -1 ; i>= index; i--){
            arr[i] = arr[i+1];
        }
        arr[index] = item;
        size++;
    }
    private void checkIndex(int index){
        if(index<0 && index>=size){
            System.out.println("Index does not exist");
        }
    }

    public void addAll(Collection<? extends T> collection)
    {
        addAll(size, collection);
    }

    public void addAll(int index, Collection<? extends T> collection)
    {
        checkIndex(index);

        int addNum=collection.size();

        for (int i=size-1; i>=index; i--)
        {
            arr[i+addNum]=arr[i];
        }

        int i=index;
        for (T item : collection)
        {
            arr[i++]=item;
        }

    }

    @Override
    public boolean remove(T item) {
        int index=0;
        boolean found = false;
        for(int i=0; i<size; i++){
            if(arr[i]==item){
                index = i;
                found=true;
                break;
            }
        }
        if(found){
            remove(index);
        }
        return found;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedItem= (T) arr[index];
        for(int i=index; i<size-1; i++){
            arr[i] = arr[i+1];
        }
        arr[size-1]=null;
        size--;
        return removedItem;
    }

    @Override
    public void clear() {
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }

    @Override
    public Object get(int index) {
        return arr[index];
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
}

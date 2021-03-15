package com.andreubita.poo.ficha2;

public class Ex01 {

    public static void main(String[] args) {
        Ex01 ex01 = new Ex01();
        int[] arr = new int[10];
        int size = 0;
        for (int i = 10; i > 0; i--)
            arr[size++] = i;
    }

    public int getMin(int[] arr, int size){
        int min = Integer.MAX_VALUE;
        if(size == 0) return min; // Empty array = Integer.MAX_VALUE*
        for (int i = 0; i < size; i++)
            if(arr[i] < min)
                min = arr[i];
        return min;
    }

    public int[] common(int[] arr1, int size1, int[] arr2, int size2){
        int[] res = new int[Math.min(size1, size2)];
        int sizeRes = 0;
        for(int i = 0; i < Math.min(size1, size2); i++){
            if(size1 < size2){
                if(contains(arr2, size2, arr1[i]))
                    res[sizeRes++] = arr1[i];
            }else{
                if(contains(arr1, size1, arr2[i]))
                    res[sizeRes++] = arr2[i];
            }
        }
        return res;
    }

    public boolean contains(int[] arr, int size, int n){
        for (int i = 0; i < size; i++)
            if(arr[i] == n) return true;
        return false;
    }
}

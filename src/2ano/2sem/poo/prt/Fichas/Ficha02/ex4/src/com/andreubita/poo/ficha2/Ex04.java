package com.andreubita.poo.ficha2;

import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) {
    }

    /**
     * Sorts an array of ints
     *
     * @param arr array to be sorted
     * @param size array length
     */
    public int[] sort(int[] arr, int size){
        int[] sorted = Arrays.copyOf(arr, size);
        for(int i = size; i > 0; i--){
            if(biggestIndex(sorted, i) == i) continue;
            swap(arr, i, biggestIndex(sorted, i));
        }
        return sorted;
    }

    /**
     * Sorts an array of ints
     * (Alternative)
     *
     * @param arr array to be sorted
     */
    public int[] sort(int[] arr){
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        return sorted;
    }

    /**
     * Gets the index of the biggest int
     * of a certain array
     *
     * @param arr array to get the biggest int
     * @param size array length
     * @return index of the biggest int
     */
    public int biggestIndex(int[] arr, int size){
        int biggest = 0;
        for (int i = 0; i < size; i++)
            if(arr[biggest] < arr[i]) biggest = i;
        return biggest;
    }

    /**
     * Swap two elements of array
     *
     * @param arr array to swap elements
     * @param x first position
     * @param y second position
     */
    public void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    /**
     * Binary Search an element
     * (Alternative)
     *
     * @param arr array to search on
     * @param size array length
     * @param elem element to be searched
     * @return the index of the element
     */
    public int binarySearch(int[] arr, int size, int elem){
        int res = Integer.MAX_VALUE;
        int[] sortedArr = sort(arr, size);
        int i = 0, j = size;
        while(i <= j){
            int z = (i+j)/2;
            if(sortedArr[z] < elem) i = z + 1;
            else if(sortedArr[z] > elem) j = z - 1;
            else if(sortedArr[z] == elem){
                res = z;
                break;
            }
        }
        return res;
    }

    /**
     * Binary Search an element
     * (Alternative)
     *
     * @param arr array to search on
     * @param elem element to be searched
     * @return the index of the element
     */
    public int binarySearch(int[] arr, int elem){
        return Arrays.binarySearch(arr, elem);
    }
}

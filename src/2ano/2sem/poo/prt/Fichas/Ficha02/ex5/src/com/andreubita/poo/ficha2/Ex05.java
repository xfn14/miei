package com.andreubita.poo.ficha2;

import java.util.Arrays;

public class Ex05 {
    public static void main(String[] args) {

    }

    /**
     * Check if an array contains an element
     *
     * @param arr array to search on
     * @param size array length
     * @param str String to search
     * @return if array contains str or not
     */
    public boolean contains(String[] arr, int size, String str){
        for (int i = 0; i < size; i++)
            if(arr[i].equals(str)) return true;
        return false;
    }

    /**
     * Get biggest String of array
     *
     * @param arr array to search on
     * @param size array length
     * @return biggest String found
     */
    public String biggest(String[] arr, int size){
        String res = "";
        for (int i = 0; i < size; i++)
            if(res.length() < arr[i].length())
                res = arr[i];
        return res;
    }

    /**
     * Remove duplicates from array
     *
     * @param arr array to remove dupes
     * @param size array length
     * @return new array without duplicates
     */
    public String[] remDupes(String[] arr, int size){
        String[] res = new String[size];
        int resSize = 0;
        for (int i = 0; i < size; i++)
            if(!contains(res, resSize, arr[i]))
                res[resSize++] = arr[i];
        return Arrays.copyOf(res, resSize);
    }

    /**
     * Get duplicate String on array
     *
     * @param arr array to get the duplicates
     * @param size array length
     * @return array with the duplicates
     */
    public String[] dupes(String[] arr, int size){
        String[] res = new String[size];
        int resSize = 0;
        for (int i = 0; i < size; i++)
            if(occurrences(arr, size, arr[i]) > 1 &&
            !contains(res, resSize, arr[i]))
                res[resSize++] = arr[i];
        return Arrays.copyOf(res, resSize);
    }

    /**
     * Count the number of occurrences of
     * a String in an array
     *
     * @param arr array to count String from
     * @param size array length
     * @param str String to count occurrences
     * @return number of occurrences
     */
    public int occurrences(String[] arr, int size, String str){
        int occur = 0;
        for (int i = 0; i < size; i++)
            if(arr[i].equals(str)) occur++;
        return occur;
    }
}

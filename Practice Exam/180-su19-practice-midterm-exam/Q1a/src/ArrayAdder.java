
/**
 * ArrayAdder contains utility functions to add certain numbers in an array.
 */
public final class ArrayAdder {

    /**
     * This method adds the first and last element of the given array.
     *
     * If the array is empty or null, return -1
     *
     * If the array only has 1 element, just return that value.
     *
     * @param arr - the array we want to add numbers from.
     * @return The sum of the first and last element in the array.
     */

    public int addEnds(int[] arr) {
        if (arr == null){
            return -1;
        } else if (arr.length == 0){
            return -1;
        }

        int first = arr[0];
        int last = arr[arr.length-1];

        if (arr.length == 1){
            return arr[0];
        } else {
            return first + last;
        }



    }

    /**
     * This method adds the smallest and largest element of the given array.
     *
     * If the array is empty or null, return -1
     *
     * If the array only has 1 element, just return that value.
     *
     * You may assume that each number is unique in the given array.
     *
     * @param arr - the array we want to add numbers from.
     * @return The sum of the smallest and largest element in the array.
     */
    public int addMinMax(int[] arr) {
        if (arr == null){
            return -1;
        } else if (arr.length == 0){
            return -1;
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i<arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
            if (max < arr[i]){
                max = arr[i];
            }
        }
        if (arr.length == 1){
            return arr[0];
        } else {
            return max + min;
        }

    }

}
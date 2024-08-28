import java.util.Arrays;

public class Solution {
    public static int Soln(int arr[] , int target){
        int array[] = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            array[i] = Math.abs(arr[i]-target);
        }
        int min = Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                index = i;
                break;
            }
        }
        return arr[index];
    }

    public static void main(String[] args) {
        int array[] = {2,5,6,7,8,8,9};
        int target = 11;
        System.out.println(Soln(array,target));
    }
}

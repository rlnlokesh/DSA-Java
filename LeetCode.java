import java.lang.reflect.Array;
import java.util.Arrays;

public class LeetCode {
    public static void main(String[] args) {
        int[] arr={3,3,3,3};
        int P=3;
        int N=4;
        frequencyCount(arr,N,P);

    }
    public static void frequencyCount(int arr[], int N, int P) {
        int[] freq= new int[N];
        for(int i=0;i<N;i++){
            freq[i]=0;
        }

        for(int j=0;j<N;j++){
            freq[arr[j]-1]++;
            System.out.println(Arrays.toString(freq));
        }
        arr=freq;
    }
}

package src.Array.Easy;

public class LargestEle {

    static int largestEle(int[] arr){
        int max = arr[0];
        for(int i : arr){
            if(i > max)
                max = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,8,4,3,2};
        int ans = largestEle(arr);
        System.out.println(ans);
    }
}

package src.Array.Easy;

public class SecondLargestEle {
    static int secLargestEle(int[] arr){
        int max = arr[0];
        int max2 = arr[1];
        for(int i : arr){
            if(i > max){
                max2 = max;
                max = i;
            }
            else if(i > max2 && i != max)
                max2 = i;
        }
        return max2;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,6,2,8,4,3,2};
        int ans = secLargestEle(arr);
        System.out.println(ans);
    }
}

package src.BinarySearchAlgo;

public class Search_Insert {

    static int searchInsert(int[] arr, int x){
        int l = 0;
        int h = arr.length - 1;
        int ans = arr.length;
        while (l<=h){
            int m = (l+h)/2;
            if(arr[m] >= x){
                ans=m;
                h = m-1;
            }
            else{
                l=m+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 6;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);
    }
}

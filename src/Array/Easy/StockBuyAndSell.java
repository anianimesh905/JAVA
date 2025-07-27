package src.Array.Easy;

public class StockBuyAndSell {

//    static void stockBuyandSell(int[] arr){
//        int diff;
//        int f = 0;
//        int s = 0;
//        int max = arr[1] - arr[0];
//        for (int i = 0; i<arr.length; i++){
//            for (int j = i+1; j< arr.length; j++){
//                diff = arr[j] - arr[i];
//                if (diff > max){
//                    max = diff;
//                    f=i;
//                    s=j;
//                }
//            }
//        }
//        System.out.println(arr[s] - arr[f]);
//    }

    static void stockBuyandSell(int[] arr){
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i<arr.length; i++){
            minPrice = Math.min(minPrice, arr[i]);
            maxProfit = Math.max(maxProfit, arr[i] - minPrice);
        }
        System.out.println(maxProfit);
    }

    public static void main(String[] args) {
        int[] stock = {7,1,5,3,6,4};
        stockBuyandSell(stock);
        int[] stock1 = {7,6,4,3,1};
        stockBuyandSell(stock1);
    }
}

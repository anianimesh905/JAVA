package src.Array.Easy;

public class DeleteDuplicate {
    static void deleteDup(int[] num){
        int i = 0;
        for (int j = 1; j < num.length; j++){
            if(num[i] != num[j]){
                i++;
                num[i] = num[j];
            }
        }
        for (int j = 0; j<=i ; j++)
            System.out.print(num[j] + " ");
    }
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 4, 4, 5};
        deleteDup(num);
    }
}

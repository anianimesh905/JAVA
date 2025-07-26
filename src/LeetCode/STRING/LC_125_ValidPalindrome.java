package src.LeetCode.STRING;

public class LC_125_ValidPalindrome {

    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;

        while(left < right){

            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);

            if(!Character.isLetterOrDigit(charLeft)){
                left++;
                continue; // jumps to the top for next iteration
            }

            if(!Character.isLetterOrDigit(charRight)){
                right--;
                continue; // jumps to the top for next iteration
            }

            if(Character.toLowerCase(charLeft) != Character.toLowerCase(charRight))
                return false;

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = " ";

        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(s3));
    }
}

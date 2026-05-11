package codes.c125;

public class IsPalindrome {

    public static boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char a = s.charAt(l);
            char b = s.charAt(r);
            if (!Character.isLetterOrDigit(a)) l++;
            else if (!Character.isLetterOrDigit(b)) r--;
            else {
                if (a != b) return false;
                l++;
                r--;
            }
        }
        return true;
    }

}
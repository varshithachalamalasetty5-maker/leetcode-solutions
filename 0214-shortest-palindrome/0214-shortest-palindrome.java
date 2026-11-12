class Solution {
    public String shortestPalindrome(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String str = s + "#" + rev;

        int n = str.length();
        int[] lps = new int[n];

        for (int i = 1; i < n; i++) {
            int j = lps[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = lps[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }

            lps[i] = j;
        }

        int palLength = lps[n - 1];

        return rev.substring(0, s.length() - palLength) + s;
    }
}

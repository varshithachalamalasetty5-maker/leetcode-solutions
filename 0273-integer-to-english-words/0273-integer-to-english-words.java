class Solution {

    String[] belowTwenty = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen",
        "Fourteen", "Fifteen", "Sixteen",
        "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {

        if (num == 0)
            return "Zero";

        int i = 0;
        String result = "";

        while (num > 0) {

            if (num % 1000 != 0) {

                result = helper(num % 1000)
                    + (thousands[i].isEmpty() ? "" : " " + thousands[i])
                    + (result.isEmpty() ? "" : " " + result);
            }

            num = num / 1000;
            i++;
        }

        return result;
    }

    private String helper(int num) {

        if (num == 0)
            return "";

        if (num < 20)
            return belowTwenty[num];

        if (num < 100)
            return tens[num / 10]
                + (num % 10 == 0 ? "" : " " + helper(num % 10));

        return belowTwenty[num / 100] + " Hundred"
            + (num % 100 == 0 ? "" : " " + helper(num % 100));
    }
}
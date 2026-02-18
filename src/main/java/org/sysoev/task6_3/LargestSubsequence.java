package org.sysoev.task6_3;

public class LargestSubsequence {

    public static String largestSubsequence(String firstString, String secondString) {

        int firstStringLen = firstString.length();
        int secondStringLen = secondString.length();

        int[][] dp = new int[firstStringLen + 1][secondStringLen + 1];

        for (int i = 1; i <= firstStringLen; i++) {
            for (int j = 1; j <= secondStringLen; j++) {
                if (firstString.charAt(i - 1) == secondString.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder result = new StringBuilder();

        while (firstStringLen > 0 && secondStringLen > 0) {
            if (firstString.charAt(firstStringLen - 1) == secondString.charAt(secondStringLen - 1)) {
                result.append(firstString.charAt(firstStringLen - 1));
                firstStringLen--;
                secondStringLen--;
            } else if (dp[firstStringLen - 1][secondStringLen] >= dp[firstStringLen][secondStringLen - 1]) {
                firstStringLen--;
            } else {
                secondStringLen--;
            }
        }

        return result.reverse().toString();
    }
}

package org.sysoev.task6_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestSubsequenceTest {

    @Test
    void largestSubsequence() {
        String largestSubsequence =  LargestSubsequence.largestSubsequence("abcde", "ace");
        assertEquals("ace", largestSubsequence);
    }
}
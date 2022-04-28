package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;

public class Ex_9_3_substring {

    /**
     * Finds substrings that are common in two strings.
     * <p>
     * Implementation uses dynamic programming.
     *
     * @param a First string to compare.
     * @param b Second string to compare.
     * @return List of substrings that are common in both strings (in no particular order).
     * Ignores shorter substrings that are fully within other longer substrings.
     */
    @Nonnull
    public List<CommonSubstring> findCommonSubstrings(@Nonnull String a, @Nonnull String b) {
        List<CommonSubstring> result = new LinkedList<>();
        int[][] substringsLength = new int[a.length()][];
        for (int aIndex = 0; aIndex < a.length(); aIndex++) {
            substringsLength[aIndex] = new int[b.length()];
            for (int bIndex = 0; bIndex < b.length(); bIndex++) {
                if (a.charAt(aIndex) == b.charAt(bIndex)) {
                    int previousSubstringLength = aIndex > 0 && bIndex > 0
                            ? substringsLength[aIndex - 1][bIndex - 1]
                            : 0;
                    substringsLength[aIndex][bIndex] = previousSubstringLength + 1;
                }
            }
        }
        // Common substrings grow in the direction of bottom right.
        // So we start from there to see where the longest common substrings end.
        // Once we know substring length and position where it ends, we can easily calculate where it starts.
        for (int aIndex = a.length() - 1; aIndex >= 0; aIndex--) {
            for (int bIndex = b.length() - 1; bIndex >= 0; bIndex--) {
                int currentSubstringLength = substringsLength[aIndex][bIndex];
                if (currentSubstringLength > 0) {
                    // If we're not at an edge, then we could have already reported this substring
                    // at the previous iteration.
                    if (aIndex < a.length() - 1 && bIndex < b.length() - 1) {
                        // If substring grows in the next letter, then we have already reported it
                        // because we have started from bottom right where
                        // we have longest substrings.
                        if (substringsLength[aIndex + 1][bIndex + 1] == currentSubstringLength + 1) {
                            continue;
                        }
                    }
                    // If next row leads to a longer substring in a then ignore this shorter substring
                    // that is fully within next longer substring.
                    if (aIndex < a.length() - 1) {
                        if (substringsLength[aIndex + 1][bIndex] > currentSubstringLength) {
                            continue;
                        }
                    }
                    // If next column leads to a longer substring in b then ignore this shorter substring
                    // that is fully within next longer substring.
                    if (bIndex < b.length() - 1) {
                        if (substringsLength[aIndex][bIndex + 1] > currentSubstringLength) {
                            continue;
                        }
                    }
                    int aStart = aIndex - currentSubstringLength + 1;
                    int bStart = bIndex - currentSubstringLength + 1;
                    result.add(new CommonSubstring(aStart, bStart, currentSubstringLength));
                }
            }
        }
        return result;
    }

    /**
     * Information about substring that is common in two stings.
     *
     * @param startInA Start of substring in first string.
     * @param startInB Start of substring in second string.
     * @param length   Length of common substring.
     */
    public record CommonSubstring(int startInA, int startInB, int length) {
    }

}

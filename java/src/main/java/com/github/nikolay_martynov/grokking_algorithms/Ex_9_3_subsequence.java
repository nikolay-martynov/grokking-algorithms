package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;

public class Ex_9_3_subsequence {

    /**
     * Finds a sequence of letters that are common for two strings.
     * <p>
     * Implementation uses dynamic programming.
     *
     * @param a First string to compare.
     * @param b Second string to compare.
     * @return The outer array contains two elements that represent first and second strings.
     * Inner arrays have equal length and represent sequences of letters that are in the same order
     * in both strings.
     * Each element of inner array is an index of a common letter in a source string.
     * If there is no common sequence, then inner arrays will be empty.
     * Example: a=ABCEF, b=ACDFG, common sequence is A then C then F, result=[[0,2,4],[0,1,3]]
     */
    @Nonnull
    public int[][] findCommonSubsequence(@Nonnull String a, @Nonnull String b) {
        // We do not really need this table if we just remember when we detect
        // that matching subsequence has become longer, but the exercise is about dynamic programming.
        int[][] sequenceLength = new int[a.length()][];
        for (int aIndex = 0; aIndex < a.length(); aIndex++) {
            sequenceLength[aIndex] = new int[b.length()];
            for (int bIndex = 0; bIndex < b.length(); bIndex++) {
                int newSequenceLength = 0;
                // Increase sequence length if letters match.
                if (a.charAt(aIndex) == b.charAt(bIndex)) {
                    int previousSubstringLength = aIndex > 0 && bIndex > 0 ? sequenceLength[aIndex - 1][bIndex - 1] : 0;
                    newSequenceLength = previousSubstringLength + 1;
                }
                // Maybe we already have a longer sequence in a.
                if (aIndex > 0) {
                    newSequenceLength = Integer.max(newSequenceLength, sequenceLength[aIndex - 1][bIndex]);
                }
                // Maybe we already have a longer sequence in b.
                if (bIndex > 0) {
                    newSequenceLength = Integer.max(newSequenceLength, sequenceLength[aIndex][bIndex - 1]);
                }
                sequenceLength[aIndex][bIndex] = newSequenceLength;
            }
        }
        int[][] result = new int[2][];
        int maxSequenceLength = a.length() > 0 && b.length() > 0 ? sequenceLength[a.length() - 1][b.length() - 1] : 0;
        result[0] = new int[maxSequenceLength];
        result[1] = new int[maxSequenceLength];
        // Since it's all about the table, let's re-detect when a sequence has grown.
        // This would mean the next common letter.
        // We could have just accumulated the result when we have scanned source strings,
        // but then it would not be what the exercise is about.
        int sequenceIndex = 0;
        for (int aIndex = 0; aIndex < a.length() && sequenceIndex < maxSequenceLength; aIndex++) {
            // Makes no sense to check the beginning of b that is shorter than the next letter of the common sequence.
            int bSearchStart = sequenceIndex > 0 ? result[1][sequenceIndex - 1] + 1 : 0;
            for (int bIndex = bSearchStart; bIndex < b.length(); bIndex++) {
                // We search where sequence length increases.
                if (sequenceLength[aIndex][bIndex] == sequenceIndex + 1) {
                    result[0][sequenceIndex] = aIndex;
                    result[1][sequenceIndex] = bIndex;
                    sequenceIndex++;
                    // We do not need to scan for the rest of b because we need the next letter from a
                    // for the sequence to be able to grow.
                    break;
                }
            }
        }
        return result;
    }

}

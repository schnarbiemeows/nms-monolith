package com.schnarbiesnmeowers.nmsmonolith.utilities;

public class NumberUtility {

    public static int[] toIntArr(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }
}

package com.example.dsa.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class EncodeDecodeString {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("neet", "codee", "lov", "youu");
        System.out.println("Input list : " + stringList);
        String encodeResult = encode(stringList);
        System.out.println("Encode : " + encodeResult);
        List<String> decodeResult = decode(encodeResult);
        System.out.println("Decode : " + decodeResult);
    }

    //Optimal Solution
    //Time Complexity - O(m) for each encode() and decode() function call
    //Space Complexity - O(m+n) each encode() and decode() function call
    public static String encode(List<String> StringList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : StringList) {
            stringBuilder.append(str.length()).append("#").append(str);
        }
        return stringBuilder.toString();
    }

    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;

            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            list.add(str.substring(i, j));
            i = j;
        }
        return list;
    }
}

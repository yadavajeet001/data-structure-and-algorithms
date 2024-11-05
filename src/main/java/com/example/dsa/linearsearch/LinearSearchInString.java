package com.example.dsa.linearsearch;

public class LinearSearchInString {
    public static void main(String[] args) {
        String name = "Ajeet";
        char target = 'e';
        System.out.println(search(name, target));
        System.out.println(search2(name, target));
    }

    static boolean search(String s, char target) {
        if (s.isEmpty()) {
            return false;
        }
        for (char element : s.toCharArray()) {
            if (element == target)
                return true;
        }
        return false;
    }

    //second way
    static boolean search2(String s, char target) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (target == s.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}

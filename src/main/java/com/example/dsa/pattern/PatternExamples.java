package com.example.dsa.pattern;

public class PatternExamples {
    public static void main(String[] args) {
        System.out.println("------------Pattern-2--------------");
        pattern2();
        System.out.println("------------Pattern-1--------------");
        pattern1();
        System.out.println("------------Pattern-3--------------");
        pattern3();
        System.out.println("------------Pattern-5--------------");
        pattern5();
        System.out.println("------------Pattern-28--------------");
        pattern28(5);
        System.out.println("------------Pattern-17--------------");
        pattern17(5);
        System.out.println("------------Pattern-36--------------");
        pattern36(4);
        System.out.println("------------Pattern-31--------------");
        pattern31(4);
    }

    private static void pattern1() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern2() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col <= 5; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern3() {
        for (int row = 0; row < 5; row++) {
//            for (int col = 5; col > row; col--) {
//                System.out.print("*");
//            }
//or
            for (int col = 0; col < 5 - row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void pattern5() {
        for (int row = 0; row < 2 * 5; row++) {
            int totalColInRow = row > 5 ? 2 * 5 - row : row;
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern17(int n) {
        //outer loop - check how many number of rows are there
        for (int row = 0; row < 2 * n; row++) {

            int totalColInRow = row > n ? 2 * n - row : row;
            int noOfSpaces = n - totalColInRow;

            //run a loop to print the spaces
            for (int space = 0; space < noOfSpaces; space++) {
                System.out.print(" ");
            }
            //inner loop - check how many number of columns are there
            for (int col = 0; col < totalColInRow; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void pattern28(int n) {
        //outer loop - check how many number of rows are there
        for (int row = 1; row <= n; row++) {

            int noOfSpaces = n - row;

            //run a loop to print the spaces
            for (int space = 1; space <= noOfSpaces; space++) {
                System.out.print(" ");
            }
            //inner loop - check how many number of columns are there
            for (int col = row; col >= 1; col--) {
                System.out.print(col + " ");
            }

            // print the number start from 2 to row
            for (int col = 2; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    private static void pattern36(int n) {
        //outer loop - check how many number of rows are there
        n = 2 * n;
        for (int row = 0; row <= n; row++) {

            //inner loop - check how many number of columns are there
            for (int col = 0; col <= n; col++) {

                //check what needs to print, find the relation between row, column and n
                int valueAtEveryIndex = Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(valueAtEveryIndex + " ");
            }
            //for new line
            System.out.println();
        }
    }

    private static void pattern31(int n) {

        //outer loop - check how many number of rows are there
        for (int row = 0; row <= 2 * n; row++) {

            //inner loop - check how many number of columns are there
            for (int col = 0; col <= 2 * n; col++) {

                //check what needs to print, find the relation between row, column and n
                int valueAtEveryIndex = n - Math.min(Math.min(row, col), Math.min(2 * n - row, 2 * n - col));

                //condition to print 1 at the place of 0
                int indexValue = valueAtEveryIndex == 0 ? 1 : valueAtEveryIndex;

                System.out.print(indexValue + " ");
            }
            //for new line
            System.out.println();
        }
    }
}

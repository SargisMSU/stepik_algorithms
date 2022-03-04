package common_divisor;

import java.util.Scanner;

/**
 * По данным двум числам a, b
 *   найдите их наибольший общий делитель.
 * */

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(greatestCommonDivisor(a, b));
    }

    private static int greatestCommonDivisor(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        if (a > b){
            return greatestCommonDivisor(a % b, b);
        }else {
            return greatestCommonDivisor(a, b % a);
        }
    }
}

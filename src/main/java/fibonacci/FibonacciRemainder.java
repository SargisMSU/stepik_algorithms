package fibonacci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 Даны целые числа n и m
 , необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * */
public class FibonacciRemainder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();
        System.out.println("(" + n + " " + m + ") -> " + fibonacci(n, m));
    }

    private static BigInteger fibonacci(BigInteger n, BigInteger m) {
        BigInteger a1 = BigInteger.valueOf(0);
        BigInteger a2 = BigInteger.valueOf(1);
        List<BigInteger> cash = new ArrayList<>();
        cash.add(a1);
        cash.add(a2);
        for (int i = 0; i < (n.intValue()) - 2; i++) {
            BigInteger newValue = (a1.add(a2)).mod(m);
            a1 = a2;
            a2 = newValue;
            if (a1.equals(BigInteger.ZERO) && a2.equals(BigInteger.ONE)){
                cash = cash.subList(0, cash.size() - 1);
                break;
            }else {
                cash.add(a2);
            }
        }
        System.out.println("cash.size() = " + cash.size());
        int index = n.mod(BigInteger.valueOf(cash.size())).intValue();
        return cash.get(index);
    }
}

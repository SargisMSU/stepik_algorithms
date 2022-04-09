package common_divisor;

import java.util.function.*;

class Main {

    public static void main(String[] args) {

        BiFunction<String, String, Integer> biFunction = f1(x -> x.equals("Java") ? 1996 : 1985);
        Supplier<String> supplier = f2(biFunction, x -> x + 18);
        String message = supplier.get();

        System.out.println(message);
    }

    public static BiFunction<String, String, Integer> f1(Function<String, Integer> f) {
        return (a, b) -> f.apply(a + b);
    }

    public static Supplier<String> f2(BiFunction<String, String, Integer> f, IntUnaryOperator g) {
        return () -> "Java 8 was released in " + g.applyAsInt(f.apply("Ja", "va"));
    }
}
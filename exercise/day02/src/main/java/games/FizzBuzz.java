package games;

public class FizzBuzz {
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 100;
    public static final String FIZZ = "Fizz";
    public static final String BUZZ = "Buzz";
    public static final int BUZZ_MULTIPLE = 5;
    public static final int FIZZ_MULTIPLE = 3;

    private FizzBuzz() {
    }

    public static String convert(Integer input) throws OutOfRangeException {
        if (isOutOfRange(input)) throw new OutOfRangeException();
        if (isFizz(input) && isBuzz(input)) {
            return FIZZ + BUZZ;
        }
        if (isFizz(input)) {
            return FIZZ;
        }
        if (isBuzz(input)) {
            return BUZZ;
        }
        return input.toString();
    }

    private static boolean isOutOfRange(Integer input) {
        return input <= MIN_RANGE || input > MAX_RANGE;
    }

    private static boolean isBuzz(Integer input) {
        return input % BUZZ_MULTIPLE == 0;
    }

    private static boolean isFizz(Integer input) {
        return input % FIZZ_MULTIPLE == 0;
    }
}

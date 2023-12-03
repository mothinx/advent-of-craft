package games;

public class FizzBuzz {
    public static final int MIN_RANGE = 0;
    public static final int MAX_RANGE = 100;

    private static final Rule[] rules = new Rule[]{
            new FizzBuzzRule(),
            new FizzRule(),
            new BuzzRule()
    };


    private FizzBuzz() {
    }

    public static String convert(Integer input) throws OutOfRangeException {
        if (isOutOfRange(input)) throw new OutOfRangeException();
        for (Rule rule : rules) {
            if (rule.isSatisfiedBy(input)) {
                return rule.getReplacement();
            }
        }
        return input.toString();
    }

    private static boolean isOutOfRange(Integer input) {
        return input <= MIN_RANGE || input > MAX_RANGE;
    }
}

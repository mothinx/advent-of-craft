package games;

public class FizzBuzzRule implements Rule {

    public static final String FIZZ_BUZZ = "FizzBuzz";
    public static final int FIZZ_MUTIPLIER = 3;
    public static final int BUZZ_MULTIPLIER = 5;

    @Override
    public boolean isSatisfiedBy(Integer input) {
       return input % FIZZ_MUTIPLIER == 0 && input % BUZZ_MULTIPLIER == 0;
    }

    @Override
    public String getReplacement() {
        return FIZZ_BUZZ;
    }
}

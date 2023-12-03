package games;

public class FizzRule implements Rule {

    public static final String FIZZ = "Fizz";
    public static final int FIZZ_MULTIPLIER = 3;

    @Override
    public boolean isSatisfiedBy(Integer input) {
        return input % FIZZ_MULTIPLIER == 0;
    }

    @Override
    public String getReplacement() {
        return FIZZ;
    }
}

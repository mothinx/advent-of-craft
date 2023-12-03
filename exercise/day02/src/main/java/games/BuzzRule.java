package games;

public class BuzzRule implements Rule {

    public static final int BUZZ_MUTIPLIER = 5;
    public static final String BUZZ = "Buzz";

    @Override
    public boolean isSatisfiedBy(Integer input) {
       return input % BUZZ_MUTIPLIER == 0;
    }

    @Override
    public String getReplacement() {
        return BUZZ;
    }
}

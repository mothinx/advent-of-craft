package games;

public interface Rule {
    boolean isSatisfiedBy(Integer input);
    String getReplacement();
}

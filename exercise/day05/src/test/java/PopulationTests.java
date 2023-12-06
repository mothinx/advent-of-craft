import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import people.Person;
import people.Pet;
import people.PetType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;
import static java.util.Comparator.comparingInt;
import static org.assertj.core.api.Assertions.assertThat;

class PopulationTests {
    private static List<Person> population;

    @BeforeAll
    static void setup() {
        population = Arrays.asList(
                new Person("Peter", "Griffin")
                        .addPet(PetType.CAT, "Tabby", 2),
                new Person("Stewie", "Griffin")
                        .addPet(PetType.CAT, "Dolly", 3)
                        .addPet(PetType.DOG, "Brian", 9),
                new Person("Joe", "Swanson")
                        .addPet(PetType.DOG, "Spike", 4),
                new Person("Lois", "Griffin")
                        .addPet(PetType.SNAKE, "Serpy", 1),
                new Person("Meg", "Griffin")
                        .addPet(PetType.BIRD, "Tweety", 1),
                new Person("Chris", "Griffin")
                        .addPet(PetType.TURTLE, "Speedy", 4),
                new Person("Cleveland", "Brown")
                        .addPet(PetType.HAMSTER, "Fuzzy", 1)
                        .addPet(PetType.HAMSTER, "Wuzzy", 2),
                new Person("Glenn", "Quagmire")
        );
    }

    @Test
    void peopleWithTheirPets() {
        final var response = formatPopulation();

        assertThat(response)
                .hasToString("Peter Griffin who owns : Tabby" + lineSeparator() +
                        "Stewie Griffin who owns : Dolly Brian" + lineSeparator() +
                        "Joe Swanson who owns : Spike" + lineSeparator() +
                        "Lois Griffin who owns : Serpy" + lineSeparator() +
                        "Meg Griffin who owns : Tweety" + lineSeparator() +
                        "Chris Griffin who owns : Speedy" + lineSeparator() +
                        "Cleveland Brown who owns : Fuzzy Wuzzy" + lineSeparator() +
                        "Glenn Quagmire");
    }

    private static String formatPopulation() {
        return population.stream()
                .map(PopulationTests::formatPerson)
                .collect(Collectors.joining(lineSeparator()));
    }

    private static String formatPerson(Person person) {
        return person.firstName() + " " + person.lastName() +
                formatOwningPets(person);
    }

    private static String formatOwningPets(Person person) {
        return person.pets().isEmpty() ? "" : " who owns : " + formatPet(person);
    }

    private static String formatPet(Person person) {
        return person.pets().stream()
                .map(Pet::name)
                .collect(Collectors.joining(" "));
    }

    @Test
    void whoOwnsTheYoungestPet() {
        var filtered = population.stream()
                .min(comparingInt(PopulationTests::youngestPetAgeOfThePerson))
                .orElse(null);

        assert filtered != null;
        assertThat(filtered.firstName()).isEqualTo("Lois");
    }

    private static int youngestPetAgeOfThePerson(Person person) {
        return person.pets()
                .stream()
                .mapToInt(Pet::age)
                .min()
                .orElse(Integer.MAX_VALUE);
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PasswordValidator {
    public static boolean test(String password) {
        return false;
    }
}

public class PasswordValidatorTests {

    @Test
    public void EmptyPasswordIsInvalid() {
        assertFalse(PasswordValidator.test(""));
    }
}

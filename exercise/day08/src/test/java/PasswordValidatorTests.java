import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PasswordValidator {
    public static boolean test(String password) {
        return password.length() == 8;
    }
}

class PasswordValidatorTests {

    @Test
    void EmptyPasswordIsInvalid() {
        assertFalse(PasswordValidator.test(""));
    }

    @Test
    void PasswordWith8CharactersIsValid() {
        assertTrue(PasswordValidator.test("12345678"));
    }
}

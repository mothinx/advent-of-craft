import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PasswordValidator {
    public static boolean test(String password) {
        return false;
    }
}

class PasswordValidatorTests {

    @Test
    void EmptyPasswordIsInvalid() {
        assertFalse(PasswordValidator.test(""));
    }
}

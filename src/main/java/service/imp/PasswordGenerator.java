package service.imp;

import java.security.SecureRandom;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class PasswordGenerator {

    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+<>?";

    public static String generatePassword(int length) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        length = validateLength(length);
        addMandatoryCharacters(password, random);
        addRandomCharacters(length, password, random);
        return mixCharacters(password, random);
    }

    private static void addMandatoryCharacters(StringBuilder password, SecureRandom random) {
        password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
    }

    private static void addRandomCharacters(int length, StringBuilder password, SecureRandom random) {
        for (int i = 4; i < length; i++) {
            String allCharacters = LOWERCASE_LETTERS + UPPERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
    }

    private static int validateLength(int length) {
        if (length < 8) {
            length = 8;
        }
        return length;
    }

    private static String mixCharacters(StringBuilder password, SecureRandom random) {
        String generatedPassword = password.toString();
        char[] passwordArray = generatedPassword.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }
        return new String(passwordArray);
    }
}

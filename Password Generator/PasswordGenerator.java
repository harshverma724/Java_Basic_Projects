
import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    // Define possible characters for each category
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get password length from user
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();

        // Ask the user which types of characters to include
        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("y");

        // Generate the password
        String password = generatePassword(length, includeLowercase, includeUppercase, includeDigits, includeSpecial);

        // Output the generated password
        System.out.println("Generated Password: " + password);
    }

    // Method to generate password based on user input
    private static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeDigits, boolean includeSpecial) {
        StringBuilder characterPool = new StringBuilder();

        // Add the character sets to the pool based on user input
        if (includeLowercase) {
            characterPool.append(LOWERCASE);
        }
        if (includeUppercase) {
            characterPool.append(UPPERCASE);
        }
        if (includeDigits) {
            characterPool.append(DIGITS);
        }
        if (includeSpecial) {
            characterPool.append(SPECIAL_CHARACTERS);
        }

        // If no character types were selected, default to lowercase
        if (characterPool.length() == 0) {
            characterPool.append(LOWERCASE);
        }

        // Secure random number generator for stronger randomness
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        // Generate the password by selecting random characters from the pool
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(randomIndex));
        }

        return password.toString();
    }
}

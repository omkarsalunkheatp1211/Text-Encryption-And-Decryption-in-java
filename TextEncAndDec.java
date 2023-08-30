import java.util.Scanner;

public class TextEncAndDec {
    public static String encrypt(String text, String key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char keyChar = key.charAt(i % key.length());
                int keyShift = keyChar - base;
                int alphabetIndex = (currentChar - base + keyShift) % 26;
                char encryptedChar = (char) (base + alphabetIndex);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedText, String key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char currentChar = encryptedText.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = Character.isLowerCase(currentChar) ? 'a' : 'A';
                char keyChar = key.charAt(i % key.length());
                int keyShift = keyChar - base;
                int alphabetIndex = (currentChar - base - keyShift + 26) % 26;
                char decryptedChar = (char) (base + alphabetIndex);
                decryptedText.append(decryptedChar);
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Encryption");
        System.out.println("2. Decryption");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.print("Enter the text to encrypt: ");
            String originalText = scanner.nextLine();

            System.out.print("Enter the encryption key: ");
            String key = scanner.nextLine();

            String encryptedText = encrypt(originalText, key);
            System.out.println("Original Text: " + originalText);
            System.out.println("Encrypted Text: " + encryptedText);
        } else if (choice == 2) {
            System.out.print("Enter the text to decrypt: ");
            String encryptedText = scanner.nextLine();

            System.out.print("Enter the decryption key: ");
            String key = scanner.nextLine();

            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Encrypted Text: " + encryptedText);
            System.out.println("Decrypted Text: " + decryptedText);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}

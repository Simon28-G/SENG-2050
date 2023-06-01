package auth;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
    private static final String HASH_ALGORITHM = "SHA-1";

    public static boolean isPasswordMatch(String userInput, String storedHash) {
        try {
            // Calculate the SHA-1 hash of the user's input
            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
            byte[] inputHash = messageDigest.digest(userInput.getBytes());

            // Convert the byte array to a hexadecimal string
            StringBuilder inputHashHex = new StringBuilder();
            for (byte b : inputHash) {
                inputHashHex.append(String.format("%02x", b));
            }

            // Compare the calculated hash with the stored hash
            return inputHashHex.toString().equals(storedHash);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception, e.g., log an error or throw a custom exception
            e.printStackTrace();
        }

        return false;
    }
}

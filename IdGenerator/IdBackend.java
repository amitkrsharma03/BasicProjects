package IdGenerator;

public class IdBackend {

    // Method to generate a user ID based on the given parameters
    public static String generateUserID(String fName, String LName, String pincode, int n) {
        // Determine how to construct resultName based on the lengths and
        StringBuilder sb =new StringBuilder();
        // Step 1: Name Comparison and Construction
        if (fName.length() > LName.length()) {
            // Add the last letter of fName to the first position of LName
            sb.append(fName.charAt(fName.length() - 1)).append(LName);
        } else if (fName.length() < LName.length()) {
            // Add the last letter of LName to the first position of fName
            sb.append(LName.charAt(LName.length() - 1)).append(fName);
        } else {
            // Equal lengths, compare lexicographically
            if (fName.compareTo(LName) > 0) {
                // Add the last letter of fName to the first position of LName
                sb.append(fName.charAt(fName.length() - 1)).append(LName);
            } else {
                // Add the last letter of LName to the first position of fName
                sb.append(LName.charAt(LName.length() - 1)).append(fName);
            }
        }

        // Step 2: Extract digits from the pincode
        int leftDigit = Character.getNumericValue(pincode.charAt(n - 1)); // nth digit from left
        int rightDigit = Character.getNumericValue(pincode.charAt(pincode.length() - n)); // nth digit from right

        // Step 3: Concatenate the strings
        sb.append(leftDigit).append(rightDigit);

        // Step 4: Case Conversion
        StringBuilder finalResult = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isUpperCase(c)) {
                finalResult.append(Character.toLowerCase(c));
            } else {
                finalResult.append(Character.toUpperCase(c));
            }
        }

        return finalResult.toString();
    }

}

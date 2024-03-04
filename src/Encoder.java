package src;

import java.util.HashMap;

class Encoder {
    private char offset;
    private HashMap<Character, Integer> charToIntMapping;
    private HashMap<Integer, Character> intToCharMapping;
    private char defaultOffset = 'A';

    public Encoder(char offset) {
        initaliseMapping();

        if (charToIntMapping.get(offset) == null) {
            this.offset = defaultOffset;
        } else {
            this.offset = offset;
        }
        System.out.println("Encoder initialized with offset: " + this.offset);
    }

    private void initaliseMapping() {
        this.charToIntMapping = new HashMap<Character, Integer>();
        this.intToCharMapping = new HashMap<Integer, Character>();
        // create a charToIntMapping of characters to integers
        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 65);
            charToIntMapping.put(c, i);
        }

        // create mappings for digits 0 to 9
        for (int i = 0; i < 10; i++) {
            char c = (char) (i + 48);
            charToIntMapping.put(c, i + 26);
        }

        // create mappings for special characters
        charToIntMapping.put('(', 36);
        charToIntMapping.put(')', 37);
        charToIntMapping.put('*', 38);
        charToIntMapping.put('+', 39);
        charToIntMapping.put(',', 40);
        charToIntMapping.put('-', 41);
        charToIntMapping.put('.', 42);
        charToIntMapping.put('/', 43);

        for (Character c : charToIntMapping.keySet()) {
            intToCharMapping.put(charToIntMapping.get(c), c);
        }
    }

    public String decode(String input) {
        StringBuilder decodedString = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            if(charToIntMapping.get(input.charAt(i)) == null){
                decodedString.append(input.charAt(i));
                continue;
            }

            char decodedChar = intToCharMapping.get(((charToIntMapping.get(input.charAt(i)) + charToIntMapping.get(offset)) % 44 + 44)%44);
            decodedString.append(decodedChar);
        }
        return decodedString.toString();
    }

    public String encode(String input) {
        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (charToIntMapping.get(input.charAt(i)) == null) {
                encodedString.append(input.charAt(i));
                continue;
            }
            char encodedChar = intToCharMapping.get(((charToIntMapping.get(input.charAt(i)) - charToIntMapping.get(offset)) % 44 + 44)%44);
            encodedString.append(encodedChar);
        }

        return encodedString.toString();
    }

    public static void main(String args[]) {

    }
}
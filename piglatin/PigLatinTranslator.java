package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String[] words = input.split(" ");
        String result = "";
        
        for (int i = 0; i < words.length; i++) {
            result += translateWord(words[i]);
            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        if (input.isEmpty()) {
            return "";
        }

        // Separate letters from punctuation at the end
        int lastLetterIndex = input.length() - 1;
        while (lastLetterIndex >= 0 && !Character.isLetter(input.charAt(lastLetterIndex))) {
            lastLetterIndex--;
        }
        
        String word = input.substring(0, lastLetterIndex + 1);
        String punctuation = input.substring(lastLetterIndex + 1);
        System.out.println("");
        
        if (word.isEmpty()) {
            return input;
        }

        String result = "";
        
        // Store capitalization for each character
        boolean[] capitals = new boolean[word.length()];
        for(int i = 0;  i < word.length(); i++){
            capitals[i] = Character.isUpperCase(word.charAt(i));
        }
        // Convert to lowercase for processing
        String lowerInput = word.toLowerCase();
        
        String firstletter = lowerInput.substring(0,1);
        if(firstletter.equalsIgnoreCase("a") || firstletter.equalsIgnoreCase("e") || firstletter.equalsIgnoreCase("i") || firstletter.equalsIgnoreCase("o") || firstletter.equalsIgnoreCase("u")){
            result = lowerInput + "ay";
            // Capitals stay in same positions for vowel-starting words
            StringBuilder finalResult = new StringBuilder(result);
            for(int i = 0; i < capitals.length && i < finalResult.length(); i++){
                if(capitals[i]){
                    finalResult.setCharAt(i, Character.toUpperCase(finalResult.charAt(i)));
                }
            }
            result = finalResult.toString();
        }else{
            int vowelPosition = 0;
            for(int i = 0; i < lowerInput.length(); i++){
                String letter = lowerInput.substring(i, i+1);
                if(letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || 
                letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("o") || 
                letter.equalsIgnoreCase("u")) {
                    vowelPosition = i;
                    break;
                }
            }
            String consonants = lowerInput.substring(0, vowelPosition);
            String rest = lowerInput.substring(vowelPosition);
            result = rest + consonants + "ay";
            
        
            StringBuilder finalResult = new StringBuilder(result);
            for(int i = 0; i < rest.length(); i++){
                if(vowelPosition + i < capitals.length && capitals[vowelPosition + i]){
                    finalResult.setCharAt(i, Character.toUpperCase(finalResult.charAt(i)));
                }
            }
    
            if(capitals[0] && result.length() > 0){
                finalResult.setCharAt(0, Character.toUpperCase(finalResult.charAt(0)));
            }
            result = finalResult.toString();
        }

    

        return result + punctuation;
    }
}
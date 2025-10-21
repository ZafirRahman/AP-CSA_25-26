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

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";
        
        // Store if first letter was capital
        boolean[] capitals = new boolean[input.length()];
        for(int i = 0;  i < input.length(); i++){
            capitals[i] = Character.isUpperCase(input.charAt(i));
        }
        // Convert to lowercase for processing
        input = input.toLowerCase();
        
        String firstletter = input.substring(0,1);
        if(firstletter.equalsIgnoreCase("a") || firstletter.equalsIgnoreCase("e") || firstletter.equalsIgnoreCase("i") || firstletter.equalsIgnoreCase("o") || firstletter.equalsIgnoreCase("u")){
            result = input + "ay";
        }else{
            int vowelPosition = 0;
            for(int i = 0; i < input.length(); i++){
                String letter = input.substring(i, i+1);
                if(letter.equalsIgnoreCase("a") || letter.equalsIgnoreCase("e") || 
                letter.equalsIgnoreCase("i") || letter.equalsIgnoreCase("o") || 
                letter.equalsIgnoreCase("u")) {
                    vowelPosition = i;
                    break;
                }
            }
            String consonants = input.substring(0, vowelPosition);
            String rest = input.substring(vowelPosition);
            result = rest + consonants + "ay";
        }
        
        // Restore capital to first letter if original was capitalized
        StringBuilder finalResult = new StringBuilder(result);
        for(int i = 0; i < capitals.length && i < finalResult.length(); i++){
            if(capitals[i]){
                finalResult.setCharAt(i, Character.toUpperCase(finalResult.charAt(i)));
            }
        }
        result = finalResult.toString();

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.

        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
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

        String result = "";
        String firstletter = input.substring(0,1);
        if(firstletter.equalsIgnoreCase("a") || firstletter.equalsIgnoreCase("e") || firstletter.equalsIgnoreCase("i") || firstletter.equalsIgnoreCase("o") || firstletter.equalsIgnoreCase("u")){
        result = input + "ay";
        }else{
            String currentletter = "";
            int amountofconsts = 0;
            while(!currentletter.equalsIgnoreCase("a") || !currentletter.equalsIgnoreCase("e") || !currentletter.equalsIgnoreCase("i") || !currentletter.equalsIgnoreCase("o") || currentletter.equalsIgnoreCase("u")){
            amountofconsts++;
            currentletter = input.substring(amountofconsts-1, amountofconsts)
            }
            i
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

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
        result = input; // delete this line

        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}

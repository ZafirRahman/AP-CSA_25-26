package piglatin;

public class App {
    public static void main(String[] args)
    {
        /*  Introduction and TODO List

        This project is setup with four main classes:
            1. App - the main application
            2. Book - a class that creates the basic book objects.
                - a Book contains a representation of a real book.
                - Book has methods to read data in from various sources
                - Book also has methods to read data out.
            3. PigLatinTranslator - a static class
                - Used to implement your translator.
                - Has two public methods to take input and return a translated copy.
                    - Book translate(Book input)
                    - String translate(String input)
            4. TestSuite - a simple class that helps you test your work.
                - Just like CodingBat this class tries your code against various cases.
                - It will tell you which cases return expected output or not
         */


        // Run tests, comment out once they pass.
        int score = TestSuite.run();

        // Focus on TestSuite until you get a score of 5 or higher.
        
        if (score > 4)
        {
            // Starter book
            Book input = new Book();
            Book input2 = new Book();
            // Start with a "test" book based on a string.
            // Get this to work, and all the tests to pass first.
            //input.readFromString("TestBook", "Dog\nCat\nMouse");

            // Exiample reading from a URL
            input.readFromUrl("The Strange Case of Dr. Jekyll and Mr. Hyde", "https://www.gutenberg.org/cache/epub/43/pg43.txt");

            input.printlines(0,2);
            Book output = new Book();
            String listString = String.join(", ", input.text);
            output.readFromString(null, PigLatinTranslator.translate(listString));
            output.printlines(0,2);
            output.writeToFile("JekyllPigLatin.txt");

            input2.readFromUrl("Romeo and Juliet", "https://www.gutenberg.org/cache/epub/1513/pg1513.txt");

            input2.printlines(0,2);
            Book output2 = new Book();
            String listString2 = String.join(", ", input2.text);
            output2.readFromString(null, PigLatinTranslator.translate(listString2));
            output2.printlines(0,2);
            output2.writeToFile("R&J.txt");
            
        }
    }
}


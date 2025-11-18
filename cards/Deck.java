package cards;

import java.util.Random;
public class Deck {
    private Card[] cards;
    private int currentCard;

    public Deck(){
        cards = new Card[52];
        currentCard = 0;
        
        int x = 0;
        for(int suit = 0; suit < 4; suit++){
            for(int value = 0; value < 13; value++){
                cards[x] = new Card(suit,value);
                x++;
            }
        }
    }

    public void shuffler(){
        Random ran = new Random();

        for(int i = cards.length - 1; i > 0; i--){
            int j = ran.nextInt(i+1);
            Card temporary = cards[i];
            cards[i] = cards[j];
            cards[j] = temporary;
        }
        currentCard = 0;
    }
    

}

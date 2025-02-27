//Class Card Code
package CardGame;

public class Card {
	private String symbol;
    private int number;

    public Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }

}





//Class CardGame Code

package CardGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CardGame {
    private Map<String, List<Card>> cardMap;

    public CardGame() {
        cardMap = new TreeMap<>();
    }

    public void addCard(Card card) {
        String symbol = card.getSymbol();
        cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
    }

    public void printCardDetails() {
        System.out.println("Distinct Symbols are : ");
        for (String symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();

        for (String symbol : cardMap.keySet()) {
            List<Card> cards = cardMap.get(symbol);
            System.out.println("Cards in " + symbol + " Symbol");
            int sum = 0;
            for (Card card : cards) {
                System.out.println(card);
                sum += card.getNumber();
            }
            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }
    }
}





//Class CardGameApp Code

package CardGame;

import java.util.Scanner;

public class CardGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardGame cardGame = new CardGame();

        System.out.println("Enter Number of Cards : ");
        int numberOfCards = scanner.nextInt();

        for (int i = 1; i <= numberOfCards; i++) {
            System.out.println("Enter card " + i + " symbol : ");
            String symbol = scanner.next();
            System.out.println("Enter card " + i + " number : ");
            int number = scanner.nextInt();
            Card card = new Card(symbol, number);
            cardGame.addCard(card);
        }

        cardGame.printCardDetails();
        scanner.close();
    }
}

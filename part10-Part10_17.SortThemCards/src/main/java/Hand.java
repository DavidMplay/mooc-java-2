
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;

public class Hand implements Comparable<Hand> {

    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        this.cards.stream().forEach(card -> {
            System.out.println(card);
        });
    }

    public void sort() {
        Comparator<Card> comp = Comparator.comparing(Card::getValue).thenComparing(Card::getSuit);
        Collections.sort(cards, comp);
    }

    @Override
    public int compareTo(Hand hand) {
        int thisHandValue = 0;
        for (Card card : cards) {
            thisHandValue += card.getValue();
        }
        int compHandValue = 0;
        for (Card card : hand.cards) {
            compHandValue += card.getValue();
        }
        return thisHandValue - compHandValue;
    }

    public void sortBySuit() {
        BySuitInValueOrder comp = new BySuitInValueOrder();
        Collections.sort(cards, comp);
    }

}

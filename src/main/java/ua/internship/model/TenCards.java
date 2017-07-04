package ua.internship.model;

import ua.internship.model.entity.Card;
import ua.internship.model.entity.ValueHand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * This class describes state and functionality TenCards object which consist of a hand and a deck.
 * Each part (hand and deck) consist of five cards.
 * @author Andrii Severin
 * @version 1.0 29 Jun 2017
 */
public class TenCards {
    public static final String CARD_DELIMITER = " ";
    private static final int COUNT_OF_CARDS_ON_HAND = 5;

    private Card[] hand;
    private Card[] deck;
    private ValueHand bestValueHand;

    /**
     * Initializes hand and deck by list
     * @param cards A list containing the initial five cards in the hand
     *              then the first five cards on top of the deck.
     */
    public TenCards(List<Card> cards) {
        Objects.requireNonNull(cards);
        if (cards.size() != COUNT_OF_CARDS_ON_HAND * 2) throw new RuntimeException("Error input");
        hand = new Card[COUNT_OF_CARDS_ON_HAND];
        deck = new Card[COUNT_OF_CARDS_ON_HAND];
        for (int i = 0; i < COUNT_OF_CARDS_ON_HAND; i++) {
            hand[i] = cards.get(i);
            deck[i] = cards.get(i + COUNT_OF_CARDS_ON_HAND);
        }
    }

    /**
     * Initializes hand and deck by line.
     * @param tenCards A string containing the initial five cards in the hand
     *                 then the first five cards on top of the deck.
     */
    public TenCards(String tenCards) {
        Objects.requireNonNull(tenCards);
        String[] cards = tenCards.split(CARD_DELIMITER);
        if (cards.length != COUNT_OF_CARDS_ON_HAND * 2) throw new RuntimeException("Error input");
        hand = new Card[COUNT_OF_CARDS_ON_HAND];
        deck = new Card[COUNT_OF_CARDS_ON_HAND];
        for (int i = 0; i < COUNT_OF_CARDS_ON_HAND; i++) {
            hand[i] = new Card(cards[i]);
            deck[i] = new Card(cards[i + COUNT_OF_CARDS_ON_HAND]);
        }
    }

    /**
     * Determines the best value of a hand in situation when
     * the player may then discard between zero and five of his or her cards
     * and have them replaced by the same number of cards from the top of the deck.
     * @return The best value of a hand
     */
    public ValueHand determineBestValueHand() {
        bestValueHand = ValueHand.calculateValueHand(hand);
        if (bestValueHand == ValueHand.STRAIGHT_FLUSH) return bestValueHand;

        Card[] currHand = new Card[COUNT_OF_CARDS_ON_HAND];
        int startInd = 0; // number of discarded cards - 1

        // To reduce the number of combinations that are being checked
        // we change the initial number of discarded cards, because
        // to raise the value of a hand in a case of four-of-a-kind player needs
        // to discard at least 3 cards and in a case of full-house - at least 2 cards.
        if (bestValueHand == ValueHand.FOUR_OF_A_KIND) {
            for (; startInd < 2; startInd++) currHand[startInd] = deck[startInd];
        } else if (bestValueHand == ValueHand.FULL_HOUSE) {
            for (; startInd < 1; startInd++) currHand[startInd] = deck[startInd];
        }

        for (int i = startInd; i < COUNT_OF_CARDS_ON_HAND; i++) {
            currHand[i] = deck[i];
            List<int[]> combinations = getAllCombinations(COUNT_OF_CARDS_ON_HAND,
                    COUNT_OF_CARDS_ON_HAND - (i + 1));

            // when discard five cards
            if (combinations.size() == 0) combinations.add(new int[0]);

            for (int[] combination : combinations) {
                for (int k = i + 1; k < COUNT_OF_CARDS_ON_HAND; k++) {
                    currHand[k] = hand[combination[COUNT_OF_CARDS_ON_HAND - (k + 1)]];
                }
                checkIfValueHandBetter(currHand);
                if (bestValueHand == ValueHand.STRAIGHT_FLUSH) return bestValueHand;
            }
        }

        return bestValueHand;
    }

    /**
     * Checks if value of a current hand better than a bestValueHand
     * and if necessary update the best value of a hand
     * @param currHand A current hand
     */
    private void checkIfValueHandBetter(Card[] currHand) {
        ValueHand currentValueHand = ValueHand.calculateValueHand(currHand);
        bestValueHand = (bestValueHand.ordinal() > currentValueHand.ordinal()) ?
                currentValueHand : bestValueHand;
    }

    /**
     * Determines all ways of selecting k elements from a set (size n),
     * such that (unlike permutations) the order of selection does not matter.
     * @param n A size of the set
     * @param k A size of subset of selected elements
     * @return List of all ways of selecting k elements from n
     */
    private List<int[]> getAllCombinations(int n, int k) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[k];
        for (int i = 0; i < k; i++) combination[i] = i;

        int lastPosWhichChanges = k - 1;
        while (lastPosWhichChanges >= 0) {
            combinations.add(Arrays.copyOf(combination, combination.length));
            if (combination[k-1] == n - 1)
                lastPosWhichChanges--;
            else
                lastPosWhichChanges = k - 1;
            if (lastPosWhichChanges >= 0) {
                for (int i = k - 1  ; i >= lastPosWhichChanges; i--) {
                    combination[i] = combination[lastPosWhichChanges] + i - lastPosWhichChanges + 1;
                }
            }
        }

        return combinations;
    }

    public Card[] getHand() {
        return hand;
    }

    public Card[] getDeck() {
        return deck;
    }
}

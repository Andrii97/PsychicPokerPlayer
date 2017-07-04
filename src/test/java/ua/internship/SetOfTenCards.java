package ua.internship;

import ua.internship.model.entity.Card;

import java.util.Arrays;
import java.util.List;

/**
 * This interface contains different tenCards (with different value of a hand)
 * to test the determining the best value of a hand.
 * Also, this interface contains string for initialization tenCards,
 * excepted deck and excepted hand for initialization test.
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public interface SetOfTenCards {
    String TEN_CARDS_FROM_STRING = "TH JH QC QD QS QH KH AH 2S 6S";

    Card[] EXCEPTED_HAND_FROM_STRING = new Card[] {
            new Card("TH"), new Card("JH"), new Card("QC"),
            new Card("QD"), new Card("QS")
    };

    Card[] EXCEPTED_DECK_FROM_STRING = new Card[] {
            new Card('Q', 'H'), new Card('K', 'H'),
            new Card('A', 'H'), new Card('2', 'S'),
            new Card('6','S')
    };

    List<Card> CARDS_WITH_STRAIGHT_FLUSH = Arrays.asList(
            new Card('T', 'H'), new Card('J', 'H'),
            new Card('Q', 'C'), new Card('Q', 'D'),
            new Card('Q', 'S'), new Card('Q', 'H'),
            new Card('K', 'H'), new Card('A', 'H'),
            new Card('2', 'S'), new Card('6','S')
    );

    List<Card> CARDS_WITH_FOUR_OF_A_KIND = Arrays.asList(
            new Card('2', 'H'), new Card('2', 'S'),
            new Card('3', 'H'), new Card('3', 'S'),
            new Card('3', 'C'), new Card('2', 'D'),
            new Card('3', 'D'), new Card('6', 'C'),
            new Card('9', 'C'), new Card('T', 'H')
    );

    List<Card> CARDS_WITH_FULL_HOUSE = Arrays.asList(
            new Card('2', 'H'), new Card('2', 'S'),
            new Card('3', 'H'), new Card('3', 'S'),
            new Card('3', 'C'), new Card('2', 'D'),
            new Card('9', 'C'), new Card('3', 'D'),
            new Card('6', 'C'), new Card('T', 'H')
    );

    List<Card> CARDS_WITH_FLUSH = Arrays.asList(
            new Card('2', 'H'), new Card('A', 'D'),
            new Card('5', 'H'), new Card('A', 'C'),
            new Card('7', 'H'), new Card('A', 'H'),
            new Card('6', 'H'), new Card('9', 'H'),
            new Card('4', 'H'), new Card('3', 'C')
    );

    List<Card> CARDS_WITH_STRAIGHT = Arrays.asList(
            new Card('A', 'C'), new Card('2', 'D'),
            new Card('9', 'C'), new Card('3', 'S'),
            new Card('K', 'D'), new Card('5', 'S'),
            new Card('4', 'D'), new Card('K', 'S'),
            new Card('A', 'S'), new Card('4', 'C')
    );

    List<Card> CARDS_WITH_THREE_OF_A_KIND = Arrays.asList(
            new Card('K', 'S'), new Card('A', 'H'),
            new Card('2', 'H'), new Card('3', 'C'),
            new Card('4', 'H'), new Card('K', 'C'),
            new Card('2', 'C'), new Card('T', 'C'),
            new Card('2', 'D'), new Card('A', 'S')
    );

    List<Card> CARDS_WITH_TWO_PAIRS = Arrays.asList(
            new Card('A', 'H'), new Card('2', 'C'),
            new Card('9', 'S'), new Card('A', 'D'),
            new Card('3', 'C'), new Card('Q', 'H'),
            new Card('K', 'S'), new Card('J', 'S'),
            new Card('J', 'D'), new Card('K', 'D')
    );

    List<Card> CARDS_WITH_ONE_PAIR = Arrays.asList(
            new Card('6', 'C'), new Card('9', 'C'),
            new Card('8', 'C'), new Card('2', 'D'),
            new Card('7', 'C'), new Card('2', 'H'),
            new Card('T', 'C'), new Card('4', 'C'),
            new Card('9', 'S'), new Card('A', 'H')
    );

    List<Card> CARDS_WITH_HIGHEST_CARD = Arrays.asList(
            new Card('3', 'D'), new Card('5', 'S'),
            new Card('2', 'H'), new Card('Q', 'D'),
            new Card('T', 'D'), new Card('6', 'S'),
            new Card('K', 'H'), new Card('9', 'H'),
            new Card('A', 'D'), new Card('Q', 'H')
    );
}

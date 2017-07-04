package ua.internship;

import ua.internship.model.entity.Card;

/**
 * This interface contains different hands (with different value of a hand)
 * to test the calculation value of hand.
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public interface Hands {
    Card[] HAND_WITH_HIGHEST_CARD = new Card[] {
            new Card("3D"), new Card("5S"), new Card("2H"),
            new Card("QD"), new Card("TD")
    };

    Card[] HAND_WITH_ONE_PAIR = new Card[] {
            new Card("6C"), new Card("9C"), new Card("8C"),
            new Card("2D"), new Card("9H")
    };

    Card[] HAND_WITH_TWO_PAIR = new Card[] {
            new Card("6C"), new Card("9C"), new Card("6D"),
            new Card("2D"), new Card("9H")
    };

    Card[] HAND_WITH_THREE_OF_A_KIND = new Card[] {
            new Card("6C"), new Card("6H"), new Card("6D"),
            new Card("2D"), new Card("9H")
    };

    Card[] HAND_WITH_STRAIGHT = new Card[] {
            new Card("3C"), new Card("4H"), new Card("6D"),
            new Card("2D"), new Card("5H")
    };

    Card[] HAND_WITH_STRAIGHT_WITH_ACE = new Card[] {
            new Card("3C"), new Card("4H"), new Card("AD"),
            new Card("2D"), new Card("5H")
    };

    Card[] HAND_WITH_FLUSH = new Card[] {
            new Card("JC"), new Card("4C"), new Card("QC"),
            new Card("2C"), new Card("5C")
    };

    Card[] HAND_WITH_FULL_HOUSE = new Card[] {
            new Card("JC"), new Card("JH"), new Card("5S"),
            new Card("5D"), new Card("5C")
    };

    Card[] HAND_WITH_FOUR_OF_A_KIND_TEST = new Card[] {
            new Card("JC"), new Card("JH"), new Card("JS"),
            new Card("JD"), new Card("5C")
    };

    Card[] HAND_WITH_STRAIGHT_FLUSH = new Card[] {
            new Card("TC"), new Card("JC"), new Card("QC"),
            new Card("KC"), new Card("AC")
    };

    Card[] HAND_WITH_ACE_AND_WITHOUT_STRAIGHT = new Card[] {
            new Card("AD"), new Card("5H"), new Card("6H"),
            new Card("7S"), new Card("8H")

    };
}

package ua.internship.model;

import org.junit.Test;
import ua.internship.SetOfTenCards;
import ua.internship.model.entity.ValueHand;

import static org.junit.Assert.*;

/**
 * This class contains tests that check the correctness
 * of initialization and determining the best value of a hand.
 * @author Andrii Severin
 * @version 1.0 29 Jun 2017
 */
public class TenCardsTest {
    @Test
    public void initializeTenCardsFromStringTest() {
        TenCards actualTenCards = new TenCards(SetOfTenCards.TEN_CARDS_FROM_STRING);
        assertArrayEquals(SetOfTenCards.EXCEPTED_DECK_FROM_STRING, actualTenCards.getDeck());
        assertArrayEquals(SetOfTenCards.EXCEPTED_HAND_FROM_STRING, actualTenCards.getHand());
    }

    @Test
    public void determineBestHandStraightFlushTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_STRAIGHT_FLUSH);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.STRAIGHT_FLUSH, result);
    }

    @Test
    public void determineBestHandFourOfAKindTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_FOUR_OF_A_KIND);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.FOUR_OF_A_KIND, result);
    }

    @Test
    public void determineBestHandFullHouseTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_FULL_HOUSE);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.FULL_HOUSE, result);
    }

    @Test
    public void determineBestHandFlushTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_FLUSH);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.FLUSH, result);
    }

    @Test
    public void determineBestHandStraightTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_STRAIGHT);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.STRAIGHT, result);
    }

    @Test
    public void determineBestHandThreeOfAKindTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_THREE_OF_A_KIND);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.THREE_OF_A_KIND, result);
    }

    @Test
    public void determineBestHandTwoPairTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_TWO_PAIRS);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.TWO_PAIRS, result);
    }

    @Test
    public void determineBestHandOnePairTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_ONE_PAIR);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.ONE_PAIR, result);
    }

    @Test
    public void determineBestHandHighestCardTest() {
        TenCards tenCards = new TenCards(SetOfTenCards.CARDS_WITH_HIGHEST_CARD);
        ValueHand result = tenCards.determineBestValueHand();
        assertEquals(ValueHand.HIGHEST_CARD, result);
    }
}

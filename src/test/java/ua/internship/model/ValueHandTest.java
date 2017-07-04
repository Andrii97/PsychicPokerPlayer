package ua.internship.model;

import org.junit.Test;
import ua.internship.Hands;
import ua.internship.model.entity.*;

import static org.junit.Assert.*;

/**
 * This class contains tests that check the correctness
 * of calculating the value of hand.
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public class ValueHandTest {

    @Test
    public void calculateValueHandHighestCardTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_HIGHEST_CARD);
        assertEquals(ValueHand.HIGHEST_CARD, result);
    }

    @Test
    public void calculateValueHandOnePairTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_ONE_PAIR);
        assertEquals(ValueHand.ONE_PAIR, result);
    }

    @Test
    public void calculateValueHandTwoPairTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_TWO_PAIR);
        assertEquals(ValueHand.TWO_PAIRS, result);
    }

    @Test
    public void calculateValueHandThreeOfAKindTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_THREE_OF_A_KIND);
        assertEquals(ValueHand.THREE_OF_A_KIND, result);
    }

    @Test
    public void calculateValueHandStraightTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_STRAIGHT);
        assertEquals(ValueHand.STRAIGHT, result);
    }

    @Test
    public void calculateValueHandStraightWithAceTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_STRAIGHT_WITH_ACE);
        assertEquals(ValueHand.STRAIGHT, result);
    }

    @Test
    public void calculateValueHandFlushTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_FLUSH);
        assertEquals(ValueHand.FLUSH, result);
    }

    @Test
    public void calculateValueHandFullHouseTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_FULL_HOUSE);
        assertEquals(ValueHand.FULL_HOUSE, result);
    }

    @Test
    public void calculateValueHandFourOfAKindTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_FOUR_OF_A_KIND_TEST);
        assertEquals(ValueHand.FOUR_OF_A_KIND, result);
    }

    @Test
    public void calculateValueHandStraightFlushTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_STRAIGHT_FLUSH);
        assertEquals(ValueHand.STRAIGHT_FLUSH, result);
    }

    @Test
    public void calculateValueHandWithAceAndWithoutStraightTest() {
        ValueHand result = ValueHand.calculateValueHand(Hands.HAND_WITH_ACE_AND_WITHOUT_STRAIGHT);
        assertNotEquals(ValueHand.STRAIGHT, result);
    }
}

package ua.internship.model.entity;

import java.util.*;

/**
 * This enum contains values of hands in poker.
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public enum ValueHand {
    /**
     * Straight Flush: Five cards in numerical order, all of identical suits.
     */
    STRAIGHT_FLUSH("straight-flush"),
    /**
     * Four of a Kind: Four cards of the same rank, and one side card or 'kicker'.
     */
    FOUR_OF_A_KIND("four-of-a-kind"),
    /**
     * Full House: Three cards of the same rank, and two cards of a different, matching rank.
     */
    FULL_HOUSE("full-house"),
    /**
     * Flush: Five cards of the same suit.
     */
    FLUSH("flush"),
    /**
     * Straight: Five cards in sequence.
     */
    STRAIGHT("straight"),
    /**
     * Three of a kind: Three cards of the same rank, and two unrelated side cards.
     */
    THREE_OF_A_KIND("three-of-a-kind"),
    /**
     * Two pair: Two cards of a matching rank, another two cards of a different matching rank, and one side card.
     */
    TWO_PAIRS("two-pairs"),
    /**
     * One pair: Two cards of a matching rank, and three unrelated side cards.
     */
    ONE_PAIR("one-pair"),
    /**
     * High card: Any hand that does not qualify under a category listed above.
     */
    HIGHEST_CARD("highest-card");

    private String name;

    ValueHand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Calculates the value of hand.
     * @param hand An array which consist of five cards that represents some value of hand
     * @return The value of hand
     */
    public static ValueHand calculateValueHand(Card[] hand) {
        Objects.requireNonNull(hand);
        if (hand.length != 5) throw new RuntimeException("ERROR: hand must contain 5 cards");

        Map<FaceValue, Integer> faceValueCounterMap = new EnumMap<>(FaceValue.class);
        int minFaceValueOrdinal = FaceValue.ACE.ordinal(), maxFaceValueOrdinal = FaceValue.TWO.ordinal();
        boolean isFlush = true;
        Suit initialSuit = hand[0].getSuit();

        for (Card card : hand) {
            faceValueCounterMap.merge(card.getFaceValue(), 1, (prev, curr) -> prev + curr);

            if (isFlush && initialSuit != card.getSuit()) isFlush = false;

            if (card.getFaceValue() == FaceValue.ACE) continue;
            int currFaceValueOrdinal = card.getFaceValue().ordinal();
            minFaceValueOrdinal = (minFaceValueOrdinal > currFaceValueOrdinal) ?
                    currFaceValueOrdinal : minFaceValueOrdinal;
            maxFaceValueOrdinal = (maxFaceValueOrdinal < currFaceValueOrdinal) ?
                    currFaceValueOrdinal : maxFaceValueOrdinal;
        }

        return determineValueHand(faceValueCounterMap, minFaceValueOrdinal, maxFaceValueOrdinal, isFlush);
    }

    /**
     * Determines the value of hand by information obtained by analyzing hand's cards.
     * @param faceValueCounterMap A map of occurrences of the face-value of the hand
     * @param minFaceValueOrdinal A min face-value ordinal in a hand (without ACE)
     * @param maxFaceValueOrdinal A max face-value ordinal in a hand (without ACE)
     * @param isFlush A flag that determines if value of hand is flush
     * @return The value of hand
     */
    private static ValueHand determineValueHand(Map<FaceValue, Integer> faceValueCounterMap,
                                                int minFaceValueOrdinal, int maxFaceValueOrdinal,
                                                boolean isFlush) {
        switch (faceValueCounterMap.size()) {
            case 5:
                boolean isStraight = !faceValueCounterMap.containsKey(FaceValue.ACE) ?
                        maxFaceValueOrdinal - minFaceValueOrdinal == 4 :
                        maxFaceValueOrdinal - minFaceValueOrdinal == 3 &&
                                (maxFaceValueOrdinal == FaceValue.KING.ordinal() ||
                                        minFaceValueOrdinal == FaceValue.TWO.ordinal());
                if (isFlush && isStraight) return ValueHand.STRAIGHT_FLUSH;
                if (isFlush) return ValueHand.FLUSH;
                if (isStraight) return ValueHand.STRAIGHT;
                return ValueHand.HIGHEST_CARD;
            case 4: return ValueHand.ONE_PAIR;
            case 3:
                if (faceValueCounterMap.values().contains(3)) return ValueHand.THREE_OF_A_KIND;
                return ValueHand.TWO_PAIRS;
            case 2:
                if (faceValueCounterMap.values().contains(4)) return ValueHand.FOUR_OF_A_KIND;
                return ValueHand.FULL_HOUSE;
            default:
                throw new RuntimeException("Error in input data (Card must be unique)");
        }
    }
}

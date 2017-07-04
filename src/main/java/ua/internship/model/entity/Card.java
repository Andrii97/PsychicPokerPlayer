package ua.internship.model.entity;

/**
 * This class describes card entity which consist of face-value and suit
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public class Card implements Comparable{
    private FaceValue faceValue;
    private Suit suit;

    /**
     * Initializes card which is represented as a two-character code.
     * @param faceValue A face-value (A=Ace, 2-9, T=10, J=Jack, Q=Queen, K=King)
     * @param suit A suit (C=Clubs, D=Diamonds, H=Hearts, S=Spades)
     */
    public Card(Character faceValue, Character suit) {
        this.faceValue = FaceValue.valueOf(faceValue);
        this.suit = Suit.valueOf(suit);
    }

    /**
     * Initializes card which is represented as a two-character code.
     * The first character is the face-value (A=Ace, 2-9, T=10, J=Jack, Q=Queen, K=King)
     * and the second character is the suit (C=Clubs, D=Diamonds, H=Hearts, S=Spades)
     * @param card A string with a two-character code
     */
    public Card(String card) {
        this.faceValue = FaceValue.valueOf(card.charAt(0));
        this.suit = Suit.valueOf(card.charAt(1));
    }

    public FaceValue getFaceValue() {
        return faceValue;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Object o) {
        Card card = (Card) o;
        if (faceValue.ordinal() == card.faceValue.ordinal())
            return 0;
        if (faceValue.ordinal() > card.faceValue.ordinal())
            return 1;
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (faceValue != card.faceValue) return false;
        return suit == card.suit;
    }

    @Override
    public int hashCode() {
        int result = faceValue != null ? faceValue.hashCode() : 0;
        result = 31 * result + (suit != null ? suit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Card{" +
                "faceValue=" + faceValue +
                ", suit=" + suit +
                '}';
    }
}

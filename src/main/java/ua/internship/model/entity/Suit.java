package ua.internship.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum contains suits that can be used for card suit
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public enum Suit {
    Clubs('C'), Diamonds('D'), Hearts('H'), Spades('S');

    private Character mark;

    private static Map<Character, Suit> map = new HashMap<>();

    static {
        for (Suit suit : Suit.values()) {
            map.put(suit.mark, suit);
        }
    }

    Suit(Character mark) {
        this.mark = mark;
    }

    public static Suit valueOf(Character value) {
        return map.get(value);
    }

    public Character getMark() {
        return mark;
    }
}

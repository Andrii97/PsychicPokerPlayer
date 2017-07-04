package ua.internship.model.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * This enum contains face-values that can be used for card face-value
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public enum  FaceValue {
    TWO('2'), THREE('3'), FOUR('4'), FIVE('5'),
    SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9'),
    TEN('T'), JACK('J'), QUEEN('Q'), KING('K'),
    ACE('A');

    private Character mark;

    private static Map<Character, FaceValue> map = new HashMap<>();

    static {
        for (FaceValue faceValue : FaceValue.values()) {
            map.put(faceValue.mark, faceValue);
        }
    }

    FaceValue(Character mark) {
        this.mark = mark;
    }

    public static FaceValue valueOf(Character value) {
        return map.get(value);
    }

    public Character getMark() {
        return mark;
    }
}

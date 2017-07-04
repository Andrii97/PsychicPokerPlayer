package ua.internship;

import ua.internship.model.TenCards;
import ua.internship.model.entity.Card;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class is used for working with i/o files and to start the program
 * @author Andrii Severin
 * @version 1.0 28 Jun 2017
 */
public class App {
    private static final String NEW_LINE = "\n";
    private static final String HAND = "Hand: ";
    private static final String DECK = "Deck: ";
    private static final String BEST_HAND = "Best hand: ";

    public static void main(String[] args ) {
        processUser("input.txt", "output.txt");
    }

    /**
     * Reads data from input file by line, process it and writes conclusion to output file
     * @param inputFilename A name of input file
     * @param outputFilename A name of output file
     */
    private static void processUser(String inputFilename, String outputFilename) {
        try (
                Stream<String> stream = Files.lines(Paths.get(inputFilename));
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFilename))
        ) {
            stream.forEach(stringWithTenCards -> {
                TenCards tenCards = new TenCards(stringWithTenCards);
                writeStringToFile(writer, tenCards);
            });
        } catch (IOException e) {
            throw new RuntimeException("Error with i/o files", e);
        }
    }

    /**
     * Writes to the file the conclusions
     * @param writer A buffered character-output stream
     * @param tenCards A current TenCards for game
     */
    private static void writeStringToFile(BufferedWriter writer, TenCards tenCards) {
        try {
            writer.append(HAND)
                    .append(cardsToString(tenCards.getHand()))
                    .append(DECK)
                    .append(cardsToString(tenCards.getDeck()))
                    .append(BEST_HAND)
                    .append(tenCards.determineBestValueHand().getName())
                    .append(NEW_LINE);
        } catch (IOException e) {
            throw new RuntimeException("Error with i/o files", e);
        }
    }

    /**
     * Writes an array of cards to string when
     * each card is represented as a two-character code.
     * The first character is the face-value (A=Ace, 2-9, T=10, J=Jack, Q=Queen, K=King)
     * and the second character is the suit (C=Clubs, D=Diamonds, H=Hearts, S=Spades).
     * Cards will be separated by CARD_DELIMITER.
     * @param cards An array of cards
     * @return String which represents an array of cards
     */
    private static String cardsToString(Card[] cards) {
        StringBuilder result = new StringBuilder();

        for (Card card : cards) {
            result.append(card.getFaceValue().getMark())
                    .append(card.getSuit().getMark())
                    .append(TenCards.CARD_DELIMITER);
        }

        return result.toString();
    }
}

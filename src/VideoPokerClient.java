import java.util.Scanner;

public class VideoPokerClient {
	public static final int HAND_SIZE = 5;
	public static void main(String[] args) {

		// Create and shuffle the deck
		Deck deck = new Deck();
		deck.shuffle();

		Scanner input = new Scanner(System.in);

		// Create user hand and populate it
		Card[] hand = new Card[HAND_SIZE];
		deal(hand, deck);

		// Print hand out
		printHand(hand);

		String userLine = input.nextLine();

	}

	public static void deal(Card[] hand, Deck deck) {
		for(int i = 0; i < hand.length; i++) {
			hand[i] = deck.draw();
		}
	}

	public static void printHand(Card[] hand) {
		for(int i = 0; i < hand.length; i++) {
			System.out.print((i + 1) + ") " + hand[i] + "   ");
		}
		System.out.println();
	}

}
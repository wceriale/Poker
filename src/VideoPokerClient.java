import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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
		System.out.println(deck.toString());
		System.out.println("Enter numbers seperated by spaces to indicate which cards to keep");
		System.out.println(HandEvaluator.evaluate(hand));
		System.out.println();
		String userLine = input.nextLine();
		processInput(userLine, hand, deck);
		printHand(hand);
		System.out.println(deck.toString());
		System.out.println();
		System.out.println(HandEvaluator.evaluate(hand));

	}

	public static void processInput(String input, Card[] hand, Deck deck) {
		Scanner s = new Scanner(input);
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 1; i <= HAND_SIZE; i++)
			set.add(i);
		while(s.hasNext()) {
			set.remove(s.nextInt());
		}
		for(Integer i : set) {
			hand[i - 1] = deck.draw();
		}
	}

	public static void deal(Card[] hand, Deck deck) {
		for(int i = 0; i < hand.length; i++) {
			hand[i] = deck.draw();
		}
	}

	public static void printHand(Card[] hand) {
		System.out.println();
		System.out.println();
		for(int i = 0; i < hand.length; i++) {
			System.out.print((i + 1) + ") " + hand[i] + "   ");
		}
		System.out.println();
		System.out.println();
	}

}
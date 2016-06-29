import java.util.Random;

public class Deck {
	public static final int NUM_CARDS = 52;
	private Card[] deck;
	private int size;
	private Random r;

	public Deck() {
		r = new Random();
		deck = new Card[NUM_CARDS];
		initializeDeck();
	}

	private void initializeDeck() {
		int index = -1;
		for(SuitEnum suit : SuitEnum.values())
			for(ValueEnum value : ValueEnum.values()) {
				deck[index++] = new Card(suit, value);
			}
	}


	public void shuffle() {
		//Fisher Yates Algorithm
	}

	public Card draw() {
		return deck[size--];
	}

	public int size() {
		return size;
	} 

	public String toString() {
		return "Deck has " + size + " cards left";
	}
}
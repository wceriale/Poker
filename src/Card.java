public class Card {
	private SuitEnum suit;
	private ValueEnum value;

	public Card(SuitEnum suit, ValueEnum value) {
		this.suit = suit; this.value = value;
	}

	public SuitEnum getSuit() {
		return this.suit;
	}

	public ValueEnum getValue() {
		return this.value;
	}

	public Integer getRank() {
		return this.value.ordinal();
	}

	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (!(obj instanceof Card)) {
			return false;
		} else {
			Card card2 = (Card) obj;
			return this.value.equals(card2.value) && this.suit.equals(card2.suit);
		}
	}

	public String toString() {
		String val = value.toString();
		if(val.contains("CARD"))
			val = val.substring(4);
		return val + " of " + suit.toString();
	}
}
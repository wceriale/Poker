import java.util.Set;
import java.util.HashSet;
import HandEnum;

// Poker hand evaluator
// Currently works for hands of 5 cards only

public class HandEvaluator{
	public static Card[] hand;
	public static HandEnum evaluate(Card[] hand) {
		// Copy hand to field
		copy(hand);

		// Sort the copied hand (field) - Makes checking 
		// hands easier.
		sort();

		if(isRoyal())				return ROYAL_FLUSH;
		else if(isStraightFlush()) 	return STRAIGHT_FLUSH;
		else if(isFour())   		return FOUR_OF_A_KIND;
		else if(isFull())   		return FULL_HOUSE;
		else if(isFlush())  		return FLUSH;
		else if(isStraight())		return STRAIGHT;
		else if(isThree())			return THREE_OF_A_KIND;
		else if(isTwoPair())		return TWO_PAIR;
		else if(isPair())			return PAIR;
		else 						return HIGH_CARD;
	}

	private static void copy(Card[] hand) {
		for(int i = 0; i < hand.length; i++)
			this.hand[i] = hand[i];
	}
	
	// Sorting Alg using Insertion Sort based on Value
	private static void sort() {
		Card[] result = new Card[hand.length];
		result[0] = hand[0];
		for(int i = 1; i < hand.length; i++) {
			Card card = hand[i];
			int j = 0;
			while(j < i && card.getValue.ordinal() < result[j].ordinal())
				j++;
			for(int k = j; k < i; k++)
				result[k] = result[k - 1];
			result[j] = card;
		}
		hand = result;
	}

	private static boolean isRoyal() {
		return isStraightFlush() && 
			hand[hand.length - 1].card.getValue() == ACE;
	}

	private static boolean isStraightFlush() {
		return isFlush() && isStraight();
	}

	// Hacky check, only works with hand of size 5.
	private static boolean isFour() {
		Set<ValueEnum> s = new HashSet<ValueEnum>();
		for(int i = 0; i < hand.length; i++)
			s.add(hand[i].getValue());
		return s.size() == 2 && 
				(hand[0] == hand[1] ^
				 hand[3] == hand[4]);
	}

	// Hacky check, only works with hand of size 5.
	private static boolean isFull() {
		Set<ValueEnum> s = new HashSet<ValueEnum>();
		for(int i = 0; i < hand.length; i++)
			s.add(hand[i].getValue());

		// Check if contains 2 of one value in set.
		return s.size() == 2 && 
				(hand[0] == hand[1] &&
				 hand[3] == hand[4]);
		
	}

	private static boolean isFlush() {
		Set<SuitEnum> s = new HashSet<SuitEnum>();
		for(int i = 0; i < hand.length; i++)
			s.add(hand[i].getSuit());
		return s.size() == 1;
	}

	private static boolean isStraight() {
		for(int i = 0; i < hand.length - 1; i++) {
			int firstNum = hand[i].getValue().ordinal();
			int secondNum = hand[i + 1].getValue().ordinal();
			if(firstNum + 1 != secondNum ||
			   firstNum - 13 != secondNum)
				return false;
		}
		return true;
	}

	private static boolean isThree() {
		for(int i = 0; i < hand.length - 2; i++) {
			if(hand[i].getValue() ==
			   hand[i + 1].getValue() ==
			   hand[i + 2].getValue())
				return true;
		}
		return false;
	}

	private static boolean isTwoPair() {
		Set<ValueEnum> s = new HashSet<ValueEnum>();
		for(int i = 0; i < hand.length; i++)
			s.add(hand[i].getValue());

		// Check if contains 3 of one value in set.
		return s.size() == 3 && !isThree();
	}

	private static boolean isPair() {
		Set<ValueEnum> s = new HashSet<ValueEnum>();
		for(int i = 0; i < hand.length; i++)
			s.add(hand[i].getValue());

		// Check if contains 3 of one value in set.
		return s.size() == 4;
	}









	
}
package nl.hu.bep2.casino.blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
	private boolean finished=false;
	private DealerAndPlayer dealerAndPlayer;
	public Hand(DealerAndPlayer dealerAndPlayer) {
		this.dealerAndPlayer = dealerAndPlayer;
	}
	private List<Card> cards=new ArrayList<>();

	private List<Integer> getPossibleTotalValues(List<Card> cards) {
		List<Integer> values=new ArrayList<>();
		List<Integer> currentCardValues=cards.get(0).getRank().getPossibleValues();
		if(cards.size()>1) {
			List<Integer> valuesOtherCards= getPossibleTotalValues(cards.subList(1,cards.size()));
			for(Integer value:currentCardValues) {
				for(Integer otherValue:valuesOtherCards) {
					values.add(value+otherValue);
				}
			}
		} else values=currentCardValues;
		Collections.sort(values);
		return values;
	}
	public List<Integer> getPossibleTotalValues() {
		return getPossibleTotalValues(cards);
	}
	public int getMinValue() {
		return getPossibleTotalValues().get(0);
	}
	public int getMaxValue() {
		List<Integer> possibleValues= getPossibleTotalValues();
		return possibleValues.get(possibleValues.size()-1);
	}
	public int closestTo21() {
		List<Integer> possibleValues= getPossibleTotalValues();
		Collections.reverse(possibleValues);
		while(true) {
			int value=possibleValues.remove(0);
			if(value<22) return value;
		}
	}
	public int distanceTo21() {
		return 21-closestTo21();
	}
	public boolean isBust() {
		return getMinValue()>21;
	}
	public boolean hasBlackjack() {
		return cards.size()==2 && getMaxValue()==21;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

	public List<Card> getCards() {
		return Collections.unmodifiableList(cards);
	}

	public void stand() {this.finished=true;}
	public boolean getFinished() {return this.finished;}
}

package nl.hu.bep2.casino.blackjack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rank {
	private static List<Rank> ranks =new ArrayList<>();
	static {
		ranks.add(new Rank("Ace", Arrays.asList(1,11)));
		ranks.add(new Rank("2", Arrays.asList(2)));
		ranks.add(new Rank("3", Arrays.asList(3)));
		ranks.add(new Rank("4", Arrays.asList(4)));
		ranks.add(new Rank("5", Arrays.asList(5)));
		ranks.add(new Rank("6", Arrays.asList(6)));
		ranks.add(new Rank("7", Arrays.asList(7)));
		ranks.add(new Rank("8", Arrays.asList(8)));
		ranks.add(new Rank("9", Arrays.asList(9)));
		ranks.add(new Rank("10", Arrays.asList(10)));
		ranks.add(new Rank("Jack", Arrays.asList(10)));
		ranks.add(new Rank("Queen", Arrays.asList(10)));
		ranks.add(new Rank("King", Arrays.asList(10)));
	}
	private String name;
	private List<Integer> possibleValues;
	public Rank(String name, List<Integer> possibleValues) {
		this.name=name;
		this.possibleValues=possibleValues;
	}

	public List<Integer> getPossibleValues() {
		return possibleValues;
	}

	public static List<Rank> getRanks() {return Collections.unmodifiableList(ranks);}
}

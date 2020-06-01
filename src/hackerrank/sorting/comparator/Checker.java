package hackerrank.sorting.comparator;

import java.util.Comparator;

//Write your Checker class here
public class Checker implements Comparator<Player> {
	public int compare(Player a, Player b) {
		if (a.score == b.score)
			return (a.name.compareTo(b.name));
		return (b.score - a.score);

	}
}

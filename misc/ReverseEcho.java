package misc;

import static java.util.Collections.reverse;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReverseEcho {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List <String> lines = new LinkedList<String>();
		while (sc.hasNextLine())
			lines.add(sc.nextLine());
		reverse(lines);
		for (String line : lines)
			System.out.println(line);
	}

}

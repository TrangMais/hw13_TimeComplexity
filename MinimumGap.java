package be6_day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumGap {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> num = new ArrayList<>();

		int size;
		System.out.println("Please enter the number of array size: ");
		size = scan.nextInt();

		System.out.println("Please enter the number: ");
		for (int i = 0; i < size; i++) {
			num.add(scan.nextInt());
		}

		int minimumGap = minimumGap(num);
		System.out.println("The minimum gap is " + minimumGap);
	}

	// Time Complexity: O(N^2)
	public static int minimumGap(List<Integer> a) {
		int min = a.size();
		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				if (a.get(i).equals(a.get(j))) {
					if (a.get(i) == a.get(j)) {
						min = j - i;
					}
				}
			}
		}
		if (min == a.size()) {
			return -1;
		}
		return min;
	}
	
}

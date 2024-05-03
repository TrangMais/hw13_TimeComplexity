package be6_day14;

import java.util.Scanner;

public class ChocolateFeast {
	// n: money, c: cost, m: wrappers (2m = 1 free)
	// n = 15; c = 3; m = 2 => wrap = 5 + 2 + 1 + 1;
	// 10; 2; 5 => wrap = 5 + 1
	// 6; 2; 2 => wrap = 3 + 1 + 1
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of test cases: ");
		int t = input.nextInt();

		System.out.println("Please enter the money, cost and exchange of test cases: ");
		for (int i = 0; i < t; i++) {
			int n = input.nextInt();
			int c = input.nextInt();
			int m = input.nextInt();
			int wrapBasic = theFeastUpgrade(n, c, m);
			int wrapUpgrade = theFeastBasic(n, c, m);
			System.out.println(wrapBasic);
			System.out.println(wrapUpgrade);
		}
	}

	// Time Complexity: O(n)
	public static int theFeastBasic(int n, int c, int m) {
		int barCount = n / c;
		int wrap = barCount;
		int newBarCount = 0;

		while (wrap >= m) {
			newBarCount = wrap / m;
			barCount = barCount + newBarCount; // barCount = barCount + wrap/m = barCount + barCount/m
			wrap = (wrap % m) + newBarCount; // wrap = (wrap % m) + (wrap / m)
		}
		return barCount;
	}

	// Time Complexity: O(1)
	public static int theFeastUpgrade(int n, int c, int m) {
		int barCount = n / c;

		if (barCount >= m) {
			barCount = barCount + (barCount - 1) / (m - 1); // loop will stop when wrap is 1 or newBarCount is 1
			return barCount;
		}
		return barCount;
	}

}

package be6_day14;

public class FindIndexOfNumberInArray {
	public static void main(String[] args) {
		int[] array = { 4, 5, 11, 44, 56, 92, 100 };
		int index = findNumber(100, array);
		int index2 = findNumber2(100, array);
		System.out.println("The position is: " + index);
		System.out.println("The position is: " + index2);
	}

	// Time Complexity O(N)
	public static int findNumber(int num, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i;
			}
		}
		return -1;
	}

	// Time Complexity O(N)??
	public static int findNumber2(int num, int[] arr) {
		int leftNumber = 0;
		int rightNumber = arr.length - 1;

		while (leftNumber <= rightNumber) {
			int middleNumber = (leftNumber + rightNumber) / 2;

			if (num == arr[middleNumber]) {
				return middleNumber;
			}

			if (num < arr[middleNumber]) {
				rightNumber = middleNumber - 1;
			}

			if (num > arr[middleNumber]) {
				leftNumber = middleNumber + 1;
			}
		}
		return leftNumber;
	}
}

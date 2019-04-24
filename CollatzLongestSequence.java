package org.jboss.as.quickstarts.datagrid.hotrod;

/**
 * @author Arnav Bhati
 *
 */
public class CollatzLongestSequence {

	private static final long INPUT_NUMBER = 9000000;// 10 Million
	private static final int BEST_LENGTH = 1;
	private static final int BEST_START = 1;

	public static void main(String[] args) {
		int runCount = 0;
		findLongestSeq(INPUT_NUMBER, BEST_LENGTH, BEST_START, runCount);
	}

	/**
	 * This method provides the Longest subsequence from the input
	 * 
	 * @param n          - input Number
	 * @param bestLength - initiated with 1
	 * @param bestStart  - initialed with 1
	 */
	private static void findLongestSeq(long n, int bestLength, int bestStart, int runCount) {
		if (runCount <= 1) {
			for (int i = 2; i < n; ++i) {
				int current = findSeqLength(i);
				if (current >= bestLength) {
					bestLength = current;
					bestStart = i;
				}
			}
			runCount++;
			if (runCount == 1) {
				System.out.println("Longest length = " + bestLength + " with number " + bestStart);
			} else {
				System.out.println("Second Longest length is = " + bestLength + " with number = " + bestStart);
				findSeqSum(bestStart);
			}
		}
		if (runCount == 1)
			findLongestSeq(bestStart, 1, 1, runCount);
	}

	/**
	 * Method computes longest sequence length
	 * 
	 * @param num
	 * @return
	 */
	private static int findSeqLength(long num) {

		int count = 1;

		while (num > 1L) {
			num = (num % 2L == 0L) ? num / 2L : 3L * num + 1L;
			++count;

		}
		return count;
	}

	/**
	 * This computes the sum of second longest subsequence
	 * 
	 * @param n
	 */
	private static void findSeqSum(long n) {

		long sum = 0;
		while (n > 1L) {
			sum = sum + n;
			n = (n % 2L == 0L) ? n / 2L : 3L * n + 1L;
		}
		System.out.println("Sum of Second Longest sequence is " + (sum + 1));

	}

}

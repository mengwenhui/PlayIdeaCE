package com.mg.fun.algorithm.dp;

public class MinSumMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("hello MinSumMatris");

	}

	/**
	 * @param grid: a list of lists of integers
	 * @return: An integer, minimizes the sum of all numbers along its path
	 */
	public int minPathSum(int[][] grid) {
		// write your code here

		if (grid == null) {
			return 0;
		}

		int M = grid.length;
		int N = grid[0].length;

		int[][] val = new int[M][N];
		val[0][0] = grid[0][0];
		for (int m = 1; m < M; m++) {
			val[m][0] = val[m - 1][0] + grid[m][0];
		}

		for (int n = 1; n < N; n++) {
			val[0][n] = val[0][n - 1] + grid[0][n];
		}

		for (int m = 1; m < M; m++) {
			for (int n = 1; n < N; n++) {
				if (val[m - 1][n] < val[m][n - 1]) {
					val[m][n] = val[m - 1][n] + grid[m][n];
				} else {
					val[m][n] = val[m][n - 1] + grid[m][n];
				}
	            val[m][n] = Math.min(val[m-1][n], val[m][n-1]) + grid[m][n];
			}
		}

		return val[M - 1][N - 1];
	}
}

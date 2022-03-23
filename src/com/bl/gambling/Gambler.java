package com.bl.gambling;

public class Gambler {
	static int BET_PER_DAY = 1;
	public static int counter;
	static final int TOTAL_DAYS = 20;
	static int[] perDayAmount = new int[TOTAL_DAYS];

	Gambler() {
		counter = 0; // initialize counter
	}

	public static void calculatePerDayAmount(int totalStakes, int winCash, int looseCash) {
		if (totalStakes == 150) {
			perDayAmount[counter++] = winCash;
		} else {
			perDayAmount[counter++] = looseCash;
		}
	}

	// print day wise amount
	public static void printResult() {
		for (int i = 0; i < TOTAL_DAYS; i++) {
			System.out.println("Day " + (i + 1) + "-> " + "Amount is: " + perDayAmount[i] + "$");
		}
	}

	// check the bet win or loose
	public static void checkWinOrLoose() {
		Stakes stakes = new Stakes();

		int looseCash = 0;
		int winCash = 0;
		// 50% of stake
		int minStake = stakes.getTotalStakes() - 50;
		int maxStake = stakes.getTotalStakes() + 50;
		// win loose 50 % stake
		while (stakes.getTotalStakes() > minStake && stakes.getTotalStakes() < maxStake) {
			int betState = (int) ((Math.random() * 10) % 2);

			int bet = stakes.getTotalStakes();

			if (betState == 1) {
				stakes.setTotalStakes(bet + BET_PER_DAY);
				winCash++;
			} else {
				stakes.setTotalStakes(bet - BET_PER_DAY);
				looseCash++;
			}
		}
		calculatePerDayAmount(stakes.getTotalStakes(), winCash, looseCash);
	}

	public static void main(String[] args) {
		Stakes stakes = new Stakes();

		int totalDays = TOTAL_DAYS;
		while (totalDays > 0) {
			checkWinOrLoose();
			totalDays--;
		}
		printResult();
	}
}

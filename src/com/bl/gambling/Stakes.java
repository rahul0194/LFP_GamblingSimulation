package com.bl.gambling;

public class Stakes {
	static int totalStakes = 100;
	int betPerGame = 1;

	public int getTotalStakes() {
		return totalStakes;
	}

	public void setTotalStakes(int totalStakes) {
		Stakes.totalStakes = totalStakes;
	}

	public int getBetPerGame() {
		return betPerGame;
	}

	public void setBetPerGame(int betPerGame) {
		this.betPerGame = betPerGame;
	}

}

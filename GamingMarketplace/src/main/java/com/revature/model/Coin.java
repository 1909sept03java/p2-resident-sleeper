package com.revature.model;

public class Coin {

	private int playerId;
	private int coins;
	public Coin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coin(int playerId, int coins) {
		super();
		this.playerId = playerId;
		this.coins = coins;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}
	@Override
	public String toString() {
		return "Coin [playerId=" + playerId + ", coins=" + coins + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coins;
		result = prime * result + playerId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coin other = (Coin) obj;
		if (coins != other.coins)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}
	
}

package com.revature.model;

public class BoughtItem {

	private int playerId;
	private int itemId;
	
	public BoughtItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoughtItem(int playerId, int itemId) {
		super();
		this.playerId = playerId;
		this.itemId = itemId;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public String toString() {
		return "BoughtItem [playerId=" + playerId + ", itemId=" + itemId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
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
		BoughtItem other = (BoughtItem) obj;
		if (itemId != other.itemId)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}
	
}

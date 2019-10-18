package com.revature.model;

public class Avatar {

	private int playerId;
	private String itemFilename;
	public Avatar() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Avatar(int playerId, String itemFilename) {
		super();
		this.playerId = playerId;
		this.itemFilename = itemFilename;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getItemFilename() {
		return itemFilename;
	}
	public void setItemFilename(String itemFilename) {
		this.itemFilename = itemFilename;
	}
	@Override
	public String toString() {
		return "Avatar [playerId=" + playerId + ", itemFilename=" + itemFilename + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemFilename == null) ? 0 : itemFilename.hashCode());
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
		Avatar other = (Avatar) obj;
		if (itemFilename == null) {
			if (other.itemFilename != null)
				return false;
		} else if (!itemFilename.equals(other.itemFilename))
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}
	
}

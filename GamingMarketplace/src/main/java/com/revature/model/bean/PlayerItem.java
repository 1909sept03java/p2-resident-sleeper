package com.revature.model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PLAYER_ITEM")
public class PlayerItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "playerItemSequence")
	@SequenceGenerator(allocationSize = 1, name = "playerItemSequence", sequenceName = "SQ_PLAYER_ITEM_PK")
	@Column(name = "PLAYER_ITEM_ID")
	private int playerItemId; // primary key for the player item table
	@Column(name = "NAME")
	private String name; // name of the item
	@Column(name = "VALUE")
	private int value; // value of the item
	@Column(name = "ITEM_FILENAME")
	private String itemFilename; // item image filename
	@Column(name = "FOR_SALE")
	private boolean forSale; // if true then it is for sale
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "PLAYER_ID")
	private Player player; // tying the player table to the player item table via playerId

	// generated getters, setters, hashcode, equals, toString, constructors

	public int getPlayerItemId() {
		return playerItemId;
	}

	public void setPlayerItemId(int playerItemId) {
		this.playerItemId = playerItemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getItemFilename() {
		return itemFilename;
	}

	public void setItemFilename(String itemFilename) {
		this.itemFilename = itemFilename;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (forSale ? 1231 : 1237);
		result = prime * result + ((itemFilename == null) ? 0 : itemFilename.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + playerItemId;
		result = prime * result + value;
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
		PlayerItem other = (PlayerItem) obj;
		if (forSale != other.forSale)
			return false;
		if (itemFilename == null) {
			if (other.itemFilename != null)
				return false;
		} else if (!itemFilename.equals(other.itemFilename))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (playerItemId != other.playerItemId)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerItem [playerItemId=" + playerItemId + ", name=" + name + ", value=" + value + ", itemFilename="
				+ itemFilename + ", forSale=" + forSale + ", player=" + player + "]";
	}

	public PlayerItem(int playerItemId, String name, int value, String itemFilename, boolean forSale, Player player) {
		super();
		this.playerItemId = playerItemId;
		this.name = name;
		this.value = value;
		this.itemFilename = itemFilename;
		this.forSale = forSale;
		this.player = player;
	}

	public PlayerItem(String name, int value, String itemFilename, boolean forSale, Player player) {
		super();
		this.name = name;
		this.value = value;
		this.itemFilename = itemFilename;
		this.forSale = forSale;
		this.player = player;
	}

	public PlayerItem() {
		super();
	}

}

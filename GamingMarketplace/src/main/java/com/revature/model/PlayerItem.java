package com.revature.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "PLAYER_ITEM")
@Component // creates the playerItem spring bean
public class PlayerItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "playerItemSequence")
	@SequenceGenerator(allocationSize = 1, name = "playerItemSequence", sequenceName = "SQ_PLAYER_ITEM_PK")
	@Column(name = "PLAYER_ITEM_ID")
	private int playerItemId; // primary key for the player item table
	@Column(name = "FOR_SALE")
	private boolean forSale; // if true then it is for sale
	@OneToOne
	@JoinColumn(name = "ITEM_ID")
	@Autowired // spring bean
	private Item item;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PLAYER_ID")
	@Autowired // spring bean
	private Player player; // tying the player table to the player item table via playerId

	// generated getters, setters, hashcode, equals, toString, constructors

	public int getPlayerItemId() {
		return playerItemId;
	}

	public void setPlayerItemId(int playerItemId) {
		this.playerItemId = playerItemId;
	}

	public boolean isForSale() {
		return forSale;
	}

	public void setForSale(boolean forSale) {
		this.forSale = forSale;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + playerItemId;
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
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (playerItemId != other.playerItemId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerItem [playerItemId=" + playerItemId + ", forSale=" + forSale + ", item=" + item + ", player="
				+ player + "]";
	}

	public PlayerItem(int playerItemId, boolean forSale, Item item, Player player) {
		super();
		this.playerItemId = playerItemId;
		this.forSale = forSale;
		this.item = item;
		this.player = player;
	}

	public PlayerItem(boolean forSale, Item item, Player player) {
		super();
		this.forSale = forSale;
		this.item = item;
		this.player = player;
	}

	public PlayerItem() {
		super();
	}

}

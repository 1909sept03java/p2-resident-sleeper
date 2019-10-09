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
@Table(name = "Activity")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "activitySequence")
	@SequenceGenerator(allocationSize = 1, name = "activitySequence", sequenceName = "SQ_ACTIVITY_PK")
	@Column(name = "ACTIVITY_ID")
	private int activityId; // primary key for the activity table
	@Column(name = "TYPE")
	private String type; // bought or sold
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "ITEM_ID")
	private Item item;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "PLAYER_ID")
	private Player player;

	// generated getters, setters, hashcode, equals, toString, constructors

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
		result = prime * result + activityId;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Activity other = (Activity) obj;
		if (activityId != other.activityId)
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
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", type=" + type + ", item=" + item + ", player=" + player + "]";
	}

	public Activity(int activityId, String type, Item item, Player player) {
		super();
		this.activityId = activityId;
		this.type = type;
		this.item = item;
		this.player = player;
	}

	public Activity(String type, Item item, Player player) {
		super();
		this.type = type;
		this.item = item;
		this.player = player;
	}

	public Activity() {
		super();
	}

}

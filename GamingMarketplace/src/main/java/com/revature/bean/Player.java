package com.revature.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "PLAYER")
@Component // creates the player spring bean
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "playerSequence")
	@SequenceGenerator(allocationSize = 1, name = "playerSequence", sequenceName = "SQ_PLAYER_PK")
	@Column(name = "PLAYER_ID")
	private int playerId; // primary key for player table
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "FIRSTNAME")
	private String firstname;
	@Column(name = "LASTNAME")
	private String lastname;
	@Column(name = "AVATAR_FILENAME")
	private String avatarFilename; // the filename of the users avatar image
	@Column(name = "COINS")
	private int coins; // amount of coins saved up from playing games
	@Column(name = "MINUTES")
	private int minutes; // total time spent playing games in minutes

	// generated getters, setters, hashcode, equals, toString, constructors

	public int getplayerId() {
		return playerId;
	}

	public void setplayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAvatarFilename() {
		return avatarFilename;
	}

	public void setAvatarFilename(String avatarFilename) {
		this.avatarFilename = avatarFilename;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatarFilename == null) ? 0 : avatarFilename.hashCode());
		result = prime * result + coins;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + minutes;
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
		Player other = (Player) obj;
		if (avatarFilename == null) {
			if (other.avatarFilename != null)
				return false;
		} else if (!avatarFilename.equals(other.avatarFilename))
			return false;
		if (coins != other.coins)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (minutes != other.minutes)
			return false;
		if (playerId != other.playerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Player [playerId=" + playerId + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", avatarFilename=" + avatarFilename + ", coins=" + coins + ", minutes=" + minutes + "]";
	}

	public Player(int playerId, String email, String firstname, String lastname, String avatarFilename, int coins,
			int minutes) {
		super();
		this.playerId = playerId;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.avatarFilename = avatarFilename;
		this.coins = coins;
		this.minutes = minutes;
	}

	public Player(String email, String firstname, String lastname, String avatarFilename, int coins, int minutes) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.avatarFilename = avatarFilename;
		this.coins = coins;
		this.minutes = minutes;
	}

	public Player() {
		super();
	}

}

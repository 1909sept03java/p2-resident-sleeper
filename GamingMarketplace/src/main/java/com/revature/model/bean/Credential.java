package com.revature.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "CREDENTIAL")
@Component // creates the credential spring bean
public class Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "credentialSequence")
	@SequenceGenerator(allocationSize = 1, name = "credentialSequence", sequenceName = "SQ_CREDENTIAL_PK")
	@Column(name = "CREDENTIAL_ID")
	private int credentialId; // primary key for the credential table
	@Column(name = "USERNAME")
	private String username; // used to login- playername field
	@Column(name = "PASSWORD")
	private String password; // used to login- password field
	@OneToOne
	@JoinColumn(name = "PLAYER_ID")
	@Autowired // spring bean
	private Player player; // tying the player table to the credential table via playerId

	// generated getters, setters, hashcode, equals, toString, constructors

	public int getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(int credentialId) {
		this.credentialId = credentialId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		result = prime * result + credentialId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((player == null) ? 0 : player.hashCode());
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
		Credential other = (Credential) obj;
		if (credentialId != other.credentialId)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credential [credentialId=" + credentialId + ", username=" + username + ", password=" + password
				+ ", player=" + player + "]";
	}

	public Credential(int credentialId, String username, String password, Player player) {
		super();
		this.credentialId = credentialId;
		this.username = username;
		this.password = password;
		this.player = player;
	}

	public Credential(String username, String password, Player player) {
		super();
		this.username = username;
		this.password = password;
		this.player = player;
	}

	public Credential() {
		super();
	}

}

package com.revature.model;

public class User {

	private int userId; // primary key for User table
	private String email;
	private String firstname;
	private String lastname;
	private String avatarFilename; // the filename of the users avatar image
	private int coins; // amount of coins saved up from playing games
	private int minutes; // total time spent playing games in minutes

	// generated getters, setters, hashcode, equals, toString, constructors

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
		result = prime * result + userId;
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
		User other = (User) obj;
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
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", avatarFilename=" + avatarFilename + ", coins=" + coins + ", minutes=" + minutes + "]";
	}

	public User(int userId, String email, String firstname, String lastname, String avatarFilename, int coins,
			int minutes) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.avatarFilename = avatarFilename;
		this.coins = coins;
		this.minutes = minutes;
	}

	public User(String email, String firstname, String lastname, String avatarFilename, int coins, int minutes) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.avatarFilename = avatarFilename;
		this.coins = coins;
		this.minutes = minutes;
	}

	public User() {
		super();
	}

}

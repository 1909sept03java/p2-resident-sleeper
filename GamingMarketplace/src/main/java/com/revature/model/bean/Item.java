package com.revature.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "ITEM")
@Component // creates the item spring bean
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "itemSequence")
	@SequenceGenerator(allocationSize = 1, name = "itemSequence", sequenceName = "SQ_ITEM_PK")
	@Column(name = "ITEM_ID")
	private int itemId; // primary key for the item table
	@Column(name = "NAME")
	private String name; // name of the item
	@Column(name = "VALUE")
	private int value; // value of the item
	@Column(name = "ITEM_FILENAME")
	private String itemFilename; // item image filename

	// generated getters, setters, hashcode, equals, toString, constructors

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemFilename == null) ? 0 : itemFilename.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Item other = (Item) obj;
		if (itemFilename == null) {
			if (other.itemFilename != null)
				return false;
		} else if (!itemFilename.equals(other.itemFilename))
			return false;
		if (itemId != other.itemId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", value=" + value + ", itemFilename=" + itemFilename
				+ "]";
	}

	public Item(int itemId, String name, int value, String itemFilename) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.value = value;
		this.itemFilename = itemFilename;
	}

	public Item(String name, int value, String itemFilename) {
		super();
		this.name = name;
		this.value = value;
		this.itemFilename = itemFilename;
	}

	public Item() {
		super();
	}

}

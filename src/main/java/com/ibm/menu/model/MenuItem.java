package com.ibm.menu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection = "Menu")
public class MenuItem {
	@JsonIgnore
	@Id
	private ObjectId _id;
	private String menuItemNumber;
	private String category;
	private String name;
	private String description;
	private int numAvailable;
	private double price;
	
	public MenuItem() {
		super();
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getMenuItemNumber() {
		return menuItemNumber;
	}

	public void setMenuItemNumber(String menuItemNumber) {
		this.menuItemNumber = menuItemNumber;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumAvailable() {
		return numAvailable;
	}

	public void setNumAvailable(int numAvailable) {
		this.numAvailable = numAvailable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((menuItemNumber == null) ? 0 : menuItemNumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numAvailable;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MenuItem other = (MenuItem) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (menuItemNumber == null) {
			if (other.menuItemNumber != null)
				return false;
		} else if (!menuItemNumber.equals(other.menuItemNumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numAvailable != other.numAvailable)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuItem [_id=" + _id + ", menuItemNumber=" + menuItemNumber + ", category=" + category + ", name="
				+ name + ", description=" + description + ", numAvailable=" + numAvailable + ", price=" + price + "]";
	}

	public MenuItem(ObjectId _id, String menuItemNumber, String category, String name, String description,
			int numAvailable, double price) {
		super();
		this._id = _id;
		this.menuItemNumber = menuItemNumber;
		this.category = category;
		this.name = name;
		this.description = description;
		this.numAvailable = numAvailable;
		this.price = price;
	}
	
	
	
}
package com.ibm.menu.service;

import java.util.List;

import com.ibm.menu.model.MenuItem;

public interface MenuService {
	
	public MenuItem getMenuItem(String menuItemNumber);
	public List<MenuItem> getMenu();
	public MenuItem addMenuItem(MenuItem menuItem);
}
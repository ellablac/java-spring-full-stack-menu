package com.ibm.menu.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.menu.model.MenuItem;

import com.ibm.menu.repo.MenuRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MenuServiceImpl implements MenuService{
	
	private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuRepo menuRepo;
	
	@Override
	public MenuItem getMenuItem(String menuItemNumber)
	{
		logger.info("Entered MenuServiceImpl.getMenuItem().  number=" + menuItemNumber);
		return menuRepo.findByMenuItemNumber(menuItemNumber);
		
	}
	
	@Override
	public List<MenuItem> getMenu()
	{
		logger.info("Entered MenuServiceImpl.getMenu().");
		return menuRepo.findAll();
		
	}
	
	@Override
	public MenuItem addMenuItem(MenuItem menuItem)
	{
		logger.info("Entered MenuServiceImpl.addMenuItem().  item =" + menuItem);
		return menuRepo.insert(menuItem);
	}
}

package com.ibm.menu.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;

import com.ibm.menu.model.MenuItem;
import com.ibm.menu.service.MenuService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	private final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	//==========================================================
	// URL: http://ip-address:port/menu/menuitem (POST request) 
	//==========================================================
	
	@RequestMapping(value = "/menuitem", method = RequestMethod.POST)
	public ResponseEntity<?> addMenuItem(@RequestBody MenuItem menuItem) {
		
		logger.info("Entered Contoller.addMenu().  menuItem = {}", menuItem);
		
		menuItem = this.menuService.addMenuItem(menuItem);
		ResponseEntity<MenuItem> responseEntity = 
				new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		
		return responseEntity;
	}
	
     //==========================================================
	 // URL: http://ip-address:port/menu/menu/O123 (GET request)
     //==========================================================
	
	@RequestMapping(value = "/menuitem/{menuItemNumber}")	
	public ResponseEntity<?> getMenuItem(@PathVariable(value="menuItemNumber") String menuItemNumber) {
		
		logger.info("Entered MenuController.getMenuItem.  Menu Item Number={}", menuItemNumber);
		
		MenuItem menuItem = this.menuService.getMenuItem(menuItemNumber);
		logger.debug("MenuController.getMenuItem().  menu={}", menuItem);
		ResponseEntity<MenuItem> responseEntity = 
				new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		
		logger.info("In MenuController.getMenuItem.  Response = {}", responseEntity);
		return responseEntity;
   }
   
	//=====================================================
	// URL: http://ip-address:port/menu/menu (GET request)
	//=====================================================
	
	@RequestMapping(value = "/menu")
	public ResponseEntity<?> getMenu() {
	   
		logger.info("Entered MenuController.getMenu()");
	   
		List<MenuItem> menu = this.menuService.getMenu();
		ResponseEntity<List<MenuItem>> responseEntity = 
			   new ResponseEntity<List<MenuItem>>(menu, HttpStatus.OK);
	   
		return responseEntity;
	}
}
package com.ibm.menu.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.verify;

import com.ibm.menu.model.MenuItem;
import com.ibm.menu.repo.MenuRepo;

import org.bson.types.ObjectId;

class MenuServiceImplTest {

	// A mock MenuEndpoint object will be created and
	// injected so that OrderService can be unit-tested
	// in isolation.
	
	@Mock
	private MenuRepo menuRepo;
	
	@InjectMocks
	private MenuServiceImpl menuService;
	
	// Scan this class and process the Mockito annotations
    @BeforeEach
    public void init() {
       MockitoAnnotations.initMocks(this);
    }
    
    @DisplayName("Test GetMenuItem with an existing menu item.")
	@Test // Tells Junit Runner to run this
	void testGetMenuItemExisting() {
    	// Given - set the parameter values and mock the methods for this test case
        String menuNum = "MNU-1";
        MenuItem menuItemMocked = new MenuItem(new ObjectId(), menuNum, 
        		"Desserts", "Banana Split", "Ice Cream", 10, 3.50);

        when(menuRepo.findByMenuItemNumber(menuNum)).thenReturn(menuItemMocked);
        
        // When - call the method being tested and save the response
        MenuItem menuItem = menuService.getMenuItem(menuNum);
        
        // Then - check that the results are valid (and that the expected mocked methods were called)
        assertNotNull(menuItem, "Menu item should not be null");
        assertEquals(menuItem, menuItemMocked, "menuItem should be the same as: " + menuItemMocked);
     
        verify(menuRepo).findByMenuItemNumber(menuNum);

	}

}





package com.ibm.menu.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.menu.model.MenuItem;

@Repository
public interface MenuRepo extends MongoRepository<MenuItem, Long>
{
	public MenuItem findByMenuItemNumber(String menuItemNumber);
}
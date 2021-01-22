package com.nucleus.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nucleus.entity.Users;

@Repository
public class UserDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void save(Users user) {
		hibernateTemplate.persist(user);

	}
}

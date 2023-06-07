package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.pojo.User;


@Repository
public class UserDAO {
	private HibernateTemplate hibernateTemplate;

    @Autowired
    public UserDAO(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public User getUser(int id) {
        return hibernateTemplate.get(User.class, id);
    }

    public void updateUser(User user) {
        hibernateTemplate.update(user);
    }
}

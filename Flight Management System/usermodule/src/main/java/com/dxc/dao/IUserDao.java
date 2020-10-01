package com.dxc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.entities.User;

public interface IUserDao extends JpaRepository<User, Integer> {

}

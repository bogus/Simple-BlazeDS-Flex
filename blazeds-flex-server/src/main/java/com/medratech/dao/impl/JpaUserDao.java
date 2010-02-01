package com.medratech.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.medratech.dao.GenericJpaDao;
import com.medratech.model.impl.User;

@Service
@Repository
public class JpaUserDao extends GenericJpaDao<User, Long> implements UserDao {

}

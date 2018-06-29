package com.neo.web;

import java.util.List;

import com.neo.mapper.test1.User1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.UserEntity;
import com.neo.mapper.test2.User2Mapper;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private User1Mapper user1Mapper;

	@Resource
	private User2Mapper user2Mapper;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
        return user1Mapper.getAll();
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
        return user2Mapper.getOne(id);
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
        user2Mapper.insert(user);
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
        user2Mapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        user1Mapper.delete(id);
    }
    
    
}
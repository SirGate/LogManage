package com.LogManage.web;

import com.LogManage.User;
import com.LogManage.UsersDAO;

import javax.persistence.EntityManager;
import java.util.List;

public class TestBean {

   private EntityManager em;
   private UsersDAO users;

   public void setup(EntityManager em) {
       this.em = em;
       this.users=new UsersDAO(em);
   }
    public List<User> getUsers(){

       return users.listUsers();
    }
}

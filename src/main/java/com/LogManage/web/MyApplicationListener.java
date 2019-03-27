package com.LogManage.web;

import com.LogManage.Client;
import com.LogManage.UsersDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyApplicationListener implements ServletContextListener {

    public EntityManagerFactory factory;
    public EntityManager em;
    private UsersDAO dao;


    @Override
    public void contextInitialized(ServletContextEvent event){
        factory= Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em=factory.createEntityManager();
        dao=new UsersDAO(em);
        event.getServletContext().setAttribute("em",em);
        initUsers();
    }

@Override
public void contextDestroyed(ServletContextEvent sce) {
   if(em!=null){
       em.close();
   }
   if(factory!=null){
       factory.close();
   }

}

public void initUsers(){
        em.getTransaction().begin();
        try{
          Client client= dao.createClient("Petrov");
          em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            throw new RuntimeException(e);
        }
}

}

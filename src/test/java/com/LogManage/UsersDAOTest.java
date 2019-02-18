package com.LogManage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class UsersDAOTest{

   private  EntityManagerFactory factory;
   private EntityManager em;

   private UsersDAO dao;

   @Before
        public void setup()
    {
      factory=Persistence.createEntityManagerFactory("TestPersistenceUnit");
      em=factory.createEntityManager();
        dao=new UsersDAO(em);
    }

    @After
    public void stop(){
       if(em!=null){
           em.close();
       }
        if(factory!=null){
            factory.close();
        }
           }

    @Test
    public void TestCreateClient(){
       em.getTransaction().begin();
       Client client=dao.createClient("user1");
       em.getTransaction().commit();
       assertNotEquals(0L,client.getId());
       assertEquals("user1",client.getLogin());

   Client found = em.find(Client.class,client.getId());
   assertNotNull(found);
   assertEquals("user1",found.getLogin());
   System.out.println(">>>>Found client ID:"+found.getId());

   User foundByLogin= dao.findUser("user1");
   assertNotNull(foundByLogin);
   if(!(foundByLogin instanceof Client)){
       fail("Expected an instance of Client but "+ foundByLogin.getClass().getSimpleName()+
               " found");

   }

   }

}

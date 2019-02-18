package com.LogManage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RecordsDAOTest {
    private EntityManagerFactory factory;
    private EntityManager em;
    private UsersDAO users;
    private RecordsDAO records;

  @Before
    public void setup()
    {
        factory= Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em=factory.createEntityManager();
        users =new UsersDAO(em);
        records =new RecordsDAO(em);
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
    public void TestCreateRec(){
       em.getTransaction().begin();
       Client client = users.createClient("user1");
       Record record = records.createRecord(client,"user2",
               "sss","www.rbc.ru");

       em.getTransaction().commit();
     }
    @Test
    public void TestfindRec(){
        em.getTransaction().begin();
        Client client = users.createClient("user2");
        Record record = records.createRecord(client,"Tulupov",
                "sss","www.rbc.ru");
        client.setRecords(Arrays.asList(record));

        em.getTransaction().commit();
        em.refresh(client);

        List<Record> found = client.getRecords();
        System.out.println(found);
        assertNotNull(found);
        assertNotEquals(0,found.size());
        assertSame(record,found.get(0));
    }

}

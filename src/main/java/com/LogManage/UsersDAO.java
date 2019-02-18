package com.LogManage;



import javax.persistence.*;

import static com.LogManage.User.FIND_BY_LOGIN_QUERY;

public class UsersDAO {

    private EntityManager em;

    public UsersDAO(EntityManager em) {
        this.em = em;
    }

    public Client createClient (String login) {
        Client client = new Client(login);
        em.persist(client);
        return client;
    }

    public User findUser(String login) {
      //  return em.createQuery("from User where login = :lll", User.class)
        //        .setParameter("lll", login)
          //      .getSingleResult();
        return em.createNamedQuery(User.FIND_BY_LOGIN_QUERY, User.class)
                .setParameter("lll", login)
                .getSingleResult();
    }
}

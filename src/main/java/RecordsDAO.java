import javax.persistence.*;

public class RecordsDAO {

    private EntityManager em;

    public RecordsDAO(EntityManager em) {
        this.em = em;
    }

    public Record createRecord(Client client,
                                       String login,
                                       String password,
                                       String url)
    {
        Record rec = new Record(login,password,url);
        rec.setClient(client);
        em.persist(rec);
        return rec;
    }

}

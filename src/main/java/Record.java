import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="records",
        indexes = {
        @Index(
                name = "url_index",
                columnList = "url"
        )
})
public class Record {
    @Id
    @GeneratedValue
    private int IdNumber;

     @ManyToOne(fetch = FetchType.LAZY)
     @JoinColumn(name = "client_fk")
    private Client client;


    @Column(nullable = false,length=1000)
    private String url;

    @Column(nullable = false,length = 50)
    private String login;

    @Column(nullable = false,length=50)
    private String password;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date ModificationTime;

    public Record(){

    }

    public Record(String login, String password,String url){
         this.login=login;
         this.password=password;
         this.url=url;
    }

    public String getUrl() {
        return url;

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdNumber() {
        return IdNumber;
    }

    public void setIdNumber(int idNumber) {
        IdNumber = idNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getModificationTime() {
        return ModificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        ModificationTime = modificationTime;
    }
}

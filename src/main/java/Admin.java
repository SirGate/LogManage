import javax.persistence.*;

@Entity
@DiscriminatorValue("Ad")
public class Admin extends User {

    public Admin() {
    }
    public Admin(String login) {
        setLogin(login);
    }
}

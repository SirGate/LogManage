package com.LogManage;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Cl")
public class Client extends User {

 @OneToMany(fetch = FetchType.LAZY,
         mappedBy = "client")

private List<Record>records;

    public Client(){

    }

    public Client(String login) {
        setLogin(login);
    }




    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}

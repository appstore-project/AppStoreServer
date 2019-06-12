package edu.eam.appstoreserver.collection;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Collection {
    @Id
    @Length(max=30)
    private String uid; // unique identifier
    private String title;
    private String apps;
}

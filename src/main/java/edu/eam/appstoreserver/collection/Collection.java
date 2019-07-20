package edu.eam.appstoreserver.collection;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.eam.appstoreserver.app.App;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@SequenceGenerator(name="sgCollId", sequenceName = "seqCollId", initialValue = 1, allocationSize = 1)

public class Collection {
    @Id @GeneratedValue(generator = "sgCollId")
    private Long id;
    private Integer position;
    @Length(max=100)
    private String title;
    //@Length(max=500)
    //private String description;

//    @JsonManagedReference
//    @ManyToMany()
//    @JoinTable(
//            name = "collection_apps",
//            joinColumns = @JoinColumn(name = "collection_id"),
//            inverseJoinColumns = @JoinColumn(name = "app_id"))
//    private Set<App> memberApps;
}



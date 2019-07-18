package edu.eam.appstoreserver.collection;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eam.appstoreserver.app.App;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

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
    @ElementCollection(fetch = FetchType.LAZY)
    @JsonIgnore
    private List<App> Apps;
}

package edu.eam.appstoreserver.account;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity
@SequenceGenerator(name="sgDeveloperId", sequenceName = "seqDeveloperId", initialValue = 1, allocationSize = 1)
public class ApsDeveloper {
    @Id
    @GeneratedValue(generator = "sgDeveloperId")
    private Long id;
    private String title;
    //private String name;
    //private String email;
}

package edu.eam.appstoreserver.app;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Data
@Entity
@SequenceGenerator(name="sgAppId", sequenceName = "seqAppId", initialValue = 1, allocationSize = 2)
public class App {
    @Id
    @GeneratedValue(generator = "sgAppId")
    private Long id;
    private String title;
    private String version;

}

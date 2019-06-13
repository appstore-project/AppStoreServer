package edu.eam.appstoreserver.app;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="sgAppId", sequenceName = "seqAppId", initialValue = 1, allocationSize = 1)
public class App {
    @Id
    @GeneratedValue(generator = "sgAppId")
    private Long id;
    private String title;
    private String category;
    @Lob
    @Column (columnDefinition = "BLOB")
    private Byte[] thumbnail;
    @Formula("(select nvl((Select round(sum(r.rate)/count(*),1) from TEST_RATE r where r.app_id=id), 0) from dual)")
    private Float rate;

}

package edu.eam.appstoreserver.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.eam.appstoreserver.account.ApsDeveloper;
import edu.eam.appstoreserver.category.ApsCategory;
import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="sgAppId", sequenceName = "seqAppId", initialValue = 1, allocationSize = 1)
public class App {
    @Id @GeneratedValue(generator = "sgAppId")
    private Long id;
    private String title;

    //ToDo: must be write-only. just link must work
    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long iconFileId;

    //TODO: Erfan; Change the Below test code to a true designed approach.
    @Formula("(select nvl((Select round(sum(r.rate)/count(*),1) from Aps_App_Rate r where r.app_id=id), 0) from dual)")
    private Float rate;

    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name = "fk_app_developer"))
    private ApsDeveloper developer;

    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name = "fk_app_category"))
    private ApsCategory category;

}

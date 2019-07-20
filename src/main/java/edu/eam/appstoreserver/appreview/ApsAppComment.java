package edu.eam.appstoreserver.appreview;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.eam.appstoreserver.account.ApsUser;
import edu.eam.appstoreserver.app.App;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="sgAppComment", sequenceName = "seqAppComment", initialValue = 1, allocationSize = 1)
public class ApsAppComment {
    @Id
    @GeneratedValue(generator = "sgAppComment")
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name = "fk_appcomment_app"))
    private App app;

    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name = "fk_appcomment_user"))
    private ApsUser user;

    @Length(max=1000)
    private String commentText;
}


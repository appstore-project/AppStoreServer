package edu.eam.appstoreserver.app;

import edu.eam.appstoreserver.account.ApsUser;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="sgAppRate", sequenceName = "seqAppRate", initialValue = 1, allocationSize = 1)
public class ApsAppRate {
    @Id @GeneratedValue(generator = "sgAppRate")
    private Long id;

    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name = "fk_apprate_app"))
    private App app;

    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name = "fk_apprate_user"))
    private ApsUser user;

    private Integer rate;
}

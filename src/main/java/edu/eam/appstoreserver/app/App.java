package edu.eam.appstoreserver.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.eam.appstoreserver.account.ApsDeveloper;
import edu.eam.appstoreserver.category.ApsCategory;
import edu.eam.appstoreserver.collection.Collection;
import lombok.Data;
import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@SequenceGenerator(name="sgAppId", sequenceName = "seqAppId", initialValue = 1, allocationSize = 1)
public class App {
    @Id @GeneratedValue(generator = "sgAppId")
    private Long id;
    private String title;

    //ToDo: must be write-only. just link must work
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
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

    //@JsonBackReference
    //@ManyToMany(mappedBy = "memberApps")
    @ManyToMany
    @JoinTable(
            name = "collections_apps",
            joinColumns = @JoinColumn(name = "app_id"),
            inverseJoinColumns = @JoinColumn(name = "collection_id"))
    private Set<Collection> memberedCols;

    /* Extra Info */

    @Digits(integer=5, fraction=2)
    private BigDecimal sizeMB;

    @Length(max=50)
    private String verion;

    @Digits(integer = 10, fraction = 0)
    @Column(columnDefinition = "number(10) default 0")
    private BigDecimal price;

    @Length(max=3000)
    private String decription;

    private Boolean hasInAppPurchase;

    @Formula("(select nvl((Select count(*) from Aps_App_Rate r where r.app_id=id), 0) from dual)")
    private Long raterCount;
    // Comments
    // Install Count or Download Count (Can be same as Rate)


}

package edu.eam.appstoreserver.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eam.appstoreserver.app.App;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class ApsCategory {
    @Id private String Name;

    @ManyToOne(fetch = FetchType.LAZY, optional=true)
    @JoinColumn(foreignKey = @ForeignKey(name = "sk_category"))
    private ApsCategory parent;

//    @EqualsAndHashCode.Exclude
//    @OneToMany (mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<App> apps;

    @JsonIgnore
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<ApsCategory> children;

}

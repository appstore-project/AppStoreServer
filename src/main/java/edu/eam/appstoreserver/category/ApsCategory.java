package edu.eam.appstoreserver.category;

import edu.eam.appstoreserver.app.App;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "apps, children")
public class ApsCategory {
    @Id @GeneratedValue
    private Integer id;
    private String Name;

    @ManyToOne(fetch = FetchType.LAZY, optional=true)
    @JoinColumn
    private ApsCategory parent;

    @OneToMany (mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<App> apps;

    @OneToMany(mappedBy="parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<ApsCategory> children;

}

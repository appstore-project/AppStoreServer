package edu.eam.appstoreserver.file;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.eam.appstoreserver.app.App;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name="sgAppImages", sequenceName = "seqAppImages", initialValue = 1, allocationSize = 1)
public class ApsAppImages {
    @Id
    @GeneratedValue(generator = "sgAppImages")
    private Long id;
//    private LocalDateTime uploadTime;
//    private String fileName;
//    private String fileExt;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn (foreignKey = @ForeignKey(name = "fk_appimage_app"))
    private App app;

    @Lob @Column (columnDefinition = "BLOB")
    @JsonIgnore
    public byte[] fileContent;
}

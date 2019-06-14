package edu.eam.appstoreserver.file;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@SequenceGenerator(name="sgGlobalFileBodyId", sequenceName = "seqGlobalFileBodyId", initialValue = 1, allocationSize = 1)
public class FileBody {
    @Id
    @GeneratedValue(generator = "sgGlobalFileBodyId")
    private Long id;
    private LocalDateTime uploadTime;
    //private String uploaderId;
    //private String accessLevel;
    private String fileName;
    private String fileExt;
    @Lob @Column (columnDefinition = "BLOB")
    @JsonIgnore
    public byte[] fileContent;
}

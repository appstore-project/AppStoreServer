package edu.eam.appstoreserver.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="sgUserId", sequenceName = "seqUserId", initialValue = 1, allocationSize = 1)
public class ApsUser {
    @Id @GeneratedValue(generator = "sgUserId")
    private Long Id;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}

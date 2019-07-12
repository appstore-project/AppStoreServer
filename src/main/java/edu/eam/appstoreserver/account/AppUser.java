package edu.eam.appstoreserver.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(name="sgUserId", sequenceName = "seqUserId", initialValue = 1, allocationSize = 1)
@Table(name = "appUser")
public class AppUser {
    @Id @GeneratedValue(generator = "sgUserId")
    private Long userId;
    @Column(unique = true)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

}

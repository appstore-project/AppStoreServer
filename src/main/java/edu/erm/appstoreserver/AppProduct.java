package edu.erm.appstoreserver;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class AppProduct {
    private @Id @GeneratedValue Long id;
    private String title;
    private String version;
    private String category;

    AppProduct() {}

    AppProduct(String title, String version, String category) {
        this.title = title;
        this.version = version;
        this.category = category;
    }

}
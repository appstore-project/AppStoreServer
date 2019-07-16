package edu.eam.appstoreserver._legacy;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Z_App_Product")
public class AppProduct {
    private @Id @GeneratedValue Long id;
    private Long    appCode;
    private String  name;
    private String  developer;
    private String  rate;  // float
    private String  category;
    private Boolean isGame;   // "boolan" causes "not null" option
    private Integer installCount;
    private String  size_mb;  // float
    private String  version;
    private String  shamed;
    private Integer price;   // "int" causes "not null" option.
    private Boolean inAppPurchase;
    private String  descr;
    private String  lastChanges;
//    private String  access;
    private String  comments; //JSON

//    private String title;
//    private String version;
//    private String category;

//    AppProduct(String title, String version, String category) {
//        this.title = title;
//        this.version = version;
//        this.category = category;
//    }
//
//    AppProduct(
//        Long appCode,
//        String name,
//        String developer,
//        String rate,
//        String category,
//        Boolean isGame,
//        Integer installCount,
//        String size_mb,
//        String version,
//        String shamed,
//        Integer price,
//        Boolean inAppPurchase,
//        String descr,
//        String lastChanges,
////        String access,
//        String comments
//    ) {
//        this.appCode = appCode;
//        this.name = name;
//        this.developer = developer;
//        this.rate = rate;
//        this.category = category;
//        this.isGame = isGame;
//        this.installCount = installCount;
//        this.size_mb = size_mb;
//        this.version = version;
//        this.shamed = shamed;
//        this.price = price;
//        this.inAppPurchase = inAppPurchase;
//        this.descr = descr;
//        this.lastChanges = lastChanges;
////        this.access = access;
//        this.comments = comments;
//    }
}
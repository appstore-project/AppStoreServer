package edu.eam.appstoreserver.collection;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollectionController {
    private final static String BASE_URI="/api/store/collections";
    private final Collections rows;

    CollectionController(Collections rows) {
        this.rows = rows;
    }

    @GetMapping(value=BASE_URI, produces = "application/json; charset=UTF-8")
    List<Collection> all() {
        return rows.findAll(Sort.by("position"));
    }

    @GetMapping(value=BASE_URI+"/{id}", produces = "application/json; charset=UTF-8")
    Collection one(@PathVariable Integer id){
        return rows.findById(id).orElseThrow(()-> new RuntimeException());
    }


}

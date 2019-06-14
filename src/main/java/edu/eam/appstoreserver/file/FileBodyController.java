package edu.eam.appstoreserver.file;

import edu.eam.appstoreserver.NotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class FileBodyController {
    private final static String BASE_URI="/api/store/files";
    private final FileBodies files;

    FileBodyController(FileBodies files){
        this.files = files;
    }

    @GetMapping(value=BASE_URI+"/{id}", produces = "application/json; charset=UTF-8")
    FileBody one(@PathVariable Long id){
        return files.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    //TODO: Erfan; Solve MediaType HardCode
    @GetMapping(value=BASE_URI+"/{id}/content", produces = "image/png")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        FileBody file = files.findById(id).orElseThrow(() -> new NotFoundException(id));
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(file.fileContent);
    }

}

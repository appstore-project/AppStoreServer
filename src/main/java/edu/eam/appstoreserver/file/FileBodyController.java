package edu.eam.appstoreserver.file;

import edu.eam.appstoreserver.AStoreConfig;
import edu.eam.appstoreserver.EntityNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(AStoreConfig.apiBaseURL)
public class FileBodyController {
    private final FileBodies files;

    FileBodyController(FileBodies files){
        this.files = files;
    }

    @GetMapping(value="/files/{id}", produces = "application/json; charset=UTF-8")
    FileBody one(@PathVariable Long id){
        return files.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    //TODO: Erfan; Solve MediaType HardCode
    @GetMapping(value="/files/{id}/content", produces = "image/png")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        FileBody file = files.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(file.fileContent);
    }

}

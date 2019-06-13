package edu.eam.appstoreserver.file;

import com.sun.deploy.util.ArrayUtil;
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
import jdk.nashorn.internal.runtime.JSType;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
        return files.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @GetMapping(value=BASE_URI+"/{id}/content", produces = "image/png")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) throws IOException {
        FileBody file = files.findById(id).orElseThrow(() -> new RuntimeException());
        byte[] bytes=file.fileContent;
        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }

}

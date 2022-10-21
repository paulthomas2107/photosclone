package com.pault.code.photosclone.web;

import com.pault.code.photosclone.model.Photo;
import com.pault.code.photosclone.service.PhotosService;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Data
@Log
@RestController
public class DownloadController {

    @Autowired
    private final PhotosService photosService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {

        Photo photo = photosService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        byte[] data = photo.getData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition
                .builder("attachment")
                .filename(photo.getFileName())
                .build();
        headers.setContentDisposition(build);

        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }
}

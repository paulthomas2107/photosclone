package com.pault.code.photosclone;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Data
@Log
@RestController
public class PhotosController {

    private Map<String, Photo> db = new HashMap<>() {{
        put("0001", new Photo("0001", "hello.jpg"));
    }};

    @GetMapping("/")
    public String hello() {
        log.info("In hello....");
        return "Hello Paul !";
    }

    @GetMapping("/photos")
    public Collection<Photo> get() {
        return db.values();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable String id) {
        Photo photo = db.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @RequestMapping(value = "/photos/{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        Photo photo = db.remove(id);
        log.info(photo.toString());
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/photos")
    public Photo create(@RequestBody Photo photo) {
        photo.setId(UUID.randomUUID().toString());
        db.put(photo.getId(), photo);
        return photo;
    }
}


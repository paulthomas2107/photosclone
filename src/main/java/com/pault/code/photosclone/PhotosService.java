package com.pault.code.photosclone;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
@Log
@Service
public class PhotosService {

    private Map<String, Photo> db = new HashMap<>() {{
        byte [] data = {0};
        put("0001", new Photo("0001", "content", "hello.jpg", data));
    }};

    public Collection<Photo> get() {
        return db.values();
    }

    public Photo get(String id) {
        return db.get(id);
    }

    public Photo remove(String id) {
        return db.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db.put(photo.getId(), photo);
        return photo;
    }
}

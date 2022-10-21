package com.pault.code.photosclone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log
public class Photo {

    private String id;
    @NotEmpty
    private String fileName;
    private String contentType;
    @JsonIgnore
    private byte[] data;
}

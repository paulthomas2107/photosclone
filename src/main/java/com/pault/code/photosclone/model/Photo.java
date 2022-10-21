package com.pault.code.photosclone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Log
@Table("PHOTOS")
public class Photo {

    @Id
    private Integer id;
    @NotEmpty
    private String fileName;
    private String contentType;
    @JsonIgnore
    private byte[] data;
}

package com.thaiana.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Terminal {

    @Id
    private int logic;
    private String serial;
    private String model;
    private int sam;
    private String ptid;
    private int plat;
    private String version;
    private int mxr;
    private int mxf;
    private String verfm;

}

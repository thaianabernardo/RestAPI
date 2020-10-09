package com.thaiana.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Terminal {

    private String serial;
    private String model;
    private String version;
    private String ptid;
    private String verfm;
    private int logic;
    private int plat;
    private int mxr;
    private int sam;
    private int mxf;

}

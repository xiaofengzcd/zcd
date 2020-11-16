package com.zcd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    
    private static final long serialVersionUID = -1023799581614463759L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private Integer age;
    private String VerifyCode;

    
}
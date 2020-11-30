package com.zcd.model;

import com.zcd.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    
    private static final long serialVersionUID = -1023799581614463759L;

    
    private String username;
    
    private String password;
    
    private Integer age;
    private String VerifyCode;


    /*private InputStream headImage;*/

    
}
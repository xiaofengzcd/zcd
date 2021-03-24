package com.zcd.model;

import com.zcd.base.BaseEntity;
import com.zcd.util.RegexpUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    
    private static final long serialVersionUID = -1023799581614463759L;

    @Length(max = 20,min = 6,message = "用户名长度必须为6 - 20 之间")
    private String username;
    
    private String password;
    
    private Integer age;
    private String VerifyCode;

    // regexpUtils  正则表达式工具类 提供手机号,邮箱格式校验
    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;

    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
    /*private InputStream headImage;*/

    
}
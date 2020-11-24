/*
package com.zcd.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zcd.base.BaseEntity;
import com.zcd.util.RegexpUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.Pattern;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity */
/*extends BaseEntity*//*
 {
  @Length(min = 6, max = 20, message = "姓名的长度必须介于 6 - 20 位之间")
    private String username;

    @JsonIgnore
    private String password;

    @Pattern(regexp = RegexpUtils.PHONE, message = "手机号格式不正确")
    private String phone;

    @Pattern(regexp = RegexpUtils.EMAIL, message = "邮箱格式不正确")
    private String email;
}
*/

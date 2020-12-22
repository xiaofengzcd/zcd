package com.zcd.model;

import com.zcd.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author zcd
 * @description:
 * @create 2020/12/17 15:16
 */


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods extends BaseEntity {

    private static final long serialVersionUID = -286531579426515965L;
  //  private  int id ;
    private String name;
    private String description ;
    private  String detail;

}

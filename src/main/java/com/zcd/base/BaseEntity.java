package com.zcd.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 * <p>Title: BaseEntity</p>
 * <p>Description: </p>
 *
 * @author zcd
 * @version 1.0.0
 * @date 2020/11/30 15:28
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4438184833567586456L;
    private Long id;
    private Date createDatetime;
    private Date modifyDatetime;

}

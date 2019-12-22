package com.javen.pojo;

import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import com.github.liaochong.myexcel.core.annotation.ExcelTable;
import com.github.liaochong.myexcel.core.annotation.ExcludeColumn;

import java.time.LocalDateTime;

/**
 * @author zcd
 * @description:
 * @create 2019/11/5 14:39
 */


    @ExcelTable(sheetName = "艺术生")
    public class ArtCrowd {

        @ExcelColumn(order = 0, title = "姓名")
        private String name;

        @ExcelColumn(order = 1, title = "年龄")
        private Integer age;

        @ExcelColumn(order = 2, title = "性别")
        private String gender;

        @ExcelColumn(order = 3,title = "绘画等级")
        private String paintingLevel;

        @ExcelColumn(order = 4, title = "是否会跳舞")
        private boolean dance;

        @ExcelColumn(order = 5, title = "考核时间", dateFormatPattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime assessmentTime;

        @ExcludeColumn
        private String hobby;
    }


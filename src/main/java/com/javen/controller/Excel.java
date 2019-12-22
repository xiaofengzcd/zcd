package com.javen.controller;
import com.github.liaochong.myexcel.core.DefaultExcelBuilder;
import com.github.liaochong.myexcel.core.annotation.ExcelColumn;
import com.github.liaochong.myexcel.core.annotation.ExcelTable;
import com.github.liaochong.myexcel.core.annotation.ExcludeColumn;
import com.github.liaochong.myexcel.utils.AttachmentExportUtil;
import com.github.liaochong.myexcel.utils.FileExportUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2019/11/13 10:23
 */
@RestController
public class Excel {

    @RequestMapping("/default/excel/example")
    public void defaultBuild(HttpServletResponse response) throws Exception {
        List<ArtCrowd> dataList = this.getDataList();
        Workbook workbook = DefaultExcelBuilder.of(ArtCrowd.class)
                .build(dataList);
        AttachmentExportUtil.export(workbook, "艺术生信息", response);
    }
    //  附件加密导出示例：

    /* @GetMapping("/default/excel/example")
     public void defaultBuild(HttpServletResponse response) throws Exception {
         List<ArtCrowd> dataList = this.getDataList();
         Workbook workbook = DefaultExcelBuilder.of(ArtCrowd.class)
                 .build(dataList);
         AttachmentExportUtil.encryptExport(workbook, "艺术生信息", response,"123456");
     }*/
    // 文件导出示例：
//File file = new File("/Users/mac/lzz/艺术生信息.xlsx");
    @RequestMapping("/export")
   public void Export() throws IOException {
        List<ArtCrowd> dataList = this.getDataList();
        Workbook workbook = DefaultExcelBuilder.of(ArtCrowd.class)
                .build(dataList);
        FileExportUtil.export(workbook, new File("/Users/Administrator/Desktop/艺术生信息.xlsx"));
    }


    // 文件加密导出示例：

/*    List<ArtCrowd> dataList = this.getDataList();
    Workbook workbook = DefaultExcelBuilder.of(ArtCrowd.class)
            .build(dataList);
FileExportUtil.encryptExport(workbook, new File("/User/demo.xlsx"),"123456");*/
    //  数据获取：

    private List<ArtCrowd> getDataList() {
        List<ArtCrowd> dataList = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            ArtCrowd artCrowd = new ArtCrowd();
            artCrowd.setName("李四");
            artCrowd.setAge(18);
            artCrowd.setGender("Woman");
            artCrowd.setPaintingLevel("一级证书");
            artCrowd.setDance(true);
            artCrowd.setAssessmentTime(LocalDateTime.now());
            artCrowd.setHobby("钓鱼");
            dataList.add(artCrowd);
        }
        return dataList;
    }

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPaintingLevel() {
            return paintingLevel;
        }

        public void setPaintingLevel(String paintingLevel) {
            this.paintingLevel = paintingLevel;
        }

        public boolean isDance() {
            return dance;
        }

        public void setDance(boolean dance) {
            this.dance = dance;
        }

        public LocalDateTime getAssessmentTime() {
            return assessmentTime;
        }

        public void setAssessmentTime(LocalDateTime assessmentTime) {
            this.assessmentTime = assessmentTime;
        }

        public String getHobby() {
            return hobby;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }
    }
}

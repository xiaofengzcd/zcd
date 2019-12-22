package com.javen.pojo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author zcd
 * @description:
 * @create 2019/11/5 13:10
 */
public class Excel {

    private String row[]={"1","2","3"};
    private String column[]={"1","2","3"};


    void export() throws IOException {
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();
//创建HSSFSheet对象  Sheet 表单
        HSSFSheet sheet = wb.createSheet("第一页");
//创建HSSFRow对象  row = 行
        HSSFRow row = sheet.createRow(0);
//创建HSSFCell对象
        HSSFCell cell=row.createCell(0);
//设置单元格的值
        cell.setCellValue("单元格中的中文");


//输出Excel文件  C:\Users\Administrator\Desktop
        FileOutputStream output=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\workbook.xls");
        wb.write(output);
        output.flush();
        /*原文链接：https://blog.csdn.net/ethan_10/article/details/80335350*/
    }


    public static void main(String[] args) throws IOException {
        Excel excel = new Excel();
        excel.export();

    }
}

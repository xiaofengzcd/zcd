package com.javen.easyExcel;

import com.alibaba.excel.metadata.Sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zcd
 * @description:  easyExcel简单测试,尚未加入大量数据
 * @create 2019/11/22 9:07
 * @link  https://blog.csdn.net/qq_32258777/article/details/89031479
 */
public class Test {
    static void Import(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\demo.xlsx";
        List<Object> objects = ExcelUtil.readLessThan1000Row(filePath);
        //他这个读取出来的excel是以每一行为一个数组,空格显示为null,如下
        //[[zcd, zcx, sf, null, fc, null, ts], [詹栋, 朱彩霞], [沿途丶有歌], [啦啦啦啦啦啦, 嘎嘎嘎嘎嘎嘎嘎]]
        System.out.println(objects);
    }

    //指定读出某个表单(sheet)
    static void Import2(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\demo.xlsx";
        //第一个1代表sheet1, 第二个1代表从第几行开始读取数据，行号最小值为0
        Sheet sheet = new Sheet(2, 0);
        List<Object> objects = ExcelUtil.readLessThan1000RowBySheet(filePath,sheet);
        System.out.println(objects);
    }

    // 手输,适合少量数据导出,没鸟用
    static void export(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\测试.xlsx";
        List<List<Object>> data = new ArrayList<>();
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        data.add(Arrays.asList("111","222","333"));
        List<String> head = Arrays.asList("表头1", "表头2", "表头3");
        ExcelUtil.writeBySimple(filePath,data,head);
    }
     // idea如果报错说找不到poi.ss的某个类,有可能是poi的版本低了,4.1.0可成功执行
    static void export2(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\测试.xlsx";
        ArrayList<TableHeaderExcelProperty> data = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            TableHeaderExcelProperty tableHeaderExcelProperty = new TableHeaderExcelProperty();
            //他这个setName是根据表头来设的,如果set两个name,后面的会覆盖前面的
            //思考: 正式项目数据一般是从requestParam里传来的,此时该如何遍历
            tableHeaderExcelProperty.setName("cmj" + i);
            tableHeaderExcelProperty.setName("zcd" + i);
            tableHeaderExcelProperty.setAge(22 + i);
            tableHeaderExcelProperty.setSchool("清华大学" + i);
            data.add(tableHeaderExcelProperty);
        }
        ExcelUtil.writeWithTemplate(filePath,data);
        System.out.println("导出成功!");
    }


    public static void main(String[] args) {
        // Import2();
        export2();
    }

}

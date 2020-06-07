package com.zcd.word;


import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.render.RenderAPI;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zcd
 * @description:
 * @create 2020/4/22 15:43
 */

public class WordTest {
    public static void main(String[] args) throws Exception {
        //构造数据
        Map<String, Object> datas = new HashMap<String, Object>();
        datas.put("createTime","");
        datas.put("sortNo","");
        datas.put("projectName","");
        datas.put("orgName","");
        datas.put("name","");
        datas.put("problemContent","");
        datas.put("commonFileName","");
        datas.put("problemDescription","");
        datas.put("lawContent","");
        datas.put("feedbackContent","");
        datas.put("creatorName","");
        datas.put("auditor1Name","");
        datas.put("auditor2Name","");
        datas.put("auditor3Name","");
        datas.put("auditor4Name","");



        //读取模板，进行渲染
        XWPFTemplate doc = XWPFTemplate.compile("C:/Users/Administrator/Desktop/zcd.docx");
        RenderAPI.render(doc, datas);
        //输出渲染后的文件
        FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/wordTest.docx");
        doc.write(out);
        out.flush();
        out.close();
    }

}

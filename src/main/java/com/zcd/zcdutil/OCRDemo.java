package com.zcd.zcdutil;


import net.sourceforge.tess4j.ITesseract;

import net.sourceforge.tess4j.Tesseract;

import net.sourceforge.tess4j.TesseractException;

import java.io.File;




/**
 * @author zcd
 * @description: 图片文字识别,经测试,英文识别效果不错,中文识别效果不堪入目,基本用不了
 * @create 2020/11/17 11:01
 */

public class OCRDemo {

    public static void main(String[] args)throws TesseractException {

        ITesseract instance =new Tesseract();

//如果未将tessdata放在根目录下需要指定绝对路径

 //instance.setDatapath("the absolute path of tessdata");

 //如果需要识别英文之外的语种，需要指定识别语种，并且需要将对应的语言包放进项目中

instance.setLanguage("chi_sim");   //chi_sim是中文的语言包

// 指定识别图片

 File imgDir =new File("src\\main\\resources\\static\\中文.png");

long startTime = System.currentTimeMillis();

 String ocrResult = instance.doOCR(imgDir);

 // 输出识别结果

 System.out.println("OCR Result: \n" + ocrResult +"\n 耗时：" + (System.currentTimeMillis() - startTime) +"ms");

}

}

package com.zcd.pojo;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述:
 *
 * @author lizz
 * @create 2019-06-03 10:00
 */
public class PdfTest {
    public static String pdf2String(File file) throws IOException {
        PDDocument document = PDDocument.load(file);
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(false);
        System.out.println(stripper.getText(document));

        return null;
    }


//    public static void main(String[] args) throws IOException {
//        pdf2String(new File("/Users/mac/lzz/国家电网“互联网+营销服务”.pdf"));
//    }
    
    
    public static void main(String[] args) throws IOException {
        String outputPath = "C:/Users/Administrator/Desktop/zcd.txt";
        PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));
        String fileName = "C:/Users/Administrator/Desktop/sql.pdf";
       /* avc.split
        PdfDocument doc = new PdfDocument();
    doc.loadFromFile("test.pdf");
    //调用方法split()将PDF文档按每一页拆分为单独的文档
    doc.split("output/splitDocument-{0}.pdf", 0);
    doc.close();*/
        String limit = readPdf(writer, fileName);//直接读全PDF面
        

        //readPdf_filter(fileName);//读取PDF面的某个区域
        System.out.println(limit.split("第二章组织架构与职责", 2).toString());
    }
    
    
    public static String readPdf(PrintWriter writer, String fileName) {
        String pageContent = "";
        try {
            PdfReader reader = new PdfReader(fileName);
            int pageNum = reader.getNumberOfPages();
            for (int i = 1; i <= pageNum; i++) {
                pageContent += PdfTextExtractor.getTextFromPage(reader, i);
            }
            writer.write(pageContent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        return pageContent;
    }

    public static void readPdf_filter(PrintWriter writer, String fileName) {
        String pageContent = "";
        try {
            Rectangle rect = new Rectangle(90, 0, 450, 40);
            RenderFilter filter = new RegionTextRenderFilter(rect);
            PdfReader reader = new PdfReader(fileName);
            int pageNum = reader.getNumberOfPages();
            TextExtractionStrategy strategy;
            for (int i = 1; i <= pageNum; i++) {
                strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(), filter);
                pageContent += PdfTextExtractor.getTextFromPage(reader, i, strategy);
            }
			/*String[] split = pageContent.split(" ");
			for(String ss : split){
				System.out.println(ss.substring(ss.lastIndexOf("：")+1, ss.length()));
			}*/
            writer.write(pageContent);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}

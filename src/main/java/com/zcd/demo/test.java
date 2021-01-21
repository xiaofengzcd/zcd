package com.zcd.demo;

import java.io.*;

public class test {
    public static void main(String[] args) throws IOException {
        IOsql("C:\\Users\\hasee\\Desktop\\test.sql", "C:\\Users\\hasee\\Desktop\\test1.sql");
    }

    public static void IOsql(String InputUrl, String OutUrl) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(InputUrl), "GBK"));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OutUrl), "GBK"));
        String str = null;
        int i = 1;
        while ((str = in.readLine()) != null) {
            if (!str.equals("")) {
                if (!(i % 10 == 1)) {
                    str = str.substring(str.indexOf("values") + 6);
                }
                if (!(i % 10 == 0)) {
                    str = str.replace(';', ',');
                }
                System.out.println(str);
                out.write(str);
                out.newLine();
                i++;
            }
        }
        /*flush() 是清空，而不是刷新啊。
         一般主要用在IO中，即清空缓冲区数据，就是说
         你用读写流的时候，其实数据是先被读到了内存中
         ，然后用数据写到文件中，当你数据读完的时候不代表你的数据已经写完了，
         因为还有一部分有可能会留在内存这个缓冲区中。这时候如果你调用了
         close()方法关闭了读写流，那么这部分数据就会丢失，所以应该在关闭读写流之前先flush()
         ，先清空数据。*/
        out.flush();
        in.close();
        out.close();
    }
}

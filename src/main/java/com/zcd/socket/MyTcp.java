package com.zcd.socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import static java.lang.System.out;

/**
 * @author zcd
 * @description:   简单的单点通讯,先启动服务端
 * @create 2021/1/17 12:59
 */
public class MyTcp {

    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;

    void getServer(){
        try {
            server=new ServerSocket(8998);        //实例化Socket对象
            out.println("服务器Socket已创建成功");

            while(true) {
                out.println("等待客户机的连接");
                socket=server.accept();           //accept()方法会返回一个和客户端Socket对象相连的Socket对象
                reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    //读取客户端发送过来的信息
    private void getClientMessage() {
        try {
            while(true) {
                //获得客户端信息
                out.println("客户机："+reader.readLine());
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            if(reader!=null) {
                reader.close();
            }
            if(socket!=null) {
                socket.close();
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        MyTcp tcp=new  MyTcp();
        tcp.getServer();
    }

}
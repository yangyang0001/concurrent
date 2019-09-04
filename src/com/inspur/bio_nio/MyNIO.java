package com.inspur.bio_nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-23 21:01
 * BIO 实现 NIO的 思想
 */
public class MyNIO {

    public static List<Socket> socketList = new ArrayList<Socket>();


    public static void main(String[] args) throws IOException {
//        ServerSocket serverSocket = new ServerSocket(8888);
//        serverSocket.setBlockingConfig(false);  //链接 不阻塞
//
//        while (true) {
//            Socket socket = serverSocket.accept();
//            if(socket != null) {
//                for (int i = 0; i < socketList.size(); i++) {
//                    //logic 处理自己的逻辑
//                }
//            } else {
//                //记录只打开链接的 channel
//                socketList.add(socket);
//                socket.setBlockingConfig(false);        //读取 不阻塞
//                InputStream inputStream = socket.getInputStream();
//                byte[] bytes = new byte[1024];
//                int readCount = inputStream.read(bytes);
//                if(readCount == 0) {
//
//                } else {
//                    //读取当前连接的数据就OK了
//                    for (int i = 0; i < socketList.size(); i++) {
//                        //logic 处理自己的逻辑
//                    }
//                }
//            }
//        }




    }
}

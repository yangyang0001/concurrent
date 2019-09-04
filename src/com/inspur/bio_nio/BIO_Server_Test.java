package com.inspur.bio_nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-23 18:21
 */
public class BIO_Server_Test {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSoket = new ServerSocket(8888);
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        while (true) {

            System.out.println("connect await");
            Socket socket = serverSoket.accept();
            System.out.println("connect success");

            System.out.println("wait data ...");
            int readCount = socket.getInputStream().read(byteBuffer.array());
            byteBuffer.flip();
            System.out.println("client message is :" + new String(byteBuffer.slice().array(), Charset.forName("UTF-8")));
        }
    }
}

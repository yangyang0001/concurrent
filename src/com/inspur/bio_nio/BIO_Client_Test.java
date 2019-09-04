package com.inspur.bio_nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @program: concurrent
 * @description: No Description
 * @author: Yang jian wei
 * @create: 2019-08-23 18:21
 */
public class BIO_Client_Test {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8888);
        Scanner scanner = new Scanner(System.in);
        byte[] bytes = scanner.next().getBytes(Charset.forName("UTF-8"));
        socket.getOutputStream().write(bytes);
    }
}

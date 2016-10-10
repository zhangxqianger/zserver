package com.zserver.boot;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2016/10/10.
 * 连接系
 */
public class HttpConnector implements Runnable {
    boolean stopped;
    private String scheme = "http";

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 10086;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("连接服务器错误");
            System.exit(1);
        }

        while (!stopped) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            HttpProcessor httpProcessor = new HttpProcessor(this);
            httpProcessor.process(socket);
        }
    }

    // 启动方法
    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }
}

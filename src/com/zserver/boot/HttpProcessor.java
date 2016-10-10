package com.zserver.boot;

import com.zserver.http.HttpRequest;
import com.zserver.http.HttpResponse;

import java.io.*;
import java.net.Socket;

/**
 * Created by Administrator on 2016/10/10.
 * 处理器
 */
public class HttpProcessor {
    private HttpConnector httpConnector;
    private HttpRequest request;
    private HttpResponse response;

    public HttpProcessor(HttpConnector httpConnector) {
        this.httpConnector = httpConnector;
    }

    public void process(Socket socket) {
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // 创建请求、响应对象。
            request = new HttpRequest(inputStream);
            response = new HttpResponse(outputStream);
            response.setHeader("Server", "zserver");

            // 解析http请求
            parseRequest(inputStream, outputStream);
            parseHeaders(inputStream);

            outputStream.write(("HTTP/1.1 200 OK\r\nServer: 哈哈\r\n\r\nHelloWorld").getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseRequest(InputStream inputStream, OutputStream outputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

    }

    private void parseHeaders(InputStream inputStream) {

    }
}

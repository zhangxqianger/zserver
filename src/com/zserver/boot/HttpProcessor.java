package com.zserver.boot;

import java.net.Socket;

/**
 * Created by Administrator on 2016/10/10.
 * 处理器
 */
public class HttpProcessor {
    private HttpConnector httpConnector;

    public HttpProcessor(HttpConnector httpConnector) {
        this.httpConnector = httpConnector;
    }

    public void process(Socket socket) {

    }
}

package com.zserver.boot;

/**
 * Created by Administrator on 2016/10/9.
 * 启动程序
 */
public class BootStrap {
    public static void main(String[] args) {
        // 开始项目了
        HttpConnector httpConnector = new HttpConnector();
        httpConnector.start();
    }
}

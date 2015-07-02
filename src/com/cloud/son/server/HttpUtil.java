package com.cloud.son.server;

import com.cloud.son.server.handler.TestHandler;
import com.cloud.son.server.handler.UserInfoHandler;
import com.cloud.son.utils.PropertyUtil;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class HttpUtil {

    private static HttpServer server;
    private static Map<String, HttpHandler> handlers;

    static {
        handlers = new HashMap<>();
        handlers.put("/user", new UserInfoHandler());
        handlers.put("/test", new TestHandler());
    }

    public HttpUtil() {
        try {
            if (null == server) {
                server = HttpServer.create(
                        new InetSocketAddress(
                                Integer.valueOf(PropertyUtil.getProperty(PropertyUtil.KEY_SERVER_PORT))), 0);
            }

            for (Map.Entry<String, HttpHandler> entry : handlers.entrySet()) {
                server.createContext(entry.getKey(), entry.getValue());
            }

            server.setExecutor(null);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public enum ContentType {
        user,
        history,
        request,
        test,
    }


}

package com.cloud.son.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * Created by wengshinan on 2015/6/26.
 */
public class HttpUtil {

    public enum ContentType{
        user,
        history,
        request,
        test,
    }

    private static HttpServer server;

    public HttpUtil(){
        try {
            if (null == server) server = HttpServer.create(new InetSocketAddress(8889), 0);
            server.createContext("/user", new UserInfoHandler());
            server.createContext("/user/test", new TestHandler());
            server.setExecutor(null);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class UserInfoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            //httpExchange.getRequestHeaders();
            String response = "Response From UserInfo";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes("utf-8"));
            os.close();
        }
    }

    public class TestHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String response = "Response From Test";
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes("utf-8"));
            os.close();

        }
    }

}

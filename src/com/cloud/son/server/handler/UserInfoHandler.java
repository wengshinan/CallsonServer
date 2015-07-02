package com.cloud.son.server.handler;

import com.sun.deploy.net.HttpResponse;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * Created by wengshinan on 15/7/1.
 */
public class UserInfoHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        InputStream is = httpExchange.getRequestBody();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String request = null;
        while ((line = br.readLine()) != null) {
            request += line;
        }
        System.out.println(request);

        String response = "Response From UserInfo";
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes("utf-8"));
        os.close();
    }
}

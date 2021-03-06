package com.cloud.son.server.handler;

import com.cloud.son.controller.UserController;
import com.cloud.son.utils.PropertyUtil;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.net.HttpURLConnection;

/**
 * Created by wengshinan on 15/7/1.
 */
public class UserInfoHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        InputStream is = httpExchange.getRequestBody();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        String reqStr = "";
        while ((line = br.readLine()) != null) {
            reqStr += line;
        }
        System.out.println(reqStr);

        int uid = Integer.valueOf(httpExchange.getRequestHeaders().getFirst("uid"));
        String token = httpExchange.getRequestHeaders().getFirst("token");

        UserController userCont = new UserController(uid, token);
        String response = userCont.dealRequest(reqStr);


        //String response = "Response From UserInfo";
        httpExchange.getResponseHeaders().set("token", userCont.getToken());
        httpExchange.sendResponseHeaders(HttpURLConnection.HTTP_OK, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes(PropertyUtil.getProperty(PropertyUtil.KEY_CHARSET)));
        os.close();
    }
}

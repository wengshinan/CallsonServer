package com.cloud.son.test;

import com.cloud.son.data.DataProperty;
import com.cloud.son.data.RequestType;
import com.cloud.son.data.entity.CallsonUser;
import com.cloud.son.data.entity.Request;
import com.cloud.son.data.entity.UserProperty;
import com.cloud.son.data.parser.CallsonUserParser;
import com.cloud.son.data.parser.RequestParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by wengshinan on 15/7/1.
 */
public class ClientTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 测试并发对MyHttpServer的影响
        //for (int i = 0; i < 20; i++) {
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        startWork();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            exec.execute(run);
        //}
        exec.shutdown();// 关闭线程池
    }

    public static void startWork() throws IOException {
        URL url = new URL("http://127.0.0.1:8889/user");
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        urlConn.setDoOutput(true);
        urlConn.setDoInput(true);
        urlConn.setRequestMethod("POST");
        urlConn.addRequestProperty("phone", "18695600115");
        urlConn.addRequestProperty("token", "test_token");
        // 测试内容包
        String teststr = RequestParser.create(DataProperty.DataType.JSON, getTestRequest());
        OutputStream out = urlConn.getOutputStream();
        out.write(teststr.getBytes());
        out.flush();
        while (urlConn.getContentLength() != -1) {
            if (urlConn.getResponseCode() == 200) {
                String token = urlConn.getHeaderField("token");

                InputStream in = urlConn.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String temp = "";
                while ((temp = reader.readLine()) != null) {
                    System.err.println("server response:" + temp);// 打印收到的信息
                }
                reader.close();
                in.close();
                urlConn.disconnect();
            }
        }
    }

    public static CallsonUser getTestUser() {
        CallsonUser user = new CallsonUser();
        user.setType(CallsonUser.UserType.CUSTOMER);
        UserProperty userProp = new UserProperty();
        userProp.setAge(18);
        userProp.setEnName("Bob");
        userProp.setPassword("123456");
        userProp.setPhone("18695600115");

        user.setUProp(userProp);
        return user;
    }

    public static Request getTestRequest() {
        Request request = new Request();

        request.setRequestType(RequestType.UserInfoReqType.REGISTER.name());
        request.setRequestBody(CallsonUserParser.create(DataProperty.DataType.JSON, getTestUser()));

        return request;
    }
}

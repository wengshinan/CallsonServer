package com.cloud.son.controller;

import com.cloud.son.module.SessionModule;
import com.cloud.son.utils.EncodeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wengshinan on 15/7/6.
 */
public final class SessionController {

//    private static Map<Integer, String> tokens = new HashMap<>();

    public static boolean checkTokenValid(int key, String value) {
        if (SessionModule.isSessionExist(key, value)) return true;
        return false;
    }

    public static String resetToken(int key, String value) {

        String token;
        try {
            EncodeUtil encodeUtil = new EncodeUtil();
            token = encodeUtil.encrypt(value);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        if (restoreToken(key, token)) {
            return token;
        }

        return null;
    }

    private static boolean restoreToken(int key, String value) {

        if (SessionModule.isSessionExist(key)) {
            SessionModule.updateSession(key, value);
        }
        SessionModule.addNewSession(key, value);

        return true;
    }

    public static boolean abandonToken(int key, String value) {
        if (SessionModule.isSessionExist(key, value)) {
            SessionModule.deleteSession(key);
            return true;
        }
        return false;

    }

    public static boolean abandonToken(int key) {
        if (SessionModule.isSessionExist(key)) {
            SessionModule.deleteSession(key);
            return true;
        }
        return false;
    }
}

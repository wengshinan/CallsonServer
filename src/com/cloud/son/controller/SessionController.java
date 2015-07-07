package com.cloud.son.controller;

import com.cloud.son.utils.EncodeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wengshinan on 15/7/6.
 */
public final class SessionController {

    private static Map<String, String> tokens = new HashMap<>();

    public static boolean checkToken(String key, String value) {
        if (tokens.get(key).equals(value) == true) return true;
        return false;
    }

    public static String resetToken(String key, String value) {

        String token = null;
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

    private static boolean restoreToken(String key, String value) {

        if (tokens.containsKey(key)) {
            tokens.remove(key);
        }
        tokens.put(key, value);


        return true;
    }

    public static boolean abandonToken(String key, String value) {
        if (tokens.containsKey(key) && tokens.get(key).equals(value)) {
            tokens.remove(key);
            return true;
        }
        return false;

    }
}

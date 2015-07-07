package com.cloud.son.module;

import com.cloud.son.utils.DbUtil;
import com.cloud.son.utils.EncodeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wengshinan on 2015/7/7.
 */
public class SessionModule {

    // 是否存在uid的session
    public static boolean isSessionExist(int uid) {
        boolean flag = false;
        Connection conn = DbUtil.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement("select count(1) from session where uid=?");
            ps.setInt(1, uid);
            try {
                rs = ps.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    flag = true;
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // 查询是否存在该session
    public static boolean isSessionExist(int uid, String token) {
        boolean flag = false;
        Connection conn = DbUtil.getConnection();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conn.prepareStatement("select count(1) from session where uid=? and token=?");
            ps.setInt(1, uid);
            ps.setString(2, token);
            try {
                rs = ps.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    flag = true;
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    // 修改token
    public static boolean updateSession(int uid, String token) {
        boolean flag = false;
        Connection conn = DbUtil.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("update session set token=? where uid=?");
            ps.setString(1, token);
            ps.setInt(2, uid);
            try {
                if (ps.executeUpdate() > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return flag;
        }

    }

    // 用户注册或登录时添加token
    public static boolean addNewSession(int uid, String token) {
        boolean flag = false;
        Connection conn = DbUtil.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("insert into session(uid, token) values(?,?)");
            ps.setInt(1, uid);
            ps.setString(2, token);
            try {
                if (ps.executeUpdate() > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    // 用户logout时删除token
    public static boolean deleteSession(int uid) {
        boolean flag = false;
        Connection conn = DbUtil.getConnection();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("delete from session where uid=?");
            ps.setInt(1, uid);
            try {
                if (ps.executeUpdate() > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn.commit();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    public static void main(String[] args) throws Exception {
        EncodeUtil encodeUtil = new EncodeUtil();
        for (int i = 100001; i < 100010; i++) {
            int uid = i;
            String token = encodeUtil.encrypt(String.valueOf(uid));
            boolean flag = isSessionExist(uid, token);
            if (!flag) {
                addNewSession(uid, token);
            } else {
                deleteSession(uid);
            }
        }
    }
}

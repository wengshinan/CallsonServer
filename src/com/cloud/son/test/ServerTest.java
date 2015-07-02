package com.cloud.son.test;

import com.cloud.son.server.HttpUtil;
import com.cloud.son.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ServerTest serverTest = new ServerTest();
		serverTest.socketServerTest();
		//serverTest.databaseTest();


	}

	private void databaseTest() {
		try {
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from user");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println("  " + rs.getString(3));
				System.out.println("  " + rs.getString(4));
				System.out.println("  " + rs.getString(5));
				System.out.println("  " + rs.getString(6));
				System.out.println("  " + rs.getString(7));
				System.out.println("  " + rs.getString(9));
			}
			rs.close();
			stmt.close();
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	private void socketServerTest() {

		/*
		Socket server = null;
		try {
			server = new Socket("127.0.0.1", 8889);
			DataInputStream input = new DataInputStream(server.getInputStream());

			DataOutputStream out = new DataOutputStream(server
					.getOutputStream());

			// 发送
			String sendLine = new String("1111");

			out.writeUTF(sendLine);
			out.writeUTF("end");
			// 接收返回
			String line = input.readUTF();
			while (line != null) {
				System.out.println(line);
				line = input.readUTF();
			}
			out.close();
			input.close();

		} catch (Exception e) {
			System.out.println("客户端异常:" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (server != null) {
				try {
					server.close();
				} catch (IOException e) {
					server = null;
					System.out.println("客户端 finally 异常:" + e.getMessage());
				}
			}

		}
		*/
		HttpUtil userUtil = new HttpUtil();
	}

}

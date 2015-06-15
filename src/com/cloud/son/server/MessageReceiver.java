/**
 * 
 */
package com.cloud.son.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������
 * 
 * @author fjfh-wengsn
 * 
 */
public class MessageReceiver extends Thread {

	private Socket client;

	public MessageReceiver(Socket client) {
		this.client = client;
	}

	public final void run() {

		if (client != null) {

			String recvData = receiveData(client);
			
			ServiceMatcher matcher = new ServiceMatcher(recvData);
			
			try {
				matcher.findObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * ���ɷ����ַ���
	 * 
	 * @param client2
	 * @return
	 */
	private String receiveData(Socket client2) {
		return null;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int port = 8889;
		ServerSocket server = new ServerSocket(port);
		while (true) {
			Socket client = server.accept();

			MessageReceiver rcvr = new MessageReceiver(client);
			rcvr.start();
		}
	}

}

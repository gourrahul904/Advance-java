package in.co.rays.networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloTCPClient {
	public static void main(String[] args) throws Exception {

		Socket client = new Socket("localhost", 1234);

		DataInputStream in = new DataInputStream(client.getInputStream());

		DataOutputStream out = new DataOutputStream(client.getOutputStream());

		out.writeBytes("Hello server");

		String greeting = in.readLine();
		
		System.out.println(greeting);
		
		client.close();

	}

}

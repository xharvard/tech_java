package core2.p4;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * 
 * 连接到time-a.nist.gov的端口13 获取当日时间
 * @author xharvard
 *
 */
public class Socket_01 {

	public static void main(String[] args) throws IOException {
		try(Socket socket = new Socket("time-a.nist.gov", 13);
				Scanner in = new Scanner(socket.getInputStream(), "UTF-8")){
			while (in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
		}
	}

}

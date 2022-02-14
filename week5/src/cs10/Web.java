package cs10;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Web {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("URL ");
        String url = scanner.next();
        getHostIPAddress(url);
    }

    public void getHostIPAddress(String url) {
        String ipAddress = null;
        try {
            ipAddress = InetAddress.getByName(url).getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("TCP Connection : " + ipAddress);
        openSocket(ipAddress);
    }
    public void openSocket(String ipAddress) {
        try {
            Socket socket = new Socket(ipAddress, 80);
            String requestMessage = createRequest();
            requestServerTransfer(socket, requestMessage);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private String createRequest() {
        String requestLine = "GET /Main/default.aspx HTTP/1.1";
        String header =
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8" + "\n"
                        + "Upgrade-Insecure-Requests: 1" + "\n"
                        + "Host: www.yes24.com" + "\n"
                        + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/15.2 Safari/605.1.15" + "\n"
                        + "Accept-Language: ko-KR,ko;q=0.9" + "\n"
                        + "Accept-Encoding: gzip, deflate" + "\n"
                        + "Connection: keep-alive";

        String messageBody = null;
        MyRequest myRequest = new MyRequest(requestLine, header);
        String request = myRequest.getRequestMessage();
        return request;
    }

    private void requestServerTransfer(Socket socket, String requestMessage) {
        try {
            PrintWriter request = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(new InputStreamReader(socket.getInputStream()));
            System.out.println(requestMessage);
            request.println(requestMessage);
            request.flush();
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

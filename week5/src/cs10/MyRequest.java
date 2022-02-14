package cs10;

public class MyRequest {
    private final String requestLine;
    private final String header;

    public MyRequest(String requestLine, String header) {
        this.requestLine = requestLine;
        this.header = header;
    }

    public String getRequestMessage() {
        return requestLine + "\n" + header + "\n" + "";
    }
}
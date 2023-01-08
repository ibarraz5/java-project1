package HttpServer;


import java.io.*;
import java.net.*;

import Assignment3Starter.ClientGui;

import java.io.IOException;



class WebServer {
  public static void main(String args[]) {
    WebServer server = new WebServer(9000);
    try {
        ClientGui.main(args);

    } catch (IOException e) {
        System.out.print("IO Exception caught!");
    }
  }

 
  public WebServer(int port) {
    ServerSocket server = null;
    Socket sock = null;
    InputStream in = null;
    OutputStream out = null;

    try {
      server = new ServerSocket(port);
      while (true) {
        sock = server.accept();
        out = sock.getOutputStream();
        in = sock.getInputStream();
        out.flush();
        in.close();
        out.close();
        sock.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (sock != null) {
        try {
          server.close();
        } catch (NullPointerException | IOException e) {
          System.out.println("NullPointerException thrown!"); 
          e.printStackTrace();
        }
      }
    }
  }

}

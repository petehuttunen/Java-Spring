
import com.sun.jdi.InconsistentDebugInfoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HelloBrowser {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Where to? ");
        try{
            ServerSocket serverSocket = new ServerSocket(80);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("GET / HTTP/1.1");
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out.println("HOST: " +in);
            out.println();
            out.flush();
            while(in.readLine() !=null){
                System.out.println(in.readLine());
            }
        }
        catch(IOException e){
            System.out.println("Virhe " +e);
        }
       

    }
}

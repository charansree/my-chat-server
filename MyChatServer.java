import java.io.*;
import java.net.*;
public class MyChatServer
{
  public static void main(String args[])
  {
    try
	{ 
	   ServerSocket ss=new ServerSocket(8999);
	   System.out.println("Server is ready for chatting");
	   Socket s=ss.accept();
	   OutputStream os=s.getOutputStream();
	   ObjectOutputStream oos=new ObjectOutputStream(os);
	   InputStream is=s.getInputStream();
	   ObjectInputStream ois=new ObjectInputStream(is);
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   String rcv_msg,send_msg;
	   while(true)
	   {
	      if((rcv_msg=(String)ois.readObject())!=null)
		  {
		     System.out.println("From client:"+rcv_msg);
		  }
		  System.out.println("To client:");
		  send_msg=br.readLine();
		  oos.writeObject(send_msg);
	   }
	}
	catch(Exception e)
	{
	   System.out.println(e);
	}
  }
}
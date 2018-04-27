import java.net.*;
import java.io.*;
public class MyChatClient
{
	public static void main(String args[])
	{
		try
		{
			Socket s=new Socket("localhost",8999);
			System.out.println("connected to the server");
			InputStream is=s.getInputStream();
			ObjectInputStream ois=new ObjectInputStream(is);
			OutputStream os=s.getOutputStream();
			ObjectOutputStream oos=new ObjectOutputStream(os);
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String rcv_msg,send_msg;
			while(true)
			{
				System.out.println("To server:");
				send_msg=br.readLine();
				oos.writeObject(send_msg);
				if((rcv_msg=(String)ois.readObject())!=null)
				{
					System.out.println("from client:");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
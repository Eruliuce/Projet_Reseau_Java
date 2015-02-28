package controleurs;

import java.io.*;
import java.net.*;

public class ControleurReseau extends Thread
{
	Socket socket;
    InputStream in;
	OutputStream output;
	DataOutputStream dataOut;
	float x, y;
	boolean none;
			
	public ControleurReseau()
	{
		try {
			socket = new Socket("127.0.0.1",10666);
		    in = socket.getInputStream();
			output = socket.getOutputStream();
			dataOut = new DataOutputStream (output);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x = 0;
		y = 0;
		none = true;
		start();
	}
	
	public void emit(float x, float y)
	{
		try {
			dataOut.writeBytes(x + ":" + y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run()
	{
		BufferedReader bufferReader;
		try {
			bufferReader = new BufferedReader(new InputStreamReader(in));
			String ligne = bufferReader.readLine();
			if(!ligne.equals("none"))
			{
				System.out.println("test");
				float x = Float.parseFloat(ligne.substring(0, ligne.indexOf(':') - 1));
				float y = Float.parseFloat(ligne.substring(0, ligne.indexOf(':') + 1));
				none = false;
			}
			else
				none = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void emit(String string)
	{
		try {
			dataOut.writeBytes(string);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean getNone() {return none;}
	public float getX() {return x;}
	public float getY() {return y;}
}

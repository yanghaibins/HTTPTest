package com.hand.TestHTTPPost;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;

public class TestPost {

	public static void main(String[] args) {
		new ReadPost().start();
	}

}
class ReadPost extends Thread{
	
	@Override
	public void run() {
		try {
			
			URL url = new URL("http://fanyi.youdao.com/openapi.do");
			HttpURLConnection connection =(HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			
			
			OutputStream os = connection.getOutputStream();
			OutputStreamWriter osw =new OutputStreamWriter(os);
			BufferedWriter bw =new BufferedWriter(osw);
 			
			bw.write("keyfrom=yanghaibin&key=1191691896&type=data&doctype=xml&version=1.1&q=apple");
			bw.flush();
			
			InputStream is =connection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			String line;
			StringBuilder b= new StringBuilder();
			while ((line = 	br.readLine())!=null) {
				b.append(line);
			}
			bw.close();
			osw.close();
			os.close();
			br.close();
			isr.close();
			isr.close();
			
			System.out.println(b.toString());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

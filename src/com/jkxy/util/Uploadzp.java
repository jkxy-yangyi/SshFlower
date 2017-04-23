package com.jkxy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Uploadzp {
public void upload(File file,String path){
	InputStream is;
	try {
		is = new FileInputStream(file);
		OutputStream os=new FileOutputStream(path);
		  byte buffer[]=new byte[1024];
		  int count=0;
		  //is.read(buffer) 重缓冲区读到的真实数据
		  while((count=is.read(buffer))>0)
		  {
			  //重0开始到count写到缓冲区
			  os.write(buffer, 0, count);
		  }
		  os.close();
		  is.close();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}

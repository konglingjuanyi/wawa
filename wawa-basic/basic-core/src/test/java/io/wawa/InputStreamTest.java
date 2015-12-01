package io.wawa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {
	public static void main(String[] args) throws IOException {
		String fileName = "D:\\mAC.sql";
		InputStream inputStream = new FileInputStream("D:\\mAC.sql");
		byte[] readData = new byte[(int) fileName.length()];
		inputStream.read(readData);
		System.out.println("文件长度为:" + fileName.length());
		System.out.println(new String(readData));
		inputStream.close();
	}
}

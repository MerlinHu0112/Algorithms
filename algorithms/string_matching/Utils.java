package algorithms.string_matching;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import org.junit.Test;
/**
 * 工具类，用于随机生成字符串
 * @author Merlin
 * @date
 */
@SuppressWarnings("all")
public class Utils {
	
	// 随机生成指定长度的字符串。
	// 仅考虑26个小写字母
	private static String generateString(int length) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<length; ++i) {
			int num = random.nextInt(26) + 97;
			sb.append(String.valueOf((char)num));
		}
		return sb.toString();
	}
	
	// 将随机生成的字符串写入本地磁盘
	// 本方法仅须在初始化时被执行一次
	@Test
	public void writeString() throws IOException {
		// 随机生成主串
		String string = generateString(100000000);
		OutputStream output = new FileOutputStream("D:\\Files\\Programming Files\\RandomString.txt");
		PrintWriter pw = new PrintWriter(output);
		pw.print(string);
		pw.close();
		output.close();
	}
	
	// 读取writeString方法写入的本地字符串文件，并返回该字符串
	public static String readString() {
	    File file = new File("D:\\Files\\Programming Files\\RandomString.txt");
	    BufferedReader reader = null;
	    StringBuffer sbf = new StringBuffer();
	    try {
	        reader = new BufferedReader(new FileReader(file));
	        String tempStr;
	        while ((tempStr = reader.readLine()) != null) {
	            sbf.append(tempStr);
	        }
	        reader.close();
	        return sbf.toString();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        if (reader != null) {
	            try {
	                reader.close();
	            } catch (IOException e1) {
	                e1.printStackTrace();
	            }
	        }
	    }
	    return sbf.toString();
	}
	
	// 打印字符串
	public static void print(String str) {
		int lineCount = 0;
		for(int i=0; i<str.length(); ++i) {
			if((lineCount/50)!=0) {
				System.out.println();
				lineCount = 0;
			}
			System.out.print(str.charAt(i)+" ");
			lineCount++;
		}
		System.out.println();
		System.out.println("****************************");
	}
}

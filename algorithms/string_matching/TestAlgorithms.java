package algorithms.string_matching;
import java.io.IOException;
import org.junit.Test;
/**
 * 测试并比较各种字符串匹配算法
 * @author Merlin
 * @date 2020-03-03
 */
@SuppressWarnings("all")
public class TestAlgorithms {
	
	// 验证字符串匹配算法的有效性
	@Test
	public void testValidity() {
		// 主串
		String string = Utils.readString();
		// 模式串，其中"gcuyac"与主串最后6个字符匹配，正确结果因为99999994；
		// "gcuyad"与主串不匹配
		String pattern = "gcuyac";
		//String pattern = "gcuyad";
		//int result = BF.bruteForce(string, pattern);
		//int result = RK.robinKarp(string, pattern);
		int result = RK.improvedRobinKarp(string, pattern);
		if(result!=-1) {
			System.out.println("模式串在主串中首次出现位置为："+result);
		}else {
			System.out.println("无匹配");
		}
	}
	
	// 测试字符串匹配算法的性能
	@Test
	public void testPerformance() {
		// 主串
		String string = Utils.readString();
		// 模式串
		String pattern = "gcuyac";
		int loop = 50; // 重复次数
		long startTime = System.currentTimeMillis();
		while(loop > 0) {
			//BF.bruteForce(string, pattern);
			//RK.robinKarp(string, pattern);
			RK.improvedRobinKarp(string, pattern);
			loop--;
		}
		long endTime = System.currentTimeMillis();
		System.out.println("匹配算法重复运行50次，总耗时："+(endTime-startTime)+"毫秒");
	}
}

package MockitoTest;

import java.util.Arrays;

import org.junit.Test;

public class TimeOutTestMockito {

	@Test(timeout = 100)
	public void test() {
		int array[] = { 92, 13, 94 };
		for (int i = 0; i <= 100000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}
	}
}

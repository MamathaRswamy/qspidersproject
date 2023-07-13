package generics;

import java.util.Random;

public class JavaUtility {
public int generatingRandomNumbers(int range) {
	Random random=new Random();
	return random.nextInt(range);
}
}

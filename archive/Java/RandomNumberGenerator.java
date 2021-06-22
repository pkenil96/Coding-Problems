package syntax;

import java.util.Random;

public class RandomNumberGenerator{

	int range;
	public RandomNumberGenerator(int range){
		this.range = range;
	}

	public int random(){
		Random rd = new Random();
		return rd.nextInt(range);
	}
}
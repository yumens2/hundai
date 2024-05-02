package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallMakerTest {

	BaseBallMaker baseBallMaker = new BaseBallMaker();



	@DisplayName("getRandomValue")
	@RepeatedTest(value = 100)
	void getRandomValue () {
		//given
		int num;

		//when
		num = baseBallMaker.getRandomValue();

		//then
		assertTrue(num>=1);
		assertTrue(num<10);
	}
}
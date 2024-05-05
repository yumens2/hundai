package common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import vo.BaseBallAnsVO;
import vo.BaseBallVO;

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

	@Test
	void playBall() {
		//given
		BaseBallVO vo = new BaseBallVO(3,1,4);

		//when
		BaseBallAnsVO ansVO = baseBallMaker.playBall(vo);

		//then
		assertNotNull(ansVO,ansVO.toString());
	}
}
package vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallVOTest {

	BaseBallVO vo;
	BaseBallVO compareVO;

	@Test
	@DisplayName("reset")
	void reset () {
		//given
		vo = new BaseBallVO(1,2,3);

		int changeBall1 = 5;
		int changeBall2 = 6;
		int changeBall3 = 7;
		//when
		vo.reset(changeBall1,changeBall2,changeBall3);

		//then

		assertEquals(changeBall1,vo.getBall1());
		assertEquals(changeBall2,vo.getBall2());
		assertEquals(changeBall3,vo.getBall3());
	}

	@Test
	@DisplayName("equal")
	void testEquals () {

		//given
		int ball1 = 1;
		int ball2 = 2;
		int ball3 = 3;

		//when
		vo = new BaseBallVO(ball1,ball2,ball3);
		compareVO = new BaseBallVO(ball1,ball2,ball3);

		//then

		assertEquals(vo,compareVO);
	}
}
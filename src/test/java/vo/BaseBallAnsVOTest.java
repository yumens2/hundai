package vo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseBallAnsVOTest {

	BaseBallAnsVO ansVO;

	@Test
	void testToString () {
		//given
		boolean isEnd = false;
		int ballCount = 2;
		int ballCountZero = 0;
		int StrikeCount = 1;
		int StrikeCountZero = 0;

		//then

		ansVO = new BaseBallAnsVO(isEnd,StrikeCount,ballCount);
		String ansVO1 = "2볼 1스트라이크";

		assertEquals(ansVO1,ansVO.toString());


	}
}
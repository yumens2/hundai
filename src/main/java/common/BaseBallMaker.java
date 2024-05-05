package common;

import vo.BaseBallAnsVO;
import vo.BaseBallVO;

import java.util.*;


public class BaseBallMaker {

	private final BaseBallVO randVO;
	private final Random random;

	public BaseBallMaker(){
		random = new Random();
		randVO = new BaseBallVO(0,0,0);
		make(); //객체 생성 시 make 하지 않고 쓸 수 있으므로 약간의 overhead를 가지고 사용
	}


	/**
	 * Ball의 값을 랜덤한 값으로 설정
	 */
	public void make(){
		int ball1 = getRandomValue();
		int ball2 = getRandomValue(ball1);
		int ball3 = getRandomValue(ball1,ball2);

		randVO.reset(ball1,ball2,ball3);
	}

	/**
	 * 랜덤한 값을 생성한다.
	 * @return 1<=return<=9
	 */
	protected int getRandomValue(){
		return random.nextInt(1,10);
	}

	/**
	 * nums의 수를 제외한 랜덤한 값을 생성한다.
	 * @param nums 제외할 수
	 * @return 1<=return<=9
	 */
	protected int getRandomValue(final int...nums){
		int returnValue;
		boolean flag;
		do{
			returnValue = random.nextInt(1,10);
			flag = findMatchNum(returnValue,nums);
		}while(flag);

		return returnValue;

	}

	/**
	 * 야구게임을 진행합니다.
	 * @param vo 사용자가 추측한 야구게임 value
	 * @return 야구게임 진행결과
	 */
	public BaseBallAnsVO playBall(final BaseBallVO vo){

		vertifyVo(vo);

		boolean isEnd = calEnd(vo);
		int ballCount = calBallCount(vo);
		int strikeCount = calStrikeCount(vo);
		return new BaseBallAnsVO(isEnd,strikeCount,ballCount);
	}

	private boolean calEnd(final BaseBallVO vo){
		return this.randVO.equals(vo);
	}

	private int calBallCount(final BaseBallVO vo){
		int returnValue = 0;
		if(findMatchNum(vo.getBall1(),randVO.getBall2(),randVO.getBall3())){
			returnValue++;
		}
		if(findMatchNum(vo.getBall2(),randVO.getBall1(),randVO.getBall3())){
			returnValue++;
		}
		if(findMatchNum(vo.getBall3(),randVO.getBall1(),randVO.getBall2())){
			returnValue++;
		}
		return returnValue;
	}

	private int calStrikeCount(final BaseBallVO vo){
		int returnValue = 0;
		if(vo.getBall1() == randVO.getBall1()){
			returnValue++;
		}
		if(vo.getBall2() == randVO.getBall2()){
			returnValue++;
		}
		if(vo.getBall3() == randVO.getBall3()){
			returnValue++;
		}
		return returnValue;
	}

	/**
	 * 포함된 숫자를 찾아준다.
	 * @param inputNum 넣을 값
	 * @param nums 찾을 숫자들
	 * @return 찾을 경우 true
	 */
	private boolean findMatchNum(final int inputNum,final int ...nums){
		for(int num : nums){
			if(inputNum == num){
				return true;
			}
		}
		return false;
	}

	private void vertifyVo(final BaseBallVO vo){
		if(findMatchNum(vo.getBall1(), vo.getBall2(),vo.getBall3())){
			throw new IllegalArgumentException("user Input except");
		}
		if(findMatchNum(vo.getBall2(), vo.getBall1(),vo.getBall3())){
			throw new IllegalArgumentException("user Input except");
		}
		if(findMatchNum(vo.getBall3(), vo.getBall2(),vo.getBall1())){
			throw new IllegalArgumentException("user Input except");
		}

	}
}

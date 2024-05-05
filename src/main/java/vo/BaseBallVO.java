package vo;

public class BaseBallVO {
	private int ball1;
	private int ball2;
	private int ball3;

	public BaseBallVO(final int ball1,final int ball2,final int ball3){
		reset(ball1,ball2,ball3);
	}

	public int getBall1 () {
		return ball1;
	}

	public int getBall2 () {
		return ball2;
	}

	public int getBall3 () {
		return ball3;
	}

	/**
	 * 볼 정보를 재설정한다.
	 * @param ball1 : 첫번째 숫자
	 * @param ball2 : 두번째 숫자
	 * @param ball3 : 세번째 숫자
	 */
	public void reset(final int ball1,final int ball2,final int ball3){
		this.ball1 = ball1;
		this.ball2 = ball2;
		this.ball3 = ball3;
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BaseBallVO that = (BaseBallVO) o;

		if (ball1 != that.ball1) return false;
		if (ball2 != that.ball2) return false;
		return ball3 == that.ball3;
	}

	@Override
	public int hashCode () {
		int result = ball1;
		result = 31 * result + ball2;
		result = 31 * result + ball3;
		return result;
	}
}

package vo;

public class BaseBallAnsVO {
	private boolean isEnd;
	private int strikeCount;
	private int ballCount;

	public BaseBallAnsVO (final boolean isEnd, final int strikeCount, final int ballCount) {
		reset(isEnd,strikeCount,ballCount);
	}

	public void reset (final boolean isEnd,final int strikeCount, final int ballCount){
		this.isEnd = isEnd;
		this.strikeCount = strikeCount;
		this.ballCount = ballCount;
	}

	public boolean isEnd () {
		return isEnd;
	}
	@Override
	public String toString () {
		StringBuilder sd = new StringBuilder();
		if(ballCount>0){
			sd.append(ballCount).append("볼");
		}
		if(!sd.isEmpty()){
			sd.append(" ");
		}
		if(strikeCount>0){
			sd.append(strikeCount).append("스트라이크");
		}
		return sd.toString();
	}
}

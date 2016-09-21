public class Frame {
	private int firstThrow;
	private int secondThrow;
	
	public Frame(int firstThrow, int secondThrow){
		this.firstThrow = firstThrow;
		this.secondThrow = secondThrow;
	}
	
	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	//returns the score of a single frame
	public int score(){
		return this.firstThrow + this.secondThrow;
	}

	//returns whether the frame is a strike or not
	public boolean isStrike(){
		return this.firstThrow == 10;
	}
	
	//return whether a frame is a spare or not
	public boolean isSpare(){
		return ((this.getFirstThrow() != 10) && (this.score() == 10));		
	}
	
	public void modifyFrame(int first, int second) {
		this.firstThrow = first;
		this.secondThrow = second;
	}
}

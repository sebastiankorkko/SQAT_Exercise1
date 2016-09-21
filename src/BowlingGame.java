import java.util.ArrayList;
import java.util.List;

//Finish time:
//ID:

public class BowlingGame {
	//a bowling game is made of (at least) 10 frames
	private List<Frame> frames = new ArrayList<Frame>();
	private Frame bonus;
	
	public BowlingGame(){}
	
	// adds a frame to the game
	public void addFrame(Frame frame) throws BowlingException{
		if(frames.size() < 10) {
			frames.add(frame);
		} else {
			throw new BowlingException("Game already has 10 frames");
		}
	}
	
	// Sets the bonus throws at the end of the game
	public void setBonus(int firstThrow, int secondThrow) {
		//to be implemented
	}
	
	// Returns the game score
	public int score(){
		int score = 0;
		for(int i = 0; i < 10; i++)
			if(frames.get(i).getFirstThrow() != 10) {
				score = score + frames.get(i).score();
			} else {
				if(frames.get(i).getFirstThrow() != 10) {
					score = score + frames.get(i).score() + frames.get(i+1).getFirstThrow();
				} else {
					score = score + frames.get(i).score() + frames.get(i+1).score();
				}
			}
		return score;
	}
	
	public List<Frame> getFrames() {
		return this.frames;
	}
}

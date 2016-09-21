import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void addFrame_5_5() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,5));
		int first = game.getFrames().get(0).getFirstThrow();
		int second = game.getFrames().get(0).getSecondThrow();
		assertEquals("10", first + second, 10);
	}
	
	@Test
	public void calculateScoreOfAFrame_3_3() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(3,3));
		int score = game.getFrames().get(0).score();
		assertEquals("6", score, 6);
	}
	
	@Test
	public void addTenFrames(){
		BowlingGame game = new BowlingGame();
		for(int i = 0; i < 10; i++) {
			game.addFrame(new Frame(3,3));
		}
		int first = game.getFrames().get(0).score();
		int last = game.getFrames().get(9).score();
		assertEquals("12", first + last, 12);	
	}

}

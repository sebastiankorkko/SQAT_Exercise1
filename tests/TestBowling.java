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

}

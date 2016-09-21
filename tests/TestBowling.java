import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestBowling {
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void addFrame_5_5() {
		BowlingGame game = new BowlingGame();
		try {
			game.addFrame(new Frame(5,5));
		} catch (BowlingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int first = game.getFrames().get(0).getFirstThrow();
		int second = game.getFrames().get(0).getSecondThrow();
		assertEquals("10", first + second, 10);
	}
	
	@Test
	public void calculateScoreOfAFrame_3_3() {
		BowlingGame game = new BowlingGame();
		try {
			game.addFrame(new Frame(3,3));
		} catch (BowlingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int score = game.getFrames().get(0).score();
		assertEquals("6", score, 6);
	}
	
	@Test
	public void addTenFrames(){
		BowlingGame game = new BowlingGame();
		for(int i = 0; i < 10; i++) {
			try {
				game.addFrame(new Frame(3,3));
			} catch (BowlingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int first = game.getFrames().get(0).score();
		int last = game.getFrames().get(9).score();
		assertEquals("12", first + last, 12);	
	}
	
	@Test
	public void addElevenFrames() throws Exception {
		expectedEx.expect(BowlingException.class);
		expectedEx.expectMessage("Game already has 10 frames");
		BowlingGame game = new BowlingGame();
		for(int i = 0; i < 11; i++) {
			game.addFrame(new Frame(3,3));
		}
	}


}

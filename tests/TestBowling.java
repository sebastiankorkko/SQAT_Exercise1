import static org.junit.Assert.*;

import org.junit.Test;

public class TestBowling {

	@Test
	public void addFrame_5_5() {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,5));
		int first = game.returnFrame().get(0).getFirstThrow();
		int second = game.returnFrame().get(0).getSecondThrow();
		assertEquals("10", first + second, 10);
		
	}

}

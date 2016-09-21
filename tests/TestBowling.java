import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestBowling {
	
	private static BowlingGame game;
	
	@BeforeClass
	public static void initGame() throws BowlingException {
		game = new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(3,6));
		game.addFrame(new Frame(4,4));
		game.addFrame(new Frame(5,3));
		game.addFrame(new Frame(3,3));
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(8,1));
		game.addFrame(new Frame(2,6));
	}
	
	
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
	public void addElevenFramesThrowError() throws Exception {
		expectedEx.expect(BowlingException.class);
		expectedEx.expectMessage("Game already has 10 frames");
		BowlingGame game = new BowlingGame();
		for(int i = 0; i < 11; i++) {
			game.addFrame(new Frame(3,3));
		}
	}
	
	@Test
	public void CheckGameScore() throws BowlingException {
		initGame();
		assertEquals("81", game.score(), 81);
	}
	
	@Test
	public void checkIfStrike() throws BowlingException {
		initGame();
		game.getFrames().get(0).modifyFrame(10, 0);
		assertEquals("True", game.getFrames().get(0).isStrike(), true);		
	}
	
	@Test
	public void checkIfStrikeCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(0).modifyFrame(10, 0);
		assertEquals("94", game.score(), 94);		
	}
	
	@Test
	public void checkIfSpareCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(0).modifyFrame(1, 9);
		assertEquals("88", game.score(), 88);		
	}
	
	@Test
	public void checkIfSpare() throws BowlingException {
		initGame();
		game.getFrames().get(0).modifyFrame(1, 9);
		assertEquals("True", game.getFrames().get(0).isSpare(), true);		
	}
	
	@Test
	public void checkIfStrikeSpareCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(0).modifyFrame(10, 0);
		game.getFrames().get(1).modifyFrame(4, 6);
		assertEquals("102", game.score(), 103);		
	}
	
	@Test
	public void checkIfStrikeStrikeCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(0).modifyFrame(10, 0);
		game.getFrames().get(1).modifyFrame(10, 0);
		assertEquals("112", game.score(), 112);		
	}
	
	public void checkIfSpareSpareCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(0).modifyFrame(8, 2);
		game.getFrames().get(1).modifyFrame(5, 5);
		assertEquals("98", game.score(), 98);		
	}
	
	public void checkIfLastSpareBonusCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(9).modifyFrame(2, 8);
		game.setBonus(7, 0);
		assertEquals("90", game.score(), 90);		
	}
	
	public void checkIfLastStrikeBonusCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(9).modifyFrame(10, 0);
		game.setBonus(7, 2);
		assertEquals("92", game.score(), 92);		
	}
	
	public void checkIfLastSpareBonusStrikeCalculatesCorrectly() throws BowlingException {
		initGame();
		game.getFrames().get(9).modifyFrame(2, 8);
		game.setBonus(10, 0);
		assertEquals("93", game.score(), 93);		
	}
	
	public void checkPerfectScore_300() throws BowlingException {
		initGame();
		for(int i = 0; i < 10; i++) {
			game.getFrames().get(i).modifyFrame(10, 0);
		}
		game.setBonus(10, 0);
		assertEquals("300", game.score(), 300);
	}
	


}

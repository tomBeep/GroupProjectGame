package map.tests;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import map.BadMapImageException;
import map.ParseException;
import map.World;
import map.parsers.WorldParser;
import player.Player;

public class WorldParserTests {

	@Test
	public void testCorrectWorld() {
		Player p1 = new Player("Tom", 50, 50);
		World w = WorldParser.parse("world", p1);
		p1.setMap(w.getStartingMap());
		assertTrue(w != null);
	}

	@Test
	public void incorrectmapPathways() {
		Player p1 = new Player("Tom", 50, 50);
		World w = WorldParser.parse("vfbsf", p1);
		assertTrue(w == null);
	}
	
	@Test
	public void correctMapsAreLoaded() {
		Player p1 = new Player("Tom", 50, 50);
		World w = WorldParser.parse("world", p1);
		p1.setMap(w.getStartingMap());
		assert(12==w.getMaps().size());
	}

}

package map;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

import common.player.IPlayer;

/**
 * This class is responsible for reading a text file that contains the world of
 * the game. This includes reading various map names. This class can be
 * considered a World factory and thus has no referenceable constructor and a
 * parser method that can be accessed from anywhere.
 *
 * @author James
 *
 */
public class WorldParser {

	private WorldParser() {

	}

	/**
	 * This method reads a world text file and returns a new world.
	 *
	 * @throws ParseException
	 * @throws IOException
	 * @throws BadMapImageException
	 */
	public static World parse(String worldFileName, IPlayer current) {
		HashMap<String, Map> maps = new HashMap<String, Map>();
		InputStream in = null;
		String fileLocation = "assets/" + worldFileName;
		Scanner scan = null;

		try {
			in = WorldParser.class.getResourceAsStream(fileLocation);
			if (in == null) {
				throw new ParseException("The world file " + fileLocation + " does not exist");

			}
			scan = new Scanner(in);
			if (!scan.hasNext()) {
				throw new ParseException("World file is blank 	");
			}
			while (scan.hasNext()) {
				String map = scan.next();
				maps.put(map, MapParser.parse(map, current));
			}

			World w = new World(maps);
			current.setMap(w.getStartingMap());
			return w;
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {

			if (scan != null) {
				scan.close();
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return null;
	}

}

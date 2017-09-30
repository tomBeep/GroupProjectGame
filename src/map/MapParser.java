package map;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import items.DoorItem;
import items.Item;
import npc.NPC;
import player.Player;

/**
 * This class is responsible for reading a text file that contains all the
 * information for a single map. This includes reading various items. This class
 * can be considered a Map factory and thus has no referenceable constructor and
 * a parser method that can be accessed from anywhere.
 *
 * @author James
 *
 */
public class MapParser {

	private MapParser() {

	}

	/**
	 * This method reads a map text file and returns a new map
	 *
	 * @throws ParseException
	 * @throws IOException
	 * @throws BadMapImageException
	 */
	public static Map parse(String mapFileName, Player current) {
		String fileLocation = "assets/entities/" + mapFileName;
		InputStream in = null;
		Scanner scan = null;
		String mapName = mapFileName;
		List<Item> itms = new ArrayList<Item>();
		ArrayList<NPC> npcs = new ArrayList<NPC>();
		List<DoorItem> doors = new ArrayList<DoorItem>();

		try {
			in = MapParser.class.getResourceAsStream(fileLocation);
			if (in == null) {
				throw new ParseException("The file " + fileLocation + " does not exist");
			}
			scan = new Scanner(in);
			if (!scan.hasNext()) {
				throw new ParseException("World file is blank 	");
			}

			while (scan.hasNext()) {
				String line = scan.next();
				if (line.equals("HealthPot")) {
					new HealthPotion().parse(scan, itms);
				} else if (line.equals("MassiveGun")) {
					new MassiveG().parse(scan, itms);
				} else if (line.equals("RustyArmor")) {
					new RustyArm().parse(scan, itms);
				} else if (line.equals("ShinyArmor")) {
					new ShinyArm().parse(scan, itms);
				} else if (line.equals("NPC")) {
					new ParseNPC().parse(scan, npcs, current);
				} else if (line.equals("Door")) {
					new Door().parse(scan, doors);
				} else {
					throw new ParseException("Invalid text file");
				}

			}

			Map n = new Map(mapName, current, itms, npcs, doors);
			return n;
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

	public static String require(String token, Scanner scan) throws ParseException {
		if (scan.hasNext(token)) {
			return scan.next();
		} else {
			throw new ParseException("Was expecting the token " + token + "but instead received " + scan.next());
		}
	}

	public static Integer requireInteger(Scanner scan) throws ParseException {
		if (scan.hasNextInt()) {
			return scan.nextInt();
		} else {
			throw new ParseException("Was expecting a integer but instead got " + scan.next());
		}
	}

	public static String requireString(Scanner scan) throws ParseException {
		if (scan.hasNext()) {
			return scan.next();
		} else {
			throw new ParseException("Was expecting a integer but instead got " + scan.next());
		}
	}

	public static void requireSomething(Scanner scan) throws ParseException {
		if (!scan.hasNext()) {
			throw new ParseException("Was expecting another token but there was none");
		}
	}
}

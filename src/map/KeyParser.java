package map;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import common.items.Item;
import items.Key;

public class KeyParser implements Serializable {
	public KeyParser() {

	}

	public void parse(Scanner scan, List<Item> items) throws ParseException {
		int id = MapParser.requireInteger(scan);
		int x = MapParser.requireInteger(scan);
		int y = MapParser.requireInteger(scan);

		Item key = new Key(id);
		key.setX(x * Map.tileSize);
		key.setY(y * Map.tileSize);
		items.add(key);
	}
}

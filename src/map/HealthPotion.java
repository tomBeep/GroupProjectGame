package map;

import java.awt.Point;
import java.util.HashMap;
import java.util.Scanner;

import items.Item;
import items.itemList.HealthPot;

public class HealthPotion {
	public HealthPotion() {

	}

	public void parse(Scanner scan, HashMap<Item, Point> items) {
		Item hp = new HealthPot();
		int x = scan.nextInt();
		int y = scan.nextInt();
		Point hpLoc = new Point(x, y);
		items.put(hp, hpLoc);
	}
}

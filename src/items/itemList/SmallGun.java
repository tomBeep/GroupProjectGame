package items.itemList;

import items.AbstractItem;
import items.Equipable;
import player.Player;

/**
 * @author Thomas Edwards
 */
public class SmallGun extends AbstractItem implements Equipable {

	public SmallGun() {
		super("Small Gun", "A small gun that increases your fireRate by 10%", "smallGun");
	}

	@Override
	public void provideBonus(Player p) {
		p.setFireRate(p.getFireRate() * 0.8);
	}

	@Override
	public void removeBonus(Player p) {
		p.setFireRate(p.getFireRate() / 0.8);
	}

}

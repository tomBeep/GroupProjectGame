package items;

public class HealthPot extends AbstractItem implements Usable {

	public HealthPot() {
		super("Health Pot", "A potion of health which immedietly restores x amount of health to the player", null);
	}

	@Override
	public void use() throws InvalidBackpackException {
		// TODO Auto-generated method stub

	}

}

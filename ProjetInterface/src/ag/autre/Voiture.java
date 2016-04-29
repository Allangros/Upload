package ag.autre;

public class Voiture {
	private float reservoir;
	private float qtMaxReservoir;

	public Voiture(float qtMaxReservoir) {
		this.reservoir = 0;
		this.qtMaxReservoir = qtMaxReservoir;
	}

	public void prendreEssence(EssenceInterface st) {
		reservoir = st.donnerEssenceInterface(qtMaxReservoir - reservoir);
	}

	@Override
	public String toString() {

		return getClass().getName() + " " + reservoir;
	}

}

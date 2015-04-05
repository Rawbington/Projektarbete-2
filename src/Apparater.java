public class Apparater extends Värdesaker {

	private double slitage;
	private int pris;

	public Apparater(String namn, int slitage, int pris) {
		this.slitage = slitage;
		this.namn = namn;
		this.pris = pris;
		this.värde = getVärde();
	}

	public int getVärde() {
		värde =  (int) (pris * (slitage / 10));
		return värde;
	}

	public double getSlitage() {
		return slitage;
	}

	public int getPris() {
		return pris;
	}

	public String toString() {
		return namn + "  värde: " + värde;

	}
}

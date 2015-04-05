public class Apparater extends V�rdesaker {

	private double slitage;
	private int pris;

	public Apparater(String namn, int slitage, int pris) {
		this.slitage = slitage;
		this.namn = namn;
		this.pris = pris;
		this.v�rde = getV�rde();
	}

	public int getV�rde() {
		v�rde =  (int) (pris * (slitage / 10));
		return v�rde;
	}

	public double getSlitage() {
		return slitage;
	}

	public int getPris() {
		return pris;
	}

	public String toString() {
		return namn + "  v�rde: " + v�rde;

	}
}

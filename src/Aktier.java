public class Aktier extends V�rdesaker {

	private int pris;
	private int antal;

	public Aktier(String namn, int antal, int pris) {

		this.antal = antal;
		this.namn = namn;
		this.pris = pris;
		this.v�rde = getV�rde();
	}

	public int getV�rde() {

		v�rde = pris * antal;
		return v�rde;

	}

	public int getAntal() {
		return antal;
	}

	public void rasaAktier() {
		pris = 0;
	}

	public String toString() {
		return namn + " v�rde: " + getV�rde();

	}
}

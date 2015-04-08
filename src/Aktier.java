public class Aktier extends Värdesaker {

	private int pris;
	private int antal;
	private String derpa;

	public Aktier(String namn, int antal, int pris) {

		this.antal = antal;
		this.namn = namn;
		this.pris = pris;
		this.värde = getVärde();
	}

	public int getVärde() {

		värde = pris * antal;
		return värde;

	}

	public int getAntal() {
		return antal;
	}

	public void rasaAktier() {
		pris = 0;
	}

	public String toString() {
		return namn + " värde: " + getVärde();

	}
	
	public String getDerpa()
	{
		return derpa;
	}
}

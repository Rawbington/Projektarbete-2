import java.util.ArrayList;

public class Person {

	private String namn;

	public Person(String namn) {
		this.namn = namn;

	}

	ArrayList<Värdesaker> ägodelar = new ArrayList<>();

	public String getNamn() {
		return namn;

	}

	public void läggTillVärdesaker(Värdesaker i) {
		ägodelar.add(i);

	}

	public String toString() {
		return namn;

	}

	public int getPersonVärde() {
		int summa = 0;
		for (Värdesaker v : ägodelar) {
			summa += v.getVärde();
		}
		return summa;
	}

	public void börskrasch() {
		for (Värdesaker p : ägodelar) {
			if (p instanceof Aktier)
				((Aktier) p).rasaAktier();
		}
	}

}

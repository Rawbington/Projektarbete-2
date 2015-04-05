import java.util.ArrayList;

public class Person {

	private String namn;

	public Person(String namn) {
		this.namn = namn;

	}

	ArrayList<V�rdesaker> �godelar = new ArrayList<>();

	public String getNamn() {
		return namn;

	}

	public void l�ggTillV�rdesaker(V�rdesaker i) {
		�godelar.add(i);

	}

	public String toString() {
		return namn;

	}

	public int getPersonV�rde() {
		int summa = 0;
		for (V�rdesaker v : �godelar) {
			summa += v.getV�rde();
		}
		return summa;
	}

	public void b�rskrasch() {
		for (V�rdesaker p : �godelar) {
			if (p instanceof Aktier)
				((Aktier) p).rasaAktier();
		}
	}

}

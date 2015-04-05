public class Smycken extends V�rdesaker {

	private int �delstenar;
	private boolean �mne;

	public Smycken(String namn, boolean �mne, int �delstenar) {
		this.�delstenar = �delstenar;
		this.namn = namn;
		this.�mne = �mne;
		this.v�rde = getV�rde();
	}

	public int get�delstenar() {
		return �delstenar;
	}

	public boolean get�mne() {
		return �mne;
	}

	public int getV�rde() {

		if (�mne == true) {
			v�rde = 2000 + 500 * �delstenar;
		} else if (�mne == false) {
			v�rde = 700 + 500 * �delstenar;
		}
		return v�rde;
	}

	public String toString() {
		return namn + " " + v�rde;
	}
}

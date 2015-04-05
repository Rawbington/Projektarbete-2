public class Smycken extends Värdesaker {

	private int ädelstenar;
	private boolean ämne;

	public Smycken(String namn, boolean ämne, int ädelstenar) {
		this.ädelstenar = ädelstenar;
		this.namn = namn;
		this.ämne = ämne;
		this.värde = getVärde();
	}

	public int getÄdelstenar() {
		return ädelstenar;
	}

	public boolean getÄmne() {
		return ämne;
	}

	public int getVärde() {

		if (ämne == true) {
			värde = 2000 + 500 * ädelstenar;
		} else if (ämne == false) {
			värde = 700 + 500 * ädelstenar;
		}
		return värde;
	}

	public String toString() {
		return namn + " " + värde;
	}
}

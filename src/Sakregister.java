import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sakregister {

	private static Scanner keyInput = new Scanner(System.in);
	static ArrayList<Person> personRegister = new ArrayList<>();

	public static String readString(String prompt) {
		System.out.print(prompt);
		return keyInput.nextLine();

	}

	public static int readInt(String prompt) {
		System.out.print(prompt);
		int i = keyInput.nextInt();
		keyInput.nextLine();
		return i;
	}

	public static double readDouble(String prompt) {
		System.out.print(prompt);
		double i = keyInput.nextDouble();
		keyInput.nextLine();
		return i;
	}

	private static void init() {

		personRegister.add(new Person("Johan"));
		personRegister.add(new Person("Daniel"));
		Aktier nyAktier = new Aktier("Ericsson", 6, 5);
		Smycken nySmycke = new Smycken("Juvel", true, 3);
		Aktier nyAktier2 = new Aktier("Ericsson", 20, 5);
		personRegister.get(0).l�ggTillV�rdesaker(nyAktier);
		personRegister.get(1).l�ggTillV�rdesaker(nySmycke);
		personRegister.get(1).l�ggTillV�rdesaker(nyAktier2);
	}

	private static void cleanUp() {

	}

	private static boolean handleNextCommand() {
		String command = readString("> ").toLowerCase();

		switch (command) {
		case "skapa person":
			skapaPerson();
			break;
		case "skapa pryl":
			skapaPryl();
			break;
		case "visa alla":
			listaPersoner();
			break;
		case "visa rikaste":
			visaRikaste();
			break;
		case "visa viss person":
			listaVissPerson();
			break;
		case "b�rskrasch":
			b�rskrasch();
			break;
		case "avsluta":
		case "st�ng ner":
		case "exit":
		case "close":
			System.out.println("St�nger ner programmet.");
			return true;
		default:
			System.out.println("Felaktig input");
		}
		return false;
	}

	public static void b�rskrasch() {
		for (Person p : personRegister) {
			p.b�rskrasch();
		}
		System.out
				.println("Hoppsan, d�r slant n�n med spaken p� b�rsen. Alla aktier har f�rlorat sitt v�rde");
	}

	public static void visaRikaste() {
		Person rikast = personRegister.get(0);

		for (Person p : personRegister) {
			if (rikast.getPersonV�rde() <= p.getPersonV�rde()) {
				rikast = p;

			}

		}
		System.out.println(" Rikast �r " + rikast.getNamn()
				+ " med ett totalv�rde av: " + rikast.getPersonV�rde()
				+ " kr.");
		for (V�rdesaker v : rikast.�godelar) {
			System.out.println(v);
		}
	}

	public static void skapaPerson() {
		String namn = readString("Namnge personen ");
		boolean finnsPersonen = false;
		for (int i = 0; i < personRegister.size(); i++) {

			if (namn.equalsIgnoreCase(personRegister.get(i).getNamn())) {
				finnsPersonen = true;
			}
		}
		if (finnsPersonen == true) {
			System.out.println("Denna person existerar redan i registret!");

		} else if (finnsPersonen == false) {
			Person nyPerson = new Person(namn);
			personRegister.add(nyPerson);
			System.out.println(nyPerson);

		}
	}

	public static void listaPersoner() {
		for (Person p : personRegister) {
			System.out.print(p + ", ");
			for (int o = 0; o < p.�godelar.size(); ++o) {
				System.out.print(" " + p.�godelar.get(o) + "kr.");

			}
			System.out.println("  med ett totalv�rde av: " + p.getPersonV�rde());
		}
	}

	public static void listaVissPerson() {
		String namn = readString("Vilken person s�ker du?: ");
		boolean hittatNamn = false;
		for (Person p : personRegister) {

			if (namn.equalsIgnoreCase(p.getNamn())) {
				System.out.println(p.getNamn());
				System.out.println("�godelar: ");
				for (int o = 0; o < p.�godelar.size(); ++o) {
					System.out.println(p.�godelar.get(o));
					hittatNamn = true;

				}
				 System.out.println("Med ett totalv�rde av: " + p.getPersonV�rde());
				return;

			}

		}
		if (hittatNamn == false) {
			System.out.println("Felaktigt input");
		}
	}

	public static Person h�mtaPerson(String namn) {
		for (Person p : personRegister) {
			if (p.getNamn().equalsIgnoreCase(namn)) {
				return p;

			}

		}
		return null;
	}

	public static void skapaPryl() {
		String namn = readString("Vilken person �ger prylen? ");

		if (h�mtaPerson(namn) != null) {
			try {
				Person m = h�mtaPerson(namn);
				String namn2 = readString("Vilken sorts v�rdesak? ");

				if (namn2.equalsIgnoreCase("Aktie")) {
					String namnAktier = readString("Vilken sorts aktie? ");
					int antal = readInt("Vilket antal aktier? ");

					int pris = readInt("Vilket pris p� aktierna? ");
					Aktier nyAktier = new Aktier(namnAktier, antal, pris);
					m.l�ggTillV�rdesaker(nyAktier);

				} else if (namn2.equalsIgnoreCase("Apparat")) {
					String namnApparat = readString("Vilken sorts apparat? ");
					int slitaget = readInt("Vilket slitage har apparaten? ");
					int pris = readInt("Vilket pris har apparaten? ");
					Apparater nyApparater = new Apparater(namnApparat,
							slitaget, pris);
					m.l�ggTillV�rdesaker(nyApparater);

				} else if (namn2.equalsIgnoreCase("Smycke")) {
					String namnSmycke = readString("Vilken sorts smycke? ");
					int �delstenar = readInt("Hur m�nga �delstenar innefattas i smycket? ");
					String �mne = readString("Vilket �mne �r smycket av? (guld eller silver �r de �nda godtagbara �mnena i detta register)");
					boolean guld = false;

					if (�mne.equalsIgnoreCase("guld")) {
						guld = true;
					} else if (�mne.equalsIgnoreCase("silver")) {
						guld = false;
					} else {
						System.out
								.println("Smycket kan bara vara av guld eller silver");
					}
					Smycken nySmycken = new Smycken(namnSmycke, guld,
							�delstenar);
					m.l�ggTillV�rdesaker(nySmycken);
					System.out.println("Smycke skapat");
				} else {
					System.out
							.println("Detta �r inte en giltig v�rdesak, giltiga v�rdesaker �r: Apparat, Smycke och Aktie");
				}
			} catch (InputMismatchException bokst�verIMinaSiffror) {
				System.out.println("Felaktig input!");

			}

		} else {
			System.out.println("Denna person existerar inte i registret!");

		}
	}

	private static void printMenu() {
		System.out
				.println("F�ljande kommandon finns: Skapa person, Skapa pryl, visa alla, visa viss person, visa rikaste, b�rskrasch, avsluta");
	}

	public static void main(String[] args) {

		init();
		boolean done;
		do {
			printMenu();
			done = handleNextCommand();

		} while (!done);
		cleanUp();
	}

}

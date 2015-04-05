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
		personRegister.get(0).läggTillVärdesaker(nyAktier);
		personRegister.get(1).läggTillVärdesaker(nySmycke);
		personRegister.get(1).läggTillVärdesaker(nyAktier2);
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
		case "börskrasch":
			börskrasch();
			break;
		case "avsluta":
		case "stäng ner":
		case "exit":
		case "close":
			System.out.println("Stänger ner programmet.");
			return true;
		default:
			System.out.println("Felaktig input");
		}
		return false;
	}

	public static void börskrasch() {
		for (Person p : personRegister) {
			p.börskrasch();
		}
		System.out
				.println("Hoppsan, där slant nån med spaken på börsen. Alla aktier har förlorat sitt värde");
	}

	public static void visaRikaste() {
		Person rikast = personRegister.get(0);

		for (Person p : personRegister) {
			if (rikast.getPersonVärde() <= p.getPersonVärde()) {
				rikast = p;

			}

		}
		System.out.println(" Rikast är " + rikast.getNamn()
				+ " med ett totalvärde av: " + rikast.getPersonVärde()
				+ " kr.");
		for (Värdesaker v : rikast.ägodelar) {
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
			for (int o = 0; o < p.ägodelar.size(); ++o) {
				System.out.print(" " + p.ägodelar.get(o) + "kr.");

			}
			System.out.println("  med ett totalvärde av: " + p.getPersonVärde());
		}
	}

	public static void listaVissPerson() {
		String namn = readString("Vilken person söker du?: ");
		boolean hittatNamn = false;
		for (Person p : personRegister) {

			if (namn.equalsIgnoreCase(p.getNamn())) {
				System.out.println(p.getNamn());
				System.out.println("Ägodelar: ");
				for (int o = 0; o < p.ägodelar.size(); ++o) {
					System.out.println(p.ägodelar.get(o));
					hittatNamn = true;

				}
				 System.out.println("Med ett totalvärde av: " + p.getPersonVärde());
				return;

			}

		}
		if (hittatNamn == false) {
			System.out.println("Felaktigt input");
		}
	}

	public static Person hämtaPerson(String namn) {
		for (Person p : personRegister) {
			if (p.getNamn().equalsIgnoreCase(namn)) {
				return p;

			}

		}
		return null;
	}

	public static void skapaPryl() {
		String namn = readString("Vilken person äger prylen? ");

		if (hämtaPerson(namn) != null) {
			try {
				Person m = hämtaPerson(namn);
				String namn2 = readString("Vilken sorts värdesak? ");

				if (namn2.equalsIgnoreCase("Aktie")) {
					String namnAktier = readString("Vilken sorts aktie? ");
					int antal = readInt("Vilket antal aktier? ");

					int pris = readInt("Vilket pris på aktierna? ");
					Aktier nyAktier = new Aktier(namnAktier, antal, pris);
					m.läggTillVärdesaker(nyAktier);

				} else if (namn2.equalsIgnoreCase("Apparat")) {
					String namnApparat = readString("Vilken sorts apparat? ");
					int slitaget = readInt("Vilket slitage har apparaten? ");
					int pris = readInt("Vilket pris har apparaten? ");
					Apparater nyApparater = new Apparater(namnApparat,
							slitaget, pris);
					m.läggTillVärdesaker(nyApparater);

				} else if (namn2.equalsIgnoreCase("Smycke")) {
					String namnSmycke = readString("Vilken sorts smycke? ");
					int ädelstenar = readInt("Hur många ädelstenar innefattas i smycket? ");
					String ämne = readString("Vilket ämne är smycket av? (guld eller silver är de ända godtagbara ämnena i detta register)");
					boolean guld = false;

					if (ämne.equalsIgnoreCase("guld")) {
						guld = true;
					} else if (ämne.equalsIgnoreCase("silver")) {
						guld = false;
					} else {
						System.out
								.println("Smycket kan bara vara av guld eller silver");
					}
					Smycken nySmycken = new Smycken(namnSmycke, guld,
							ädelstenar);
					m.läggTillVärdesaker(nySmycken);
					System.out.println("Smycke skapat");
				} else {
					System.out
							.println("Detta är inte en giltig värdesak, giltiga värdesaker är: Apparat, Smycke och Aktie");
				}
			} catch (InputMismatchException bokstäverIMinaSiffror) {
				System.out.println("Felaktig input!");

			}

		} else {
			System.out.println("Denna person existerar inte i registret!");

		}
	}

	private static void printMenu() {
		System.out
				.println("Följande kommandon finns: Skapa person, Skapa pryl, visa alla, visa viss person, visa rikaste, börskrasch, avsluta");
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

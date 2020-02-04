import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The Class Zoo.
 */
public class Zoo {

	/** The sc. */
	private static Scanner sc = new Scanner(System.in);

	/** The choice. */
	private static int choice;

	/** The zone list. */
	private static List<Zone> zoneList = new ArrayList<Zone>();

	/**
	 * Main Method from the execution Starts.
	 *
	 * @param args
	 *            Command Line Argument
	 */
	public static void main(String args[]) {
		createZone();

		do {
			System.out.println("1 Add Zone");
			System.out.println("2 Add Animal");
			System.out.println("3 Delete Animal");
			System.out.println("4 Display Details Zone Wise");
			System.out.println("9 Exit!!! ");
			choice = getValidInteger();
			switch (choice) {

			case 1:
				createZone();
				break;
			case 2:
				addAnimal();
				break;
			case 3:
				if (deleteAnimal())
					System.out.println("Animal Deleted Suceccfully!!!");
				break;
			case 4:
				for (Zone z : zoneList)
					z.display();
				break;
			case 9:
				choice = 9;
				break;
			default:
				System.out.println("Enter a Valid choice");

			}
		} while (choice != 9);
	}

	/**
	 * Add animal to Zone when type of animal is not defined.
	 *
	 * @return true if animal Added Successfully
	 */
	public static boolean addAnimal() {
		String animalName;
		int animalAge;
		float animalWeight;
		Animal newAnimal = null;

		System.out.println("1 Lion");
		System.out.println("2 Tiger");
		System.out.println("3 Snake");
		System.out.println("4 Parrot");

		do {
			System.out.println("enter choice : ");
			choice = getValidInteger();
			sc.nextLine();
			System.out.println("Enter Animal Name :");
			animalName = sc.nextLine();
			System.out.println("Enter Animal Age :");
			animalAge = getValidInteger();
			System.out.println("Enter Animal weight :");
			animalWeight = getValidFloat();

			switch (choice) {
			case 1:
				newAnimal = new Lion(animalName, animalAge, animalWeight);
				break;
			case 2:
				newAnimal = new Tiger(animalName, animalAge, animalWeight);
				break;
			case 3:
				newAnimal = new Snake(animalName, animalAge, animalWeight);
				break;
			case 4:
				newAnimal = new Sparrow(animalName, animalAge, animalWeight);
				break;
			default:
				System.out.println("enter Correct choices : ");
			}
		} while (choice != 1 && choice != 2 && choice != 3 && choice != 4);

		if (addAnimalOfType(newAnimal))
			return true;
		return false;
	}

	/**
	 * Delete Animal and update Zone and cage as well .
	 *
	 * @return true if Animal Deleted Successfully
	 */
	public static boolean deleteAnimal() {
		System.out.println("List Of animals are :");
		boolean bol = false;
		boolean result = false;
		Zone zone = null;
		Cage cage = null;
		for (Zone x : zoneList) {
			for (Cage y : x.getCageList()) {
				for (Animal z : y.getAnimalList()) {
					System.out.println(z.getAnimalId() + " "
							+ z.getAnimalname());
					System.out.println("want to delete ?(true/false)");
					bol = getValidBoolen();
					if (bol) {
						y.getAnimalList().remove(z);
						zone = x;
						cage = y;
						result = true;
						break;
					}
					if (bol)
						break;
				}
				if (bol)
					break;
			}
			if (bol)
				break;
		}
		if (bol && cage.getAnimalList().size() == 0) {
			zone.getCageList().remove(cage);
			result = true;
		}
		return result;
	}

	/**
	 * Add animal to Zone when animal in defined .
	 *
	 * @param newAnimal
	 *            that want to be added
	 * @return true if Animal Added successfully
	 */
	public static boolean addAnimalOfType(Animal newAnimal) {

		boolean zoneExist = false;
		for (Zone x : zoneList) {
			if (x.getCategory() == newAnimal.getCategory()) {
				zoneExist = true;
				break;
			}
		}
		if (!zoneExist) {
			System.out.println("There is no zone Available for :"
					+ newAnimal.getCategory());
			System.out.println("Please create a zone first");
			return false;
		}
		for (Zone x : zoneList) {
			if (x.getCategory() == newAnimal.getCategory()) {
				if (x.addAnimalToCage(newAnimal)) {
					System.out.println("Animal Allocated a Cage");
					return true;
				}
			}
		}
		System.out.println("sorry!!! Animal not allocated a cage");
		return false;
	}

	/**
	 * Add Zone when category of Zone is not defined.
	 *
	 * @return true if Zone created Successfully
	 */
	public static boolean createZone() {
		String category = null;
		System.out.println("create a Zone for :");
		System.out.println("1 Mammal");
		System.out.println("2 Raptile");
		System.out.println("3 Bird");

		do {
			choice = getValidInteger();
			switch (choice) {
			case 1:
				category = Mammal.MAMMAL;
				break;
			case 2:
				category = Reptile.REPTILE;
				break;
			case 3:
				category = Bird.BIRD;
				break;
			default:
				System.out.println("enter Correct choices : ");
			}
		} while (choice != 1 && choice != 2 && choice != 3);

		return createZoneFor(category);

	}

	/**
	 * Add Zone when category of Zone is defined.
	 *
	 * @param category
	 *            of Zone that want to be created
	 * @return true if Zone created Successfully
	 */
	public static boolean createZoneFor(String category) {

		boolean hasPark;
		boolean hasCanteen;
		int maxCages;
		String name;
		try {
			System.out.println("Zone Name : ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.println("Zone has Park? (true/false) ");
			hasPark = getValidBoolen();
			System.out.println("Zone has Canteen? (true/false) ");
			hasCanteen = getValidBoolen();
			System.out.println("Maximum No of cages : ");
			maxCages = getValidInteger();
			Zone z = new Zone(name, hasPark, hasCanteen, maxCages, category);
			zoneList.add(z);

			return true;
		} catch (Exception E) {
			return false;
		}
	}

	/**
	 * Gets the valid boolean.
	 *
	 * @return :an integer passed by user with exception handling
	 */
	public static boolean getValidBoolen() {
		boolean value = false;
		boolean continueInput = true;
		do {
			try {
				value = sc.nextBoolean();
				continueInput = false;
			} catch (InputMismatchException ex) {
				System.out
						.println("Try again. Incorrect input: an boolen (true/false) is required)");
				sc.nextLine();
			}
		} while (continueInput);
		return value;
	}

	/**
	 * Gets the valid integer.
	 *
	 * @return :an integer passed by user with exception handling
	 */
	public static int getValidInteger() {
		int value = 0;
		boolean continueInput = true;
		do {
			try {
				value = sc.nextInt();
				continueInput = false;
			} catch (InputMismatchException ex) {
				System.out.println("Try again. ("
						+ "Incorrect input: an integer is required)");
				sc.nextLine();
			}
		} while (continueInput);
		return value;
	}

	/**
	 * Gets the valid float.
	 *
	 * @return :an integer passed by user with exception handling
	 */
	public static float getValidFloat() {
		Float value = null;
		boolean continueInput = true;
		do {
			try {
				value = sc.nextFloat();
				continueInput = false;
			} catch (InputMismatchException ex) {
				System.out
						.println("Try again!!! Incorrect input: a Float is required)");
				sc.nextLine();
			}
		} while (continueInput);
		return value;
	}
}

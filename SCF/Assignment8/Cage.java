import java.util.ArrayList;

/**
 * The Class Cage.
 */
public class Cage {

	/** The count. */
	private static int count = 0;

	/** The cage id. */
	private int cageId;

	/** The cage capacity. */
	private final int cageCapacity;

	/** The animal type. */
	private String animalType;

	/** The no of animal in cage. */
	private int noOfAnimalInCage;

	/** The animal list. */
	private ArrayList<Animal> animalList = new ArrayList<Animal>();

	/**
	 * Instantiates a new cage.
	 *
	 * @param capacity
	 *            of Cage
	 * @param animalType
	 *            type of animal (like Lion ,Tiger , Snake)
	 */
	public Cage(int capacity, String animalType) {
		count++;
		this.cageId = count;
		this.cageCapacity = capacity;
		this.animalType = animalType;
		this.noOfAnimalInCage = 0;
	}

	/**
	 * Checks if is full.
	 *
	 * @return true if cage has maximum no of animal that it can have
	 */
	public Boolean isFull() {
		if (cageCapacity == noOfAnimalInCage)
			return true;
		return false;
	}

	/**
	 * Adds the animal.
	 *
	 * @param toBeAdded
	 *            animal that want to added to that cage
	 * @return true if animal Added Successfully
	 */
	public boolean addAnimal(Animal toBeAdded) {
		if (cageCapacity != noOfAnimalInCage
				&& animalType == toBeAdded.getType()) {
			getAnimalList().add(toBeAdded);
			noOfAnimalInCage++;
			return true;
		} else
			return false;
	}

	/**
	 * Gets the cage id.
	 *
	 * @return Cage unique ID
	 */
	public int getCageId() {
		return cageId;
	}

	/**
	 * Gets the animal type.
	 *
	 * @return type of animal that cage have
	 */
	public String getAnimalType() {
		return animalType;
	}

	/**
	 * Gets the capacity.
	 *
	 * @return capacity of Cage
	 */
	public int getCapacity() {
		return cageCapacity;
	}

	/**
	 * Gets the no of animal.
	 *
	 * @return No of Animal that cage currently have
	 */
	public int getNoOfAnimal() {
		return noOfAnimalInCage;
	}

	/**
	 * Gets the animal list.
	 *
	 * @return Array List of Animal that cage have
	 */
	public ArrayList<Animal> getAnimalList() {
		return animalList;
	}
}

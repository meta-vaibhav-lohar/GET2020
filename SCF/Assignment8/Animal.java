/**
 * The Class Animal.
 */
abstract public class Animal {

	/** The count. */
	private static int count = 0;

	/** The animal id. */
	private int animalIid;

	/** The animal name. */
	private String animalName;

	/** The animal age. */
	private int animalAge;

	/** The animal weight. */
	private float animalWeight;

	/**
	 * constructor.
	 *
	 * @param name
	 *            of animal (String)
	 * @param age
	 *            of animal (integer)
	 * @param Weigtht
	 *            of animal (float)
	 */
	public Animal(String name, int age, float Weigtht) {
		count++;
		this.animalIid = count;
		this.animalName = name;
		this.animalAge = age;
		this.animalWeight = Weigtht;
	}

	/**
	 * Gets the animal id.
	 *
	 * @return unique animal id
	 */
	public int getAnimalId() {
		return animalIid;
	}

	/**
	 * Gets the animal name.
	 *
	 * @return animal Name
	 */
	public String getAnimalname() {
		return animalName;
	}

	/**
	 * Gets the animal age.
	 *
	 * @return animal age
	 */
	public int getAnimalAge() {
		return animalAge;
	}

	/**
	 * Gets the animal weight.
	 *
	 * @return Animal Weight
	 */
	public float getAnimalWeight() {
		return animalWeight;
	}

	/**
	 * Gets the category.
	 *
	 * @return Category of ANimal (Like Mammal ,Reptile ,Bird)
	 */
	abstract public String getCategory();

	/**
	 * Make sound.
	 *
	 * @return String of sound that animal make
	 */
	abstract public String makeSound();

	/**
	 * Gets the type.
	 *
	 * @return type of animal (like Lion ,Tiger, Snake ,Sparrow)
	 */
	abstract public String getType();

}

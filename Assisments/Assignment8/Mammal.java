/**
 * The Class Mammal.
 */
abstract public class Mammal extends Animal {

	/** The Constant MAMMAL. */
	public static final String MAMMAL = "Mammal";

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
	public Mammal(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}

	/**
	 * Make sound.
	 *
	 * @return String of sound that animal make
	 */
	@Override
	abstract public String makeSound();

	/**
	 * Gets the category.
	 *
	 * @return Category of Animal : here it is Mammal
	 */
	public String getCategory() {
		return MAMMAL;
	}

	/**
	 * Gets the type.
	 *
	 * @return type of animal (like Lion ,Tiger, Snake ,Sparrow)
	 */
	@Override
	abstract public String getType();
}

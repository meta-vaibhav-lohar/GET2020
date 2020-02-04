/**
 * The Class Reptile.
 */
abstract public class Reptile extends Animal {

	/** The Constant REPTILE. */
	public static final String REPTILE = "Reptile";

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
	public Reptile(String name, int age, float Weigtht) {
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
	 * @return Category of Animal : here it is Reptile
	 */
	@Override
	public String getCategory() {
		return REPTILE;
	}

	/**
	 * Gets the type.
	 *
	 * @return type of animal (like Lion ,Tiger, Snake ,Sparrow)
	 */
	@Override
	abstract public String getType();

}

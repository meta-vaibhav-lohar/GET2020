/**
 * The Class Bird.
 */
abstract public class Bird extends Animal {

	/** The Constant BIRD. */
	public static final String BIRD = "Bird";

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
	public Bird(String name, int age, float Weigtht) {
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
	 * @return Category of Animal : here it is Bird
	 */
	public String getCategory() {
		return BIRD;
	}

	/**
	 * Gets the type.
	 *
	 * @return type of animal (like Lion ,Tiger, Snake ,Sparrow)
	 */
	@Override
	abstract public String getType();

}

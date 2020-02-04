/**
 * The Class Sparrow.
 */
public class Sparrow extends Bird {

	/** The Constant SPARROW. */
	public static final String SPARROW = "Sparrow";

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
	public Sparrow(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}

	/**
	 * Make sound.
	 *
	 * @return String of sound that animal make
	 */
	@Override
	public String makeSound() {
		return "chirr-up";
	}

	/**
	 * Gets the type.
	 *
	 * @return type of animal here it is Sparrow)
	 */
	@Override
	public String getType() {
		return SPARROW;
	}

}

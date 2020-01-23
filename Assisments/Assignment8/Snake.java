/**
 * The Class Snake.
 */
public class Snake extends Reptile {

	/** The Constant SNAKE. */
	public static final String SNAKE = "Snake";

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
	public Snake(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}

	/**
	 * Make sound.
	 *
	 * @return String of sound that animal make
	 */
	@Override
	public String makeSound() {
		return "hissss";
	}

	/**
	 * Gets the type.
	 *
	 * @return type of animal here it is Snake
	 */
	@Override
	public String getType() {
		return SNAKE;
	}
}

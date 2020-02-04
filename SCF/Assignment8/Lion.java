public class Lion extends Mammal {

	public static final String LION = "Lion";

	/**
	 * constructor
	 * 
	 * @param name
	 *            of animal (String)
	 * @param age
	 *            of animal (integer)
	 * @param Weigtht
	 *            of animal (float)
	 */
	public Lion(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}

	/**
	 * 
	 * @return String of sound that animal make
	 */
	@Override
	public String makeSound() {
		return "Roar";
	}

	/**
	 * 
	 * @return type of animal here it is lion
	 */
	@Override
	public String getType() {
		return LION;
	}
}

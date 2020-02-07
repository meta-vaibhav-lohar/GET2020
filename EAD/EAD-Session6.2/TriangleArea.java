import javax.jws.WebService;


/**
 * The Class TriangleArea.
 */

public class TriangleArea {
	
	/**
	 * Area triangle.
	 *
	 * @param side1 the side 1
	 * @param side2 the side 2
	 * @param side3 the side 3
	 * @return the double
	 */
	public Double areaTriangle(Double side1, Double side2, Double side3) {
		Double s = (side1 + side2 + side3) / 2;
		return (Math.sqrt((s * (s - side1) * (s - side2) * (s - side3))));
	}
}

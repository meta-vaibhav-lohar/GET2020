public class DriverClass {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		int[] data1 = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,18};
		list.createLinkedList(data1);
		list.generateResultantLinkedList(5, 9, 2);
		list.printList();
		list=new LinkedList();
		int[] data2 = {2,3,4,5,6,7};
		list.createLinkedList(data2);
		list.generateResultantLinkedList(2, 5, 2);
		list.printList();
	}
}
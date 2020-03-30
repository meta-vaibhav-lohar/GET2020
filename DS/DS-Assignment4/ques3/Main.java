package ques3;
public class Main {

	public static void main(String[] args) {
	
		MolecularMass moleculeObj = new MolecularMass();
		
		System.out.println(moleculeObj.calculateMass("COH(COH)22"));
		
		System.out.println(moleculeObj.calculateMass("COH"));
		
		System.out.println(moleculeObj.calculateMass("CHOC(CH3)3"));
		
	}
}
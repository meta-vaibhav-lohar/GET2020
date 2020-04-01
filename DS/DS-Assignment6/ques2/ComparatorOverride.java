package ques2;

import java.util.Comparator;

public class ComparatorOverride implements Comparator<Vertex> {

	@Override
	public int compare(Vertex node1, Vertex node2) {
		
		return node1.getWeight() - node2.getWeight(); 
	}

}
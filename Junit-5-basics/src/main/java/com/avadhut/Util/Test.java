package com.avadhut.Util;

import java.util.*;
import java.util.stream.Collectors;

public class Test {

	
	public static void main(String[] args) {
		 List<Integer> list  = Arrays.asList(1,2,3,4,5,5,2,3,1,2,3);

	      Set<Integer> duplicateSet = new HashSet<Integer>();

	     list.stream().filter(n->!duplicateSet.add(n)).collect(Collectors.toSet());
	     
	     duplicateSet.forEach(System.out::print);
	      
	      
	}
	 
}

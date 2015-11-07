package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SSPList extends ArrayList<Integer> {

	private static final long serialVersionUID = -5888585540273812852L;
	
	public SSPList() {
		super();
	}
	
	public SSPList(List<Integer> list) {
		super(list);
	}
	
	public SSPList underCapacity(final int capacity) {
		List<Integer> list = this.stream().filter(v -> v <=capacity).collect(Collectors.toList());
		SSPList ssplist = new SSPList(list);
		
		return ssplist;
	}

}

package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

	public static SSPList parse(final String str) {
		SSPList list = new SSPList();
		String regex = "\\{(\\d+(?:,\\d+)*)\\}";
		
		Pattern ptrn = Pattern.compile(regex);
		Matcher mtcr = ptrn.matcher(str);
		
		mtcr.find();
		
		String strlist = mtcr.group(1);
		String[] values = strlist.split(",");
		for (String value : values)
			list.add(Integer.valueOf(value));
		return list;
	}

}

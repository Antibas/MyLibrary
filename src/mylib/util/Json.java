package mylib.util;

import java.util.HashMap;

public class Json extends HashMap<String, Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1856733155231772823L;

	@Override
	public String toString() {
		String str = "{\n";
		for(Entry<String, Object> entry: this.entrySet()){
			String v;// = entry.getValue().toString();
			if(entry.getValue() instanceof String) {
				v = "\""+entry.getValue().toString()+"\"";
			} else {
				v = entry.getValue().toString();
			}
			str += "\t\""+entry.getKey() + "\": " + v + ",\n";
		}
		str += "}";
		return str;
	}

}

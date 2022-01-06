package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class Document {
	String name;
	private Map<String,String>pairs = new HashMap<String,String>();

	Document(String name) {
		this.name = name;
	}

	void listPairs(){
		for(Map.Entry pairEntry: pairs.entrySet()) {
			System.out.println(pairEntry.getKey()+":"+pairEntry.getValue());
		}
	}
	void createPair(String key , String val){
		pairs.put(key,val);
	}
	void updatePair(String key , String val){
		pairs.replace(key,val);
	}
	void deletePair(String key){
		pairs.remove(key);
	}
 
}



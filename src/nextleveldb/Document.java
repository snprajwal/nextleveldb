package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class Document {
	String name;
	private Map<String,Map<String,String>>pairs = new HashMap<String,Map<String,String>>();

	Document(String name) {
		this.name = name;
	}

	void listPairs(){
		for(Map.Entry pairEntry: pairs.entrySet()) {
			System.out.println(pairEntry.getKey()+":"+pairEntry.getValue());
		}
	}
	void createPair(String key , String val){
		pairs.get(this.name).put(key,val);
	}
	void updatePair(String key , String val){
		pairs.get(this.name).replace(key,val);
	}
	void deletePair(String key){
		pairs.get(this.name).remove(key);
	}
 
}



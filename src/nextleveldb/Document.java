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
	void createPair(String keyy , String val){
		pairs.get(this.name).put(keyy,val);
	}
	void updatePair(String keyy , String val){
		pairs.get(this.name).replace(keyy,val);
	}
	void deletePair(String keyy){
		pairs.get(this.name).remove(keyy);
	}
 
}



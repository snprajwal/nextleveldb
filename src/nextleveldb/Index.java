package nextleveldb;

import java.util.HashMap;
import java.util.Map;

class Index {
	String name;
	String currentind;
	Index currentIndex;
	private Map<String,Document> docs = new HashMap<String,Document>();

	Index(String name) {
		this.name=name;
	}
	Document getDocument(String name){
		if (!docs.containsValue(name)){
			return new Document("");}
		else{
			return new Document(name); 
		}
	}
	void listDocuments(){
		for (Map.Entry pairEntry: docs.entrySet()) {
			System.out.println(pairEntry.getKey()+":"+pairEntry.getValue());}
	}
	void createDocument(String name){
		docs.put(name,getDocument(name));
	}
	void deleteDocument(String name){
		docs.remove(name);
	}
}

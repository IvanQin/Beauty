package beauty;
import java.util.*;
public class Id2Id {
	String Id_s;
	String Id_e;
	ArrayList<Dtype> startLink = new ArrayList<Dtype>();
	ConvertJSON converter = new ConvertJSON();
	/*
	 * 1-hop
	 * 1.essay->essay
	 * 
	 * 2-hop
	 * 1.essay->person->essay
	 * 2.essay->essay->essay
	 * 3.essay->CJF->essay
	 * 
	 * 3-hop
	 * 1.essay->person->essay->essay
	 * 2.essay->essay->person->essay
	 * 3.essay->CJF->essay->essay
	 * 4.essay->essay->CJF->essay
	 * 5.essay->essay->essay->essay
	 * 
	 */
	Id2Id (String Id_s, String Id_e){
		this.Id_e = Id_e;
		this.Id_s = Id_s;
	}
	public void get(String expr, String attributes,int count){
		startLink = converter.getParameters(expr, attributes, count);
		return;
	}
	public ArrayList<OneHop> findPath() {
		get("Id="+Id_s,"Id,RId,AA.AuId,AA.AfId,C.CId,J.JId,F.FId",1000);
		// 1 hop
		ArrayList <OneHop> oneHopSet = new ArrayList<OneHop>();
		for (int i = 0; i < startLink.size(); ++i){
			ArrayList<String> rid = startLink.get(i).RId;
			for (int j = 0; j < rid.size(); ++j)
				if ((startLink.get(i).RId.get(j)).equals(Id_e)){
					OneHop answer = new OneHop();
					answer.add(Id_s);
					answer.add(Id_e);
					oneHopSet.add(answer);
				}
			}
		return oneHopSet;
	}
	
	
	
	
	

}

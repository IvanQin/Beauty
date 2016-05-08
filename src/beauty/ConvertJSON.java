package beauty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
public class ConvertJSON {
	
	private ArrayList<Dtype> convert(String jsonStr){
		ArrayList<Dtype> list = new ArrayList<Dtype>();
		try {
			JSONObject jsonObj = new JSONObject (jsonStr);
			//System.out.println(jsonStr);
			JSONArray entities = jsonObj.getJSONArray("entities");
			for (int i = 0; i < entities.length(); ++i){
				JSONObject jsonItem = entities.getJSONObject(i);
				Dtype data = new Dtype();
				String s=jsonItem.getString("Id");
				if (s != null)
					data.setId(s);
				JSONArray jsonRId = jsonItem.getJSONArray("RId");
				if (jsonRId != null)
					for (int j = 0; j < jsonRId.length(); ++j){
						s=jsonRId.getString(j);
						data.RId.add(s);
					}
				JSONArray jsonAA = jsonItem.getJSONArray("AA");
				if (jsonAA != null)
					for (int j = 0; j < jsonAA.length(); ++j){
						JSONObject author = jsonAA.getJSONObject(j);
						String auid = author.getString("AuId");
						String afid = author.getString("AfId");
						data.AA.add(new Author (afid,auid));
					}
				if (jsonItem.has("C")){
					JSONObject jsonC = jsonItem.getJSONObject("C");
					for (int j = 0; j < jsonC.length(); ++j){
						s=jsonC.getString("CId");
						data.CId.add(s);
					}
				}
				
				if (jsonItem.has("F")){
					JSONObject jsonF = jsonItem.getJSONObject("F");
					for (int j = 0; j < jsonF.length(); ++j){
						s=jsonF.getString("FId");
						data.FId.add(s);
					}
				}
				if (jsonItem.has("J")){
					JSONObject jsonJ = jsonItem.getJSONObject("J");
					for (int j = 0; j < jsonJ.length(); ++j){
						s=jsonJ.getString("CId");
						data.JId.add(s);
					}
				}
				list.add(data);
			}
				
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Dtype> getParameters(String expr,String attributes,int count){
		GetJSON json = new GetJSON();
		ArrayList<Dtype> list;
		String jsonStr = json.getJSON(expr,attributes,count);
		list = convert (jsonStr);
		return list;
	}

}

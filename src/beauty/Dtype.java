package beauty;
import java.util.*;
class Author{
	String AfId;
	String AuId;
	Author (){};
	Author (String AfId,String AuId){
		this.AfId = AfId;
		this.AuId = AuId;
	}
	public void setAfId (String AfId){
		this.AfId = AfId;
	}
	public void setAuId (String AuId){
		this.AuId = AuId;
	}
}
public class Dtype {
	String Id; 
	ArrayList<String> RId = new ArrayList<String>();
	ArrayList<String> FId = new ArrayList<String>(); //Field of study Id
	ArrayList<String> CId = new ArrayList<String>(); //Conference series Id
	ArrayList<String> JId = new ArrayList<String>(); // Journal ID
	
	ArrayList<Author> AA = new ArrayList<Author>(); // Author Id
	
	public void setId (String Id){
		this.Id = Id;
	}
	public void addFId (String FId){
		this.FId.add(FId);
	}
	public void setCId (String CId){
		this.CId.add(CId);
	}
	public void setJId (String JId){
		this.JId.add(JId);
	}
	public void setAuthor (String AfId, String AuId){
		Author author = new Author (AfId,AuId);
		this.AA.add(author);
	}
	public void setRId (String RId){
		this.RId.add(RId);
	}
}

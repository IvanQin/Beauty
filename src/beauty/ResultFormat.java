package beauty;
class OneHop extends ResultFormat{
	
	public String[] getOneHop(){
		return path;
	}
}
class TwoHop extends ResultFormat{
	public String[] getTwoHop(){
		return path;
	}
}
class ThreeHop extends ResultFormat{
	public String[] getThreeHop(){
		return path;
	}
}
public class ResultFormat {
	String[] path = new String[4];
	int index = 0;
	public void add (String s){
		this.path[index++] = s;
	}
	
}

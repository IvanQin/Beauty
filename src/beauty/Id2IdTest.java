package beauty;
import java.util.*;
public class Id2IdTest {
	public static void main (String args[]){
		String id1="2140251882";
		String id2="1602506470";
		
		Id2Id id2id = new Id2Id(id1,id2);
		ArrayList<OneHop> result = id2id.findPath();
		OneHop onehop = null;
		System.out.println("One-hop result : ");
		for (int i = 0; i < result.size(); ++i)
			onehop = result.get(i);
			System.out.print("[");
			for (int j = 0; j < 1; ++j)
				System.out.print(onehop.path[j]+",");
			System.out.print(onehop.path[1]+"]");
		}
}

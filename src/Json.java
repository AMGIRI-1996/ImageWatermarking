import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;

class JsonEncodeDemo {

   
}
public class Json {
	public static void main(String[] args){
	      JSONObject obj = new JSONObject();
	      
	      Integer[] a = {1,2,3,4};
	      List<Integer> iarray=Arrays.asList(a);
	    
	      obj.put("name", "foo");
	      obj.put("num", iarray);
	      obj.put("balance", new Double(1000.21));
	      obj.put("is_vip", new Boolean(true));

	      System.out.print(obj);
	   }
}

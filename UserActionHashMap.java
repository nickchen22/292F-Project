import java.util.*;
import java.util.Map;
import java.util.HashMap;

public class UserActionHashMap<user_name, ts, action>  {

	Map<user_name, Map<ts, action>> Usermap = new HashMap<user_name, Map<ts, action>>(); 

	public action put(user_name user_Name, ts Ts, action Action) {
		Map<ts, action> Umap;
		if (Usermap.containsKey(user_Name)){
			Umap = Usermap.get(user_Name);
		}else {
			Umap = new java.util.HashMap<ts, action>();
			Usermap.put(user_Name, Umap);
		}

		return Umap.put(Ts, Action);
	}

	public action get(user_name user_Name, ts Ts) {
	    if (Usermap.containsKey(user_Name)) {
	        return Usermap.get(user_Name).get(Ts);
	    } else {
	        return null;
	    }
	}

	public boolean containsKeys(user_name user_Name, ts Ts) {
	    return Usermap.containsKey(user_Name) && Usermap.get(user_Name).containsKey(Ts);
	}

	public void clear() {
	    Usermap.clear();

	}
}

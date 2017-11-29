public class UserActionHashMap<user_name, ts, action>  {

private final Map<user_name, Map<ts, action>> Usermap;

public BiHashMap() {
	UserMap = new HashMao<user_name, Map<ts, action>>(); 
}

public action put(user_name user_Name, ts Ts, action Action) {
	Map<ts, action> Umap;
	if (UserMap.containsKey(user_Name)){
		Umap = UserMap.get(key1);
	}else {
		Umap = new Hashmap<ts, action>();
		Usermap.put(user_Name, Umap);
	}

	return map.put(Ts, Action);
}

public action get(user_name user_Name, ts Ts) {
    if (Usermap.containsKey(user_Name)) {
        return Usermap.get(user_Name).get(Ts);
    } else {
        return null;
    }
}

public boolean containsKeys(user_name user_Name, ts Ts) {
    return Usermap.containsKey(user_Name) && mMap.get(user_Name).containsKey(Ts);
}

public void clear() {
    Usermap.clear();

}

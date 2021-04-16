package prac.jihye;

import java.util.HashMap;
import java.util.Map;

public class Msgr_Mem_Map {


	private Map<String, Object> mMap = null;
	
	public Msgr_Mem_Map() {
		mMap = new HashMap<String, Object>();
		mMap.put("id","");
		mMap.put("pw","");
		mMap.put("nickname", "");
	}
	
	public Map<String, Object> getmMap() {
		return mMap;
	}
	
	public void setmMap(Map<String, Object> mMap) {
		this.mMap = mMap;
		
	}
}
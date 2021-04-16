package prac1;

import java.util.HashMap;
import java.util.Map;

public class MemberMap {
	private Map<String, Object> map = null;

	public MemberMap() {
		columnInit(); //사용자 정의 메소드 이름 
	}

	private void columnInit() {
		map = new HashMap<String, Object>();
		//모든 테이블의 컬럼명을 미리 put 해놓기 
		//map.put("key이름","")
		map.put("id", "");
		map.put("password", "");
		map.put("nickname", "");
		//깃 연습2222222
		//dfdfdf
	}

	public Map<String, Object> getMap() {
		return map;
	}

//	public void setMap(Map<String, Object> map) {
//		this.map = map;
//	}
}

package prac1;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * DML 문장 실행과정
 * 1)parsing(=자바의 컴파일): 문법 체크
 * 2) 실행계획 세움.
 * 3) 실행계획을 옵티마이저에게 넘긴다. 
 *  구분 rule: ex 수동 카메라, cost: ex 자동 카메라 
 * 4) cursor 열어주고 -> fetch:다운받고, 메모리상주시킴 -> close
 */

public class MyBatisTest {
	//resource = "패키지이름\\MapperConfig.xml 파일 이름"; <경로
	String				resource	= "prac1\\MapperConfig.xml"; 
	//SqlSessionFactory의 역할: Connection
	SqlSessionFactory	sqlMapper	= null;

	public List<Map<String, Object>> testMap() {
		List<Map<String, Object>>	memberList	= null;
		//SqlSession의 역할: sql 처리 요청
		SqlSession					session		= null;
		MemberMap				msgrMemMap		= new MemberMap();

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
//			Map<String, Object> pMap = new HashMap<String, Object>();
			session = sqlMapper.openSession();

			msgrMemMap.getMap().put("id", "testuser1");
			msgrMemMap.getMap().put("password", "123");

//			pMap.put("id", "testuser1");
//			pMap.put("password", "123");
//			msgrMap.setMap(pMap);
			
			/*
			sql세션 변수이름.selectone("id"<-mapper 파일에 <mapper namespace="mybatis.mapper.testMapper">가 옴, 파라미터값(value));
			sql세션 변수이름.selectList("id", 파라미터값(value)); return 타입이 List
			sql세션 변수이름.selectMap <-쓸 일 잘 없음. 
			*/
			
			//list변수이름 = sqlsession변수이름.selectList("매퍼네임스페이스.select문 id", map클래스 변수이름.getMap()0;
			
			memberList = session.selectList("mybatis.mapper.testMapper.selectList", msgrMemMap.getMap());
			
			//memList1 = sqlsession.selectList("mybatisTest.Mapper.inquiry", msgrMap.getMap());
			//for(Map i:memList1) {  //맵에 여러 행을 넣어줄 때 
			//	memList.add(i);
			//}
			//memList1 = sqlsession.selectList("mybatisTest.Mapper.inquiry1", msgrMap.getMap());
			//리스트에 새로운 쿼리문의 결과를 붙일 경우 row가 한개라면 selectOne
			//memList.add(sqlsession.selectOne("mybatisTest.Mapper.inquiry1", msgrMap.getMap()));
			
			//세션은 항상 닫아줘야 함. 
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return memberList;
	}

	public static void main(String[] args) {

		MyBatisTest					mt		= new MyBatisTest(); //클래스명 인스턴스화
		List<Map<String, Object>>	list	= null;

		list = mt.testMap();
		
		/*
		 * for-each문 : for(해당 배열에 들어가는 타입 v 변수이름 : 배열형식의 종류){루프문}
		 * :오른쪽(iterate 자리)엔 루프를 돌릴 수 있는 형태인 배열 및 arraylist, list등이 가능하다. 
		 * :맨 왼쪽엔 배열에 들어가는 타입이 들어간다. 
		 * for (type var: iterate) { //var = 변수이름 
    			body-of-loop
			}
		 */
 
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
	}
}

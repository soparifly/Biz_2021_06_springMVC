package com.callor.jdbc.pesistance;

import java.util.List;
/*
 * Generic
 * 2004년 자바 5가 발표되면서 추가되었다.
 * 중복되는 코드를 최소화할수 있다
 * 인터페이스의 부모역할을 하는 Super Interface이다
 * Dao와 같은 인터페이스를 설계할때
 * table 마다 dao 인터페이스를 만들고
 * 인터페이스를 상속 받아 클래스를 선언하는데 
 * 이때, 대부분의 Dao에는 같은 이름의 메소드가 존재하더라
 * 그런데 이 mehtod	들이 return 타입과 매개변수가 달라서
 * 어쩔수 없이 비슷한 거의 같은 메서드를 갖는 인터페이스를 중복작성해야하더라
 * 제네릭 ( <Generic, Generic> )을 interface에 설정하고 
 * 임의의 이름을 지정해준다
 * 여기에서는 VO, PK라는 이름을 임의로 지정하였다
 * 그리고 메서드를 선언할때 Generic으로 지정된 이름을 사용하여 return 타입과 
 * 공통매개변수를 사용하였다
 * 이렇게 Generic을 갖는 interface 를 만들어두고
 * 또다른 interface 만들때 이 Generic interface를 상속 받아서 사용한다 
 * 상속받는 interface는 상속되는 곳에 자신의 VO, primary key컬럼의 PK타입을 지정해주면 
 * 공통된 메서드를 다시 만들 필요가 없어진다
 */

public interface GenericDao<VO,PK> {
	public List<VO> selectAll();
	public VO findById(PK pk);
	public int insert(VO vo);
	public int update(VO vo);
	public int delete(PK pk);

}

package com.startea.team.dao;

import java.util.List;

public interface GenericDao<VO, PK> {

	public List<VO> selectAll();

	public VO findById(PK pk);

	public int insert(VO vo);

	public int delete(PK pk);

	public int update(VO vo);
}

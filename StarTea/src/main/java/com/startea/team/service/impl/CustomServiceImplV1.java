package com.startea.team.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.startea.team.model.CustomVO;
import com.startea.team.service.CustomService;

import lombok.RequiredArgsConstructor;

/*
 * 여기에 들어가야할 기능
 */
@RequiredArgsConstructor
@Service("customService")
public class CustomServiceImplV1 implements CustomService {

	protected CustomDao ctDao;

	@Override
	public List<CustomVO> menumake() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.akapush.plm.service.internal;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.YoungDAO;
import com.akapush.plm.domain.exception.NoYoungAvailable;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.YoungService;

@Service
public class YoungServiceImpl implements YoungService {

	@Autowired
	private YoungDAO youngDAO;

	@Override
	public Young getYoungById(Long youngId) throws NoYoungAvailable {
		Optional<Young> young = youngDAO.findById(youngId);
		if (young.isPresent()) {
			return young.get();

		} else {
			throw new NoYoungAvailable(youngId);
		}
	}

	@Override
	public Young saveYoung(Young young) {
		return youngDAO.save(young);
	}

}

package com.akapush.plm.service.internal;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.YoungDAO;
import com.akapush.plm.domain.enumartion.BeanType;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailable;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.YoungService;

@Service
public class YoungServiceImpl implements YoungService {

	@Autowired
	private YoungDAO youngDAO;

	@Override
	public Young getYoungById(Long youngId) throws NoBeanAvailable {
		Optional<Young> young = youngDAO.findById(youngId);
		if (young.isPresent()) {
			return young.get();

		} else {
			throw new NoBeanAvailable(BeanType.YOUNG, youngId);
		}
	}

	@Override
	public Young saveYoung(Young young) throws InvalidBeanException {
		if (young == null) {
			throw new InvalidBeanException("Young must not be null");
		}
		if (StringUtils.isEmpty(young.getLastname())) {
			throw new InvalidBeanException("Young's name must be defined");
		}
		return youngDAO.save(young);
	}

}

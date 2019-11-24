package com.akapush.plm.service.internal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.AwarenessDAO;
import com.akapush.plm.domain.enumartion.BeanType;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.AwarenessService;

@Service
public class AwarenessServiceImpl implements AwarenessService {

	@Autowired
	private AwarenessDAO awarenessDAO;

	@Override
	public Awareness getAwarenessById(Long id) throws NoBeanAvailableException {
		Optional<Awareness> awareness = awarenessDAO.findById(id);
		if (awareness.isPresent()) {
			return awareness.get();
		} else {
			throw new NoBeanAvailableException(BeanType.AWARENESS, id);
		}
	}

	@Override
	public Awareness saveAwareness(Awareness awareness) throws InvalidBeanException {
		Long id = awareness.getId();
		//TODO trick to avoid awarness / young delete
		if(id != null) {
			Optional<Awareness> dbAwareness = awarenessDAO.findById(id);
			if (dbAwareness.isPresent()) {
				List<Young> youngs = dbAwareness.get().getYoungs();
				awareness.setYoungs(youngs);
			}
		}
		return awarenessDAO.save(awareness);
	}

	@Override
	public Iterable<Awareness> getAllAwarenesses() {
		return awarenessDAO.findByOrderByDateDesc();
	}

	@Override
	public Iterable<Young> getAwarenessYoungs(long id) {
		return  awarenessDAO.findYoungByAwareness(id);

	}

}

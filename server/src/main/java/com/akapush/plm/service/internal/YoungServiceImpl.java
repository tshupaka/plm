package com.akapush.plm.service.internal;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akapush.plm.dao.AccompanyingDAO;
import com.akapush.plm.dao.AwarenessDAO;
import com.akapush.plm.dao.YoungDAO;
import com.akapush.plm.domain.enumartion.BeanType;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Accompanying;
import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.YoungService;

@Service
public class YoungServiceImpl implements YoungService {

	@Autowired
	private YoungDAO youngDAO;

	@Autowired
	private AwarenessDAO awarenessDAO;

	@Autowired
	private AccompanyingDAO accompanyingDAO;

	@Override
	public Young getYoungById(Long youngId) throws NoBeanAvailableException {
		Optional<Young> young = youngDAO.findById(youngId);
		if (young.isPresent()) {
			return young.get();

		} else {
			throw new NoBeanAvailableException(BeanType.YOUNG, youngId);
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

	@Override
	public void deleteYoungById(Long youngId) throws NoBeanAvailableException {
		Young young = getYoungById(youngId);
		youngDAO.delete(young);

	}

	@Override
	public Iterable<Young> getAllYoungs() {

		return youngDAO.getAllYWithCurrentAccompanying();
	}

	@Override
	public Iterable<Awareness> getAwarenessesFromYoungId(long youngId) {
		Young young = new Young();
		young.setId(youngId);
		return awarenessDAO.findByYoungs(young);
	}

	@Override
	@Transactional
	public Awareness addAwarenessToYoung(Long youngId, Long awarenessId) throws NoBeanAvailableException {
		Optional<Awareness> awarenessOpt = awarenessDAO.findById(awarenessId);
		if (!awarenessOpt.isPresent()) {
			throw new NoBeanAvailableException(BeanType.AWARENESS, awarenessId);
		}
		Optional<Young> youngOpt = youngDAO.findById(youngId);
		if (!youngOpt.isPresent()) {
			throw new NoBeanAvailableException(BeanType.YOUNG, youngId);
		}
		Awareness awareness = awarenessOpt.get();
		Young young = youngOpt.get();
		List<Awareness> awarenesses = young.getAwarenesses();
		if (!awarenesses.contains(awareness)) {
			awarenesses.add(awareness);
		}
		return awareness;

	}

	@Override
	public Iterable<Awareness> deleteAwarenessFromYoung(long youngId, long awarenessId)
			throws NoBeanAvailableException {
		Optional<Young> youngOpt = youngDAO.findById(youngId);
		if (youngOpt.isPresent()) {
			Young young = youngOpt.get();
			List<Awareness> awarenesses = young.getAwarenesses();
			for (Awareness awareness : awarenesses) {
				if (awareness.getId().equals(awarenessId)) {
					awarenesses.remove(awareness);
					break;
				}
			}
			youngDAO.save(young);
			return awarenesses;
		} else {
			throw new NoBeanAvailableException(BeanType.YOUNG, youngId);
		}

	}

	@Override
	public Accompanying getCurrentAccompanyingFromYoungId(long youngId) throws NoBeanAvailableException {
		Young young = new Young();
		young.setId(youngId);
		Iterable<Accompanying> notClosedAccompanyings = accompanyingDAO.findAccompanyingByYoungAndClosed(young, false);
		Iterator<Accompanying> iterAccompanyings = notClosedAccompanyings.iterator();
		if (iterAccompanyings.hasNext()) {
			return iterAccompanyings.next();
		}
		Accompanying accompanying = new Accompanying();
		accompanying.setClosed(false);
		accompanying.setDate(new Date());
		return accompanying;
	}

	@Override
	public Iterable<Accompanying> getHistoricAccompanyings(long youngId) {
		Young young = new Young();
		young.setId(youngId);
		Iterable<Accompanying> accompanyings = accompanyingDAO.findAccompanyingByYoungAndClosed(young, true);
		return accompanyings;
	}

	@Override
	public Accompanying getAccompanyingById(Long accompanyingId) throws NoBeanAvailableException {
		Optional<Accompanying> optAccompanying = accompanyingDAO.findById(accompanyingId);
		if (optAccompanying.isPresent()) {
			return optAccompanying.get();
		}
		throw new NoBeanAvailableException(BeanType.ACCOMPANYING, accompanyingId);
	}

	@Override
	public Accompanying saveAccompanying(Accompanying accompanying) {
		return accompanyingDAO.save(accompanying);
	}

}

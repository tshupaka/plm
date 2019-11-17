package com.akapush.plm.web;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.akapush.plm.domain.exception.AlreadyExistingYoungException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.akapush.plm.domain.dto.AccompanyingDTO;
import com.akapush.plm.domain.dto.AwarenessDTO;
import com.akapush.plm.domain.dto.YoungDTO;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Accompanying;
import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.Meeting;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.YoungService;
import com.akapush.plm.util.AccompanyingHelper;
import com.akapush.plm.util.AwarenessHelper;
import com.akapush.plm.util.CSVGenerator;
import com.akapush.plm.util.YoungHelper;

import net.sf.ehcache.CacheManager;

@RestController
public class YoungController {

	@Autowired
	private YoungService youngService;

	@Autowired
	private YoungHelper youngHelper;

	@Autowired
	private AwarenessHelper awarenessHelper;

	@Autowired
	private AccompanyingHelper accompanyingHelper;

	@Autowired
	private CSVGenerator csvGenerator;

	private static final Log LOG = LogFactory.getLog(YoungController.class);

	@RequestMapping(value = "/api/young/{youngId}", method = RequestMethod.GET)
	public ResponseEntity<YoungDTO> getYoungById(@PathVariable("youngId") Long youngId) {

		try {
			//
			Young young = youngService.getYoungById(youngId);
			sortAccompanyings(young);
			sortAccompanyingsMeeting(young);
			YoungDTO youngDTO = youngHelper.getYoungDTO(young);
			CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.akapush.plm.domain.model.DropDownKey").getKeys();
			return new ResponseEntity<YoungDTO>(youngDTO, HttpStatus.OK);
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<YoungDTO>(HttpStatus.NOT_FOUND);
		}

	}

	private void sortAccompanyingsMeeting(Young young) {
		List<Accompanying> accompanyings = young.getAccompanyings();
		if (accompanyings != null) {
			for (Accompanying accompanying : accompanyings) {
				sortMeetings(accompanying.getMeetings());
			}
		}

	}

	private void sortMeetings(List<Meeting> meetings) {
		if (meetings != null) {
			meetings.sort(new Comparator<Meeting>() {

				@Override
				public int compare(Meeting meeting1, Meeting meeting2) {
					return meeting1.compareTo(meeting2);
				}
			});
		}

	}

	private void sortAccompanyings(Young young) {
		List<Accompanying> accompanyings = young.getAccompanyings();
		if (accompanyings != null) {
			accompanyings.sort(new Comparator<Accompanying>() {

				@Override
				public int compare(Accompanying accompanying1, Accompanying accompanying2) {
					return accompanying1.compareTo(accompanying2);
				}
			});
		}
	}

	@RequestMapping(value = "/api/young/{youngId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteYoungById(@PathVariable("youngId") Long youngId) {

		try {
			//
			youngService.deleteYoungById(youngId);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/api/young", method = RequestMethod.POST)
	public ResponseEntity<YoungDTO> saveYoung(@RequestBody YoungDTO youngDTO, @RequestParam("force") boolean forceInsert) {
		try {
			Young young = youngHelper.getYoung(youngDTO);
			Young result = youngService.saveYoung(young, forceInsert);

			YoungDTO resultDTO = youngHelper.getYoungDTO(result);
			return new ResponseEntity<YoungDTO>(resultDTO, HttpStatus.OK);
		} catch (InvalidBeanException e) {
			LOG.error("Invalid Young Bean : " + e.getMessage());
			return new ResponseEntity<YoungDTO>(HttpStatus.BAD_REQUEST);
		} catch (AlreadyExistingYoungException e) {
			Young result = e.getYoung();
			YoungDTO resultDTO = youngHelper.getYoungDTO(result);
			return new ResponseEntity<YoungDTO>(resultDTO, HttpStatus.ALREADY_REPORTED);
		}
	}

	@RequestMapping(value = "/api/youngs", method = RequestMethod.GET)
	public ResponseEntity<List<YoungDTO>> getAllYoungs() {
		Iterable<Young> youngs = youngService.getAllYoungs();
		if (youngs == null) {
			return new ResponseEntity<List<YoungDTO>>(HttpStatus.NOT_FOUND);
		}
		List<YoungDTO> youngsDTO = youngHelper.getYoungsDTO(youngs);
		return new ResponseEntity<List<YoungDTO>>(youngsDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/csv/youngs", produces = "text/csv", method = RequestMethod.GET)
	public void getCSVYoungs(HttpServletResponse response) {
		Iterable<Young> youngs = youngService.getAllYoungs();
		csvGenerator.generateYoungsCSV(response, youngs);
	}

	@RequestMapping(value = "/api/young/{youngId}/awareness", method = RequestMethod.GET)
	public ResponseEntity<List<AwarenessDTO>> getAwarenessesFromYoung(@PathVariable(name = "youngId") long youngId) {
		Iterable<Awareness> awarenesses = youngService.getAwarenessesFromYoungId(youngId);
		List<AwarenessDTO> awarenessesDTO = awarenessHelper.getAwarenessDTO(awarenesses);
		return new ResponseEntity<>(awarenessesDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/young/awareness", method = RequestMethod.POST)
	public ResponseEntity<AwarenessDTO> addAwarenessToYoung(@RequestBody Map<String, Long> parameters) {
		Long youngId = parameters.get("youngId");
		Long awarenessId = parameters.get("awarenessId");
		try {
			Awareness awareness = youngService.addAwarenessToYoung(youngId, awarenessId);
			AwarenessDTO awarenessDTO = awarenessHelper.getAwarenessDTO(awareness);
			return new ResponseEntity<AwarenessDTO>(awarenessDTO, HttpStatus.OK);
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<AwarenessDTO>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/young/{youngId}/awareness/{awarenessId}", method = RequestMethod.DELETE)
	public ResponseEntity<List<AwarenessDTO>> deleteAwarenessFromYoung(@PathVariable(name = "youngId") long youngId,
			@PathVariable(name = "awarenessId") long awarenessId) {
		try {
			Iterable<Awareness> awarenesses = youngService.deleteAwarenessFromYoung(youngId, awarenessId);
			List<AwarenessDTO> awarenessDTO = awarenessHelper.getAwarenessDTO(awarenesses);
			return new ResponseEntity<List<AwarenessDTO>>(awarenessDTO, HttpStatus.OK);
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<List<AwarenessDTO>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/young/{youngId}/accompanying/current", method = RequestMethod.GET)
	public ResponseEntity<AccompanyingDTO> getCurrentAccompanying(@PathVariable(name = "youngId") long youngId)
			throws NoBeanAvailableException {
		Accompanying accompanying = youngService.getCurrentAccompanyingFromYoungId(youngId);
		AccompanyingDTO accompanyingDTO = accompanyingHelper.getAccompanyingDTO(accompanying);
		return new ResponseEntity<AccompanyingDTO>(accompanyingDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/young/{youngId}/accompanying/historic", method = RequestMethod.GET)
	public ResponseEntity<List<AccompanyingDTO>> getHistoricAccompanyings(
			@PathVariable(name = "youngId") long youngId) {
		Iterable<Accompanying> accompanyings = youngService.getHistoricAccompanyings(youngId);
		List<AccompanyingDTO> accompanyingDTOs = accompanyingHelper.getAccompanyingDTOs(accompanyings);
		return new ResponseEntity<List<AccompanyingDTO>>(accompanyingDTOs, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/young/accompanying/{id}", method = RequestMethod.GET)
	public ResponseEntity<AccompanyingDTO> getAccompanyingById(@PathVariable(name = "id") long accompanyingId)
			throws NoBeanAvailableException {
		Accompanying accompanying = youngService.getAccompanyingById(accompanyingId);
		AccompanyingDTO accompanyingDTO = accompanyingHelper.getAccompanyingDTO(accompanying);
		return new ResponseEntity<AccompanyingDTO>(accompanyingDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/young/{id}/accompanying", method = RequestMethod.POST)
	public ResponseEntity<AccompanyingDTO> saveAccompanying(@PathVariable(name = "id") long youngId,
			@RequestBody AccompanyingDTO accompanyingDTO) {

		Accompanying accompanying = accompanyingHelper.getAccompanying(accompanyingDTO);
		Young young = new Young();
		young.setId(youngId);
		accompanying.setYoung(young);
		Accompanying savedAccompanying = youngService.saveAccompanying(accompanying);
		AccompanyingDTO savedAccompanyingDTO = accompanyingHelper.getAccompanyingDTO(savedAccompanying);
		return new ResponseEntity<AccompanyingDTO>(savedAccompanyingDTO, HttpStatus.OK);

	}
}

package com.akapush.plm.web;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akapush.plm.domain.dto.AwarenessDTO;
import com.akapush.plm.domain.dto.YoungDTO;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailableException;
import com.akapush.plm.domain.model.Awareness;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.AwarenessService;
import com.akapush.plm.util.AwarenessHelper;
import com.akapush.plm.util.YoungHelper;

@RestController
public class AwarenessController {

	@Autowired
	private AwarenessService awarenessService;

	@Autowired
	private AwarenessHelper awarenessHelper;

	@Autowired
	private YoungHelper youngHelper;

	private static final Log LOG = LogFactory.getLog(AwarenessController.class);

	@RequestMapping(value = "/api/awareness/{awarenessId}", method = RequestMethod.GET)
	public ResponseEntity<AwarenessDTO> getAwarenessById(@PathVariable("awarenessId") long id) {
		try {
			Awareness awareness = awarenessService.getAwarenessById(id);
			AwarenessDTO awarenessDTO = awarenessHelper.getAwarenessDTO(awareness);
			return new ResponseEntity<>(awarenessDTO, HttpStatus.OK);
		} catch (NoBeanAvailableException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/api/awareness/all", method = RequestMethod.GET)
	public ResponseEntity<List<AwarenessDTO>> getAllAwarenesses() {
		Iterable<Awareness> awarenesses = awarenessService.getAllAwarenesses();
		List<AwarenessDTO> awarenessDTO = awarenessHelper.getAwarenessDTO(awarenesses);
		return new ResponseEntity<>(awarenessDTO, HttpStatus.OK);

	}

	@RequestMapping(value = "/api/awareness", method = RequestMethod.POST)
	public ResponseEntity<AwarenessDTO> saveAwareness(@RequestBody AwarenessDTO awarenessDTO) {
		try {
			Awareness awareness = awarenessHelper.getAwareness(awarenessDTO);
			awareness = awarenessService.saveAwareness(awareness);
			AwarenessDTO awarnessDTO = awarenessHelper.getAwarenessDTO(awareness);
			return new ResponseEntity<>(awarnessDTO, HttpStatus.OK);
		} catch (InvalidBeanException e) {
			LOG.error("Invalid Young Bean : " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/api/awareness/{awarenessId}/young", method = RequestMethod.GET)
	public ResponseEntity<List<YoungDTO>> getAwarenessYoungs(@PathVariable("awarenessId") long id) {
		Iterable<Young> youngs = awarenessService.getAwarenessYoungs(id);
		List<YoungDTO> youngsDTO = youngHelper.getYoungsDTO(youngs);
		return new ResponseEntity<>(youngsDTO, HttpStatus.OK);
	}

}

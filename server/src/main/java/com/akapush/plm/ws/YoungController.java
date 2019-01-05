package com.akapush.plm.ws;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.akapush.plm.domain.dto.YoungDTO;
import com.akapush.plm.domain.exception.InvalidBeanException;
import com.akapush.plm.domain.exception.NoBeanAvailable;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.YoungService;
import com.akapush.plm.util.YoungHelper;

@RestController
public class YoungController {

	@Autowired
	private YoungService youngService;

	@Autowired
	private YoungHelper youngHelper;

	private static final Log LOG = LogFactory.getLog(YoungController.class);

	@RequestMapping(value = "/api/young/{youngId}", method = RequestMethod.GET)
	public ResponseEntity<YoungDTO> getYoungById(@PathVariable("youngId") Long youngId) {

		try {
			Young young = youngService.getYoungById(youngId);
			YoungDTO youngDTO = youngHelper.getYoungDTO(young);
			return new ResponseEntity<YoungDTO>(youngDTO, HttpStatus.OK);
		} catch (NoBeanAvailable e) {
			return new ResponseEntity<YoungDTO>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/api/young", method = RequestMethod.POST)
	public ResponseEntity<YoungDTO> saveYoung(@RequestBody YoungDTO youngDTO) {
		try {
			Young young = youngHelper.getYoung(youngDTO);
			Young result = youngService.saveYoung(young);

			YoungDTO resultDTO = youngHelper.getYoungDTO(result);
			return new ResponseEntity<YoungDTO>(resultDTO, HttpStatus.OK);
		} catch (InvalidBeanException e) {
			LOG.error("Invalid Young Bean : " + e.getMessage());
			return new ResponseEntity<YoungDTO>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/api/youngs", method = RequestMethod.GET)
	public ResponseEntity<List<YoungDTO>> searchYoungs(@RequestParam(name = "search") String search) {
		Iterable<Young> youngs = youngService.searchYoungs(search);
		if (youngs == null) {
			return new ResponseEntity<List<YoungDTO>>(HttpStatus.NOT_FOUND);
		}
		List<YoungDTO> youngsDTO = youngHelper.getYoungsDTO(youngs);
		return new ResponseEntity<List<YoungDTO>>(youngsDTO, HttpStatus.OK);
	}

}

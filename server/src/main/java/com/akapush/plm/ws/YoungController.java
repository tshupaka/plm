package com.akapush.plm.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akapush.plm.domain.dto.YoungDTO;
import com.akapush.plm.domain.exception.NoYoungAvailable;
import com.akapush.plm.domain.model.Young;
import com.akapush.plm.service.YoungService;
import com.akapush.plm.util.YoungHelper;

@RestController
public class YoungController {

	@Autowired
	private YoungService youngService;

	@Autowired
	private YoungHelper youngHelper;

	@RequestMapping(value = "/api/dropdowns", method = RequestMethod.GET)
	public ResponseEntity<YoungDTO> getYoungById(Long youngId) {

		try {
			Young young = youngService.getYoungById(youngId);
			YoungDTO youngDTO = youngHelper.getYoungDTOFromYoung(young);
			return new ResponseEntity<YoungDTO>(youngDTO, HttpStatus.OK);
		} catch (NoYoungAvailable e) {
			return new ResponseEntity<YoungDTO>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/api/dropdonws", method = RequestMethod.POST)
	public ResponseEntity<YoungDTO> saveYoung(@RequestBody YoungDTO youngDTO) {
		Young young = youngHelper.getYoungFromYoungDTO(youngDTO);
		Young result = youngService.saveYoung(young);
		YoungDTO resultDTO = youngHelper.getYoungDTOFromYoung(result);
		return new ResponseEntity<YoungDTO>(resultDTO, HttpStatus.OK);
	}

}

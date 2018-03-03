package org.petka.modules.serviceone;

import javax.validation.Valid;

import org.petka.modules.common.Log;
import org.petka.modules.serviceone.dto.RequestOne;
import org.petka.modules.serviceone.dto.ResponseOne;
import org.petka.modules.serviceone.persistence.Setting;
import org.petka.modules.serviceone.persistence.SettingsRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
public class ServiceOne {

	@Log
	private Logger log;

	@Autowired
	private SettingsRepository settingsRepository;

	@RequestMapping(value = "/serviceone", method = RequestMethod.GET)
	public String serviceOne() {
		log.debug("Hello from ServiceOne");
		Setting setting = settingsRepository.findByName("name");
		log.debug("Setting from database is \"{}\"", setting.getValue());
		log.debug("Setting is \"{}\"", setting);

		return "Hello from ServiceOne : " + setting.getValue();
	}

	@ApiOperation(value = "Find pet by Status", notes = "${ServiceOne.getResOne.notes}")
	@RequestMapping(value = "/getResOne", method = RequestMethod.POST)
	public ResponseOne getResOne(@Valid RequestOne request) {
		ResponseOne resOne = new ResponseOne();
		resOne.setAge(request.getName());
		resOne.setTime(request.getValue());

		return resOne;
	}
}

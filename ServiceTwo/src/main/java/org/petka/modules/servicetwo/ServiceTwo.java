package org.petka.modules.servicetwo;

import org.petka.modules.common.Log;
import org.petka.modules.servicetwo.dto.RequestTwo;
import org.petka.modules.servicetwo.dto.ResponseTwo;
import org.petka.modules.servicetwo.persistence.Setting;
import org.petka.modules.servicetwo.persistence.SettingsRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceTwo {

	@Log
	private Logger log;

	@Autowired
	private SettingsRepository settingsRepository;

	@RequestMapping(value = "/servicetwo", method = RequestMethod.GET)
	public String serviceOne() {
		log.debug("Hello from ServiceTwo");
		Setting setting = settingsRepository.findByName("name");
		log.debug("Setting from database is \"{}\"", setting.getValue());
		return "Hello from ServiceTwo: " + setting.getValue();
	}

	@RequestMapping(value = "/getResTwo", method = RequestMethod.POST)
	public ResponseTwo getResTwo(RequestTwo request) {
		ResponseTwo response = new ResponseTwo();
		response.setAge("Age of ten.");
		return response;
	}
}

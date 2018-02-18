package org.petka.modules.serviceone;

import org.petka.modules.common.Log;
import org.petka.modules.serviceone.persistence.Setting;
import org.petka.modules.serviceone.persistence.SettingsRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceOne {

	@Log
	private Logger log;

	@Autowired
	private SettingsRepository settingsRepository;

	@RequestMapping("/serviceone")
	public String serviceOne() {
		log.debug("Hello from ServiceOne");
		Setting setting = settingsRepository.findByName("name");
		log.debug("Setting from database is \"{}\"", setting.getValue());
		return "Hello from ServiceOne : " + setting.getValue();
	}
}

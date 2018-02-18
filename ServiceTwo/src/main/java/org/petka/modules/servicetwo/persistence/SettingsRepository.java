package org.petka.modules.servicetwo.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("servicetwo")
public interface SettingsRepository extends CrudRepository<Setting, String> {

	public Setting findByName(String name);
}

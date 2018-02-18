package org.petka.modules.serviceone.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("serviceone")
public interface SettingsRepository extends CrudRepository<Setting, String> {

	public Setting findByName(String name);
}

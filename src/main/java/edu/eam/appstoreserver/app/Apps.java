package edu.eam.appstoreserver.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Apps extends JpaRepository<App, Long> {

}

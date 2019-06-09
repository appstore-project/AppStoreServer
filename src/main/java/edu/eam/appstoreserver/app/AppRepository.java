package edu.eam.appstoreserver.app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRepository extends JpaRepository<App, Long> {

}

package edu.eam.appstoreserver.app;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Apps extends JpaRepository<App, Long> {
    @Query(value = "select ap from App ap join ap.memberedCols col where col.id = ?1")
    List<App> findMemberOfCollection(Long colId);
}

package edu.eam.appstoreserver.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApsImageRepo extends JpaRepository<ApsAppImages, Long> {
    @Query(value = "select img from ApsAppImages img join img.app apt where apt.id = ?1")
    List<ApsAppImages> findByAppId(Long appId);
}

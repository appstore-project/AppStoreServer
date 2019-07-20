package edu.eam.appstoreserver.appreview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ApsAppCommentRepo extends JpaRepository<ApsAppComment, Long> {
    @Query(value = "select apc from ApsAppComment apc join apc.app apt where apt.id = ?1")
    List<ApsAppComment> findByAppId(Long appId);
}

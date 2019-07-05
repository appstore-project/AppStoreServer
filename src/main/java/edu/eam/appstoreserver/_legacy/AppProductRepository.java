package edu.eam.appstoreserver._legacy;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AppProductRepository extends JpaRepository<AppProduct, Long> {
    Optional<AppProduct> findByAppCode(Long appCode);
}


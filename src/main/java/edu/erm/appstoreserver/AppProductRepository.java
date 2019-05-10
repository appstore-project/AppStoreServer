package edu.erm.appstoreserver;

import org.springframework.data.jpa.repository.JpaRepository;

interface AppProductRepository extends JpaRepository<AppProduct, Long> {

}


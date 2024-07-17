package com.credmarg.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.data.model.Vendor;
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
	Optional<Vendor> findByEmail(String email);

}

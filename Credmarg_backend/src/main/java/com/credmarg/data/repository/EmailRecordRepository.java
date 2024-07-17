package com.credmarg.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credmarg.data.model.EmailRecord;
@Repository
public interface EmailRecordRepository  extends JpaRepository<EmailRecord, Long>{

}

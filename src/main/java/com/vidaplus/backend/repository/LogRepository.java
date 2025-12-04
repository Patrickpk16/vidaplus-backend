package com.vidaplus.backend.repository;

import com.vidaplus.backend.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<LogEntry, Long> {
}

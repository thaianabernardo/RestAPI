package com.thaiana.restapi.repository;

import com.thaiana.restapi.model.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TerminalRepository extends JpaRepository<Terminal,Integer> {
}

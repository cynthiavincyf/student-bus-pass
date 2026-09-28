package com.buspass.studentbuspass.Repository;

import com.buspass.studentbuspass.entity.BusPassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusPassRepository extends JpaRepository<BusPassEntity, Long> {
}
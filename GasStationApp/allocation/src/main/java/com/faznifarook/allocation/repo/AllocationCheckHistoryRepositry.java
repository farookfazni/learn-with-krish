package com.faznifarook.allocation.repo;

import com.faznifarook.allocation.entity.AllocationCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

// Allocation Repo Which Connects Spring JPA
// Here We get the Allocation Class as a <>
public interface AllocationCheckHistoryRepositry
        extends JpaRepository<AllocationCheckHistory,Long> {
}

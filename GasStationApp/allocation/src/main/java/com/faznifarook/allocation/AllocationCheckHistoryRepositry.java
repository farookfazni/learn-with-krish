package com.faznifarook.allocation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AllocationCheckHistoryRepositry
        extends JpaRepository<AllocationCheckHistory,Long> {
}

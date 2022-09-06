package com.faznifarook.dispatch;

import com.faznifarook.dispatch.entity.Dispatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DispatchRepository extends JpaRepository<Dispatch,Integer> {
}

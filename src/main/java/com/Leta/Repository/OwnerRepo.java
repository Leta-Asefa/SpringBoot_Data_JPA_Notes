package com.Leta.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Leta.Entity.Owner;

public interface OwnerRepo extends JpaRepository<Owner, Long> {

}

package io.swagger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {}
// This interface extends JpaRepository, which provides CRUD operations for the Pet entity.
// The Pet entity is identified by a Long type ID.
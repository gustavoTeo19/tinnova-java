package io.github.gustavoteo19.tinovavehiclesbackend.repositories;

import io.github.gustavoteo19.tinovavehiclesbackend.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Integer> {

}

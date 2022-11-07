package io.github.gustavoteo19.tinovavehiclesbackend.services;

import io.github.gustavoteo19.tinovavehiclesbackend.models.VehicleModel;
import io.github.gustavoteo19.tinovavehiclesbackend.repositories.VehicleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleService {
    final VehicleRepository vehicleRepository;
    private final EntityManager em;

    public VehicleService(VehicleRepository vehicleRepository, EntityManager em) {
        this.vehicleRepository = vehicleRepository;
        this.em = em;
    }

    @Transactional
    public VehicleModel save(VehicleModel vehicleModel){
        return vehicleRepository.save(vehicleModel);
    }

    public Page<VehicleModel> findAll(Pageable pageable) {
        return vehicleRepository.findAll(pageable);
    }


    public Optional<VehicleModel> findById(Integer id) {
        return vehicleRepository.findById(id);
    }
    @Transactional
    public void delete(VehicleModel vehicleModel) {
        vehicleRepository.delete(vehicleModel);
    }

    public List<VehicleModel> getVehicles(String marca, Integer ano, String cor){
        if(marca != null && ano != null && cor != null){
           return vehicleRepository.findAll();
        }
        String query = "select V from tb_vehicles as V ";
        String condicao = "where";
        if(marca != null) {
            query += condicao + " V.marca = :marca";
            condicao = " and ";
        }

        if(ano != null) {
            query += condicao + " V.ano = :ano";
            condicao = " and ";
        }

        if(cor != null) {
            query += condicao + " V.cor = :cor";
        }

        var q = em.createQuery(query, VehicleModel.class);

        if(marca != null) {
            q.setParameter("marca", marca);
        }

        if(ano != null) {
            q.setParameter("ano", ano);
        }

        if(cor != null) {
            q.setParameter("cor", cor);
        }

        return q.getResultList();
    }
}

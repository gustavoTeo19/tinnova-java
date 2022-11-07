package io.github.gustavoteo19.tinovavehiclesbackend.controllers;

import io.github.gustavoteo19.tinovavehiclesbackend.dtos.VehicleDTO;
import io.github.gustavoteo19.tinovavehiclesbackend.helpers.NullAwareBeanUtilsBean;
import io.github.gustavoteo19.tinovavehiclesbackend.models.VehicleModel;
import io.github.gustavoteo19.tinovavehiclesbackend.services.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/veiculos")
@Api(value = "API REST CRUD de veículos")
public class VehicleController {
    final VehicleService vehicleService;
    private NullAwareBeanUtilsBean beanUtilsBean;

    public VehicleController(VehicleService vehicleService, NullAwareBeanUtilsBean beanUtilsBean) {
        this.vehicleService = vehicleService;
        this.beanUtilsBean = beanUtilsBean;
    }

    @PostMapping
    @ApiOperation(value = "Cria um veículo")
    public ResponseEntity<Object> saveVehicle(@RequestBody @Valid VehicleDTO vehicleDTO){
        VehicleModel vehicleModel = new VehicleModel();
        BeanUtils.copyProperties(vehicleDTO, vehicleModel);
        vehicleModel.setCreated(LocalDateTime.now(ZoneId.of("UTC")));
        vehicleModel.setUpdated(LocalDateTime.now(ZoneId.of("UTC")));
        vehicleModel.setVendido(false);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleModel));
    }

//    @GetMapping
//    public ResponseEntity<Page<VehicleModel>> getAllVehicles(@PageableDefault(page = 0, size = 10, sort = "id",
//            direction = Sort.Direction.ASC) Pageable pageable){
//        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.findAll(pageable));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneVehicle(@PathVariable(value = "id") Integer id){
        Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
        if(!vehicleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicleModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVehicle(@PathVariable(value = "id") Integer id){
        Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
        if(!vehicleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }
        vehicleService.delete(vehicleModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Vehicle deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVehiclePut(@PathVariable(value = "id") Integer id, @RequestBody @Valid VehicleDTO vehicleDTO){
        Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
        if(!vehicleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }
        VehicleModel vehicleModel = vehicleModelOptional.get();
        BeanUtils.copyProperties(vehicleDTO, vehicleModel);
        vehicleModel.setId(id);
        vehicleModel.setUpdated(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleModel));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateVehiclePatch(@PathVariable(value = "id") Integer id, @RequestBody VehicleDTO vehicleDTO) throws InvocationTargetException, IllegalAccessException{
        Optional<VehicleModel> vehicleModelOptional = vehicleService.findById(id);
        if(!vehicleModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
        }
        VehicleModel vehicleModel = vehicleModelOptional.get();
        beanUtilsBean.copyProperties(vehicleModel, vehicleDTO);
        vehicleModel.setUpdated(LocalDateTime.now(ZoneId.of("UTC")));
        System.out.println(vehicleModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.save(vehicleModel));
    }
    @GetMapping
    public ResponseEntity<Object> getVehicles(@RequestParam(value="marca", required= false) String marca,
                                              @RequestParam(value="ano", required = false) Integer ano,
                                              @RequestParam(value="cor", required = false) String cor){

        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicles(marca, ano, cor));

    }

}

package com.example.sergio3.web;

import com.example.sergio3.model.Machine;
import com.example.sergio3.services.MachineServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Machine")//ojo aqui con el nombre.
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
//Este @CrossOrigin permite que se ejecuten esos metodos desde cualquier url desconocida (es por prevencion)
public class MachineController {
    @Autowired
    private MachineServices servicio;
    @GetMapping("/all")//Indica a Spring que es una peticion de tipo GET
    public List<Machine> getMachine(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Machine> getMachine(@PathVariable("ID") int machineId) {return servicio.getMachine(machineId);}

    @PostMapping("/save")// Indica a Spring que es una peticion de tipo POST
    @ResponseStatus(HttpStatus.CREATED)//Este indica el codigo de respuesta fue exitoso, es decir es lo mismo que en oracle cuando colocambomos :status_code 201
    public Machine save(@RequestBody Machine machine) {
        return servicio.save(machine);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine) {
        return servicio.update(machine);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int machineId) {
        return servicio.deleteMachine(machineId);
    }

}



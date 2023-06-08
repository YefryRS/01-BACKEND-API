package com.api.rest.app.controller;

import com.api.rest.app.model.Empleado;
import com.api.rest.app.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping
    public Empleado create(@RequestBody Empleado empleado) {
        return empleadoService.saveEmpleado(empleado);
    }

    @GetMapping
    public List<Empleado> readAll() {
        return empleadoService.getEmpleado();
    }
    @GetMapping("/{id}")
    public Empleado readById(@PathVariable int id) {
        return empleadoService.findByIdEmpleado(id);
    }

    @PutMapping
    public Empleado update(@RequestBody Empleado empleado) {
        return empleadoService.updateEmpleado(empleado);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        empleadoService.deleteEmpleado(id);
    }


}

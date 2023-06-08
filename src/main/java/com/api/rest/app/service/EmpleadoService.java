package com.api.rest.app.service;

import com.api.rest.app.model.Empleado;
import com.api.rest.app.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public List<Empleado> getEmpleado() {
        return empleadoRepository.getAllProductos();
    }

    public Empleado findByIdEmpleado(int id) {
        return empleadoRepository.findById(id);
    }

    public Empleado updateEmpleado(Empleado empleado) {
        return empleadoRepository.update(empleado);
    }

    public void deleteEmpleado(int id) {
        empleadoRepository.delete(id);
    }


}

package com.api.rest.app.repository;

import com.api.rest.app.model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpleadoRepository {

    private List<Empleado> empleados = new ArrayList<>();

    // Leer
    public List<Empleado> getAllProductos() {
        return empleados;
    }

    public Empleado findById(int id) {
        for (int i = 0; i < empleados.size(); i++) {
            if(empleados.get(i).getId() == id) {
                return empleados.get(i);
            }
        }
        return null;
    }

    // Crear
    public Empleado save(Empleado e) {
        Empleado empleado = new Empleado();

        empleado.setApellido(e.getApellido());
        empleado.setEdad(e.getEdad());
        empleado.setId(e.getId());
        empleado.setNombre(e.getNombre());
        empleado.setEmail(e.getEmail());
        empleado.setSueldo(e.getSueldo());
        empleado.setAñosExperiencia(e.getAñosExperiencia());
        empleado.setTelefono(e.getTelefono());

        empleados.add(e);
        return empleado;
    }

    // Eliminar
    public void delete(Integer id){
        empleados.removeIf(x -> x.getId() == id);
    }

    // Actualizar
    public Empleado update(Empleado empleado) {

        int idIndex = 0;
        int id = 0;

        for (int i = 0; i < empleados.size(); i++) {
            if(empleados.get(i).getId() == empleado.getId()) {
                id = empleado.getId();
                idIndex = i;
                break;
            }
        }

        Empleado empleado1  = new Empleado();
        empleado.setId(id);

        empleado1.setApellido(empleado.getApellido());
        empleado1.setEdad(empleado.getEdad());
        empleado1.setNombre(empleado.getNombre());
        empleado1.setEmail(empleado.getEmail());
        empleado1.setSueldo(empleado.getSueldo());
        empleado1.setAñosExperiencia(empleado.getAñosExperiencia());
        empleado1.setTelefono(empleado.getTelefono());

        empleados.set(idIndex,empleado);
        return empleado1;

    }


}

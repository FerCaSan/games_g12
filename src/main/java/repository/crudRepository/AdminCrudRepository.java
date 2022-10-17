package repository.crudRepository;

import model.Admin;
import org.springframework.data.repository.CrudRepository;

//Primer argumento, clase que vamos a representar u operar con el repositorio
//Sdo, tipo de dato de la llave primaria de esa clase
public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {
}

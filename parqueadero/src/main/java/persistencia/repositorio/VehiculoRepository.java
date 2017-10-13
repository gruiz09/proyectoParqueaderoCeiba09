package persistencia.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import persistencia.entidad.VehiculoEntity;
 
@Repository("vehiculoJpaRepository")
public interface VehiculoRepository extends MongoRepository <VehiculoEntity, Serializable>{
	 
	public abstract VehiculoEntity findByPlaca(String placa);
	public abstract List<VehiculoEntity> findByPlacaOrderByPlaca(String placa);

	
}

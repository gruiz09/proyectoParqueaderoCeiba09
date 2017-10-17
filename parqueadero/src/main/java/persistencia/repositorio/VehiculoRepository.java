package persistencia.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import persistencia.entidad.VehiculoEntity;
 
@Repository("vehiculoJpaRepository")
public interface VehiculoRepository extends MongoRepository <VehiculoEntity, String>{
	 
	public abstract VehiculoEntity findByPlaca(String placa);
	public abstract List<VehiculoEntity> findByPlacaOrderByPlaca(String placa);
	public VehiculoEntity findById(String id);
}

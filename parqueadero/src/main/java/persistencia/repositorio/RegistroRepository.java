package persistencia.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import persistencia.entidad.RegistroEntity;;

@Repository("registroJpaRepository")
public interface RegistroRepository extends MongoRepository <RegistroEntity, String> {
	
		public RegistroEntity findById(String id);
		
}

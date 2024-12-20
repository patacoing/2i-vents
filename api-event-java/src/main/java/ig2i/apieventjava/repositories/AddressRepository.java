package ig2i.apieventjava.repositories;

import ig2i.apieventjava.entities.AddressEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface AddressRepository extends ReactiveCrudRepository<AddressEntity, String> {
}

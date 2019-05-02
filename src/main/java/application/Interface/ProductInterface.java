package application.Interface;

import org.springframework.data.repository.CrudRepository;
import application.Entities.ProductEntity;

public interface ProductInterface extends CrudRepository<ProductEntity, Integer> {


}

package application.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.Entities.ProductEntity;
import application.Interface.ProductInterface;
@Service
public class ProductServices {
	@Autowired
	public ProductInterface IF;

	public List<ProductEntity> getListAllUsers() {
		try {
			return (List<ProductEntity>) IF.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<ProductEntity>();
		}
	}

	public Optional<ProductEntity> findOne(int id) {
		return IF.findById(id);
	}

}

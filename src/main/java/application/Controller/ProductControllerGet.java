package application.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import application.Entities.ProductEntity;
import application.Services.ProductServices;
@RestController
@RequestMapping(value = "/api")
public class ProductControllerGet {
	@Autowired
	public ProductServices services;
	

	@GetMapping("/getall")
	public List<ProductEntity> getListAll() {
		return services.getListAllUsers();
	}

	@GetMapping(value = "/product/{id}")
	@ResponseBody
	public BaseApiResult detailUser(@PathVariable int id) {
		DataApiResult result = new DataApiResult();
		try {
			Optional<ProductEntity> existUser = services.findOne(id);
			if (existUser == null) {
				result.setSuccess(false);
				result.setMessage("can't find this User");
				System.out.println(existUser);
			} else {
				result.setSuccess(true);
				result.setMessage("success");
				result.setData(existUser);
			}
		} catch (Exception e) {
			result.setSuccess(false);
			result.setMessage(e.getMessage());
		}
		return result;
	}

}

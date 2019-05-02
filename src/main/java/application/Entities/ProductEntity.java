package application.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "product")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "category")
	private String category;

	@Column(name = "category_name")
	private String category_name;

	public ProductEntity() {
		super();
	}

	public ProductEntity(int id, String name, String category, String category_name) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.category_name = category_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", category=" + category + ", category_name=" + category_name
				+ "]";
	}

}

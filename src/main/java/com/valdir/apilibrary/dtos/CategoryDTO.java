package com.valdir.apilibrary.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.valdir.apilibrary.domain.Category;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotNull(message = "O campo nome é obrigatório")
	@Size(min = 4, max = 40, message = "Tamanho minímo é 4 caracteres e máximo 40 caracteres")
	private String name;

	public CategoryDTO() {
		super();
	}

	public CategoryDTO(Category obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDTO other = (CategoryDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

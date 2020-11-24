package com.valdir.apilibrary.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;

	private List<Book> books = new ArrayList<>();

	public Category() {
		super();
	}

	public Category(Integer id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
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
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

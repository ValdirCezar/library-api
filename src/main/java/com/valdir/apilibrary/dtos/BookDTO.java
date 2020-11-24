package com.valdir.apilibrary.dtos;

import java.io.Serializable;

import com.valdir.apilibrary.domain.Book;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String title;

	public BookDTO() {
		super();
	}

	public BookDTO(Book obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		BookDTO other = (BookDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

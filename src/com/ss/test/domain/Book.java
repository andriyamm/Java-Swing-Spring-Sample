package com.ss.test.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Book implements Serializable {

	private static final long serialVersionUID = 6816892260978023089L;
	
	private Integer id;
	private String isbn;
	private String name;
	private String author;
	private Integer pageCount;
	private Date publishDate;

	public Book() {
	}

	public Book(Integer id, String isbn, String name, String autor,
			Integer page_count, Date publishDate) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.name = name;
		this.author = autor;
		this.pageCount = page_count;
		this.publishDate = publishDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		this.author = autor;
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer page_count) {
		this.pageCount = page_count;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(isbn).append(name)
				.append(author).append(pageCount).append(publishDate)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}

		Book rhs = (Book) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj))
				.append(id, rhs.id).append(isbn, rhs.isbn)
				.append(name, rhs.name).append(author, rhs.author)
				.append(pageCount, rhs.pageCount)
				.append(publishDate, rhs.publishDate).isEquals();
	}
	
	@Override
	public String toString(){
		 return new ToStringBuilder(this).
			       append("id", id).
			       append("isbn", isbn).
			       append("name", name).
			       append("author", author).
			       append("pageCount", pageCount).
			       append("publishDate", publishDate).
			       toString();
	}
}

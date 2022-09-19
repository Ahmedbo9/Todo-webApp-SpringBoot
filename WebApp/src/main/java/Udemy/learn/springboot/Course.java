package Udemy.learn.springboot;

public class Course {
	private long id;
	private String name;
	private String autor;

	public Course(long id, String name, String autor) {
		super();
		this.id = id;
		this.name = name;
		this.autor = autor;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", autor=" + autor + "]";
	}

}

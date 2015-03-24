package ar.edu.uai.model;


import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@Access(AccessType.FIELD)
public class Person {

    @Id
    @Column(name = "NAME", nullable = false)
	private String name;

    @Column(name = "AGE", nullable = false)
	private int age;

    public Person(){}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
}

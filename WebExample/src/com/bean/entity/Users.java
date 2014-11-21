package com.bean.entity;

public class Users {
    
    private int id;
    
    private String name;
    
    private String sex;
    
    private int age;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + id;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
	Users other = (Users) obj;
	if (age != other.age)
	    return false;
	if (id != other.id)
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	if (sex == null) {
	    if (other.sex != null)
		return false;
	} else if (!sex.equals(other.sex))
	    return false;
	return true;
    }

    public Users(int id, String name, String sex, int age) {
	super();
	this.id = id;
	this.name = name;
	this.sex = sex;
	this.age = age;
    }

    public Users() {
	super();
    }

    @Override
    public String toString() {
	return "Users [id=" + id + ", name=" + name + ", sex=" + sex + ", age="
		+ age + "]";
    }
}
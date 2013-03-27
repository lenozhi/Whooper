package cn.web.domain;

import java.io.Serializable;

public class Person implements Serializable {

	private static final long serialVersionUID = -8333984959652704635L;

	private Integer id;
	private String firstName;
	private String lastName;
	private String currency;
	private Double money;
	private Person friend;
	
	
	public Person getFriend() {
		return friend;
	}

	public void setFriend(Person friend) {
		this.friend = friend;
	}

	public Person(){}
	
	//"123456", "李�?", "123", "成都�?, "1", 23
	public Person(Integer id,String name){
		this.id = id ;
		this.firstName = name;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}

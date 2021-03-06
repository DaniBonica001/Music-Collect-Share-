package model;
public class User{
	//Atributes
	private String username;
	private String password;
	private int age;
	private Category category;
	//Method
	public User(String name,String pass,int uAge){
		username=name;
		password=pass;
		age=uAge;
		category=Category.NEWBIE;
	}

	//Setters and getters
	//Set and get of username
	public void setUserName(String username){
		this.username=username;
	}
	public String getUserName(){
		return username;
	}
	//Set and get of password
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	//Set and get of age
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	//Set and get of category;
	public void setCategory(Category category){
		this.category=category;
	}
	public Category getCategory(){
		return category;
	}
	
	/**
	* <b>Name: toString</b>
	* This method allow to show all the information of a user.<br>
	* <b>Pre:</b>The user must already been created. username!="", password!= "", age!= null, category!=null.<br>
	* <b>Post:</b>The information of the user was shown successfully.
	* @return The information of the user.
	*/
	public String toString(){
		return "\n"+
				"*************  User **************"+
				"\n**UserName: "+username+
				"\n**Age: "+age+
				"\n**Category: "+category+
				"\n***********************************";			
	}
}
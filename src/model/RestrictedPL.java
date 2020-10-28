package model;
public class RestrictedPL extends Playlist{
	//Atributes 
	private User [] consumers;
	//Methods	
	public RestrictedPL(String name, User[]users){
		super(name);
		consumers=users;
	}


	
}
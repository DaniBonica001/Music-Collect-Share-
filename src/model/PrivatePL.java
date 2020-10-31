package model;
public class PrivatePL extends Playlist{
	//Atribute
	private User owner;
	//Methods
	public PrivatePL(String name,User user){
		super(name);
		owner=user;
	}
	//New
	public boolean verifyUser(String name){
		boolean findUser=false;
		if (owner.getUserName().equalsIgnoreCase(name)){
			findUser=true;
		}
	return findUser;
	}

	public String addSong(User objUser,Song song){
		String message="";
		String name=objUser.getUserName();
		boolean verifyUser= verifyUser(name);

		if (verifyUser==true){
			message=super.addSong(objUser,song);
		}else{
			message="No se ha podido añadir la cancion";
		}

	return message;
	}

	public String toString(){
		return "\n"+
		"**************  Playlist **************"+
		"\n**  Title: "+getName()+
		"\n**  Usuario: "+ owner.getUserName()+
		"\n**  Duration: "+ uploadDuration()+
		"\n**  Genre: "+uploadGenres()+
		"\n***********************************";

	}
	
}
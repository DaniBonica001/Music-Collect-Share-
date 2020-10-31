package model;
public class RestrictedPL extends Playlist{
	//Atributes 
	private User [] consumers;
	//Methods	
	public RestrictedPL(String name, User[]users){
		super(name);
		consumers=users;
	}

	public boolean verifyUser(String name){
		boolean exit=false;
		boolean findUser=false;
		for (int i=0;i<consumers.length && !exit;i++){
			if (consumers[i].getUserName().equalsIgnoreCase(name)){
			findUser=true;
			exit=true;
			}
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

	public String showUsers(){
		String message="";
		for (int i=0;i<consumers.length;i++){
			message+=consumers[i].getUserName()+", ";
		}
	return message;
	}

	public String toString(){
		return "\n"+
		"**************  Playlist **************"+
		"\n**  Title: "+getName()+
		"\n**  Usuarios: "+showUsers()+
		"\n**  Duration: "+ uploadDuration()+
		"\n**  Genre: "+uploadGenres()+
		"\n***********************************";

	}  
	
}
package model;
public class PrivatePL extends Playlist{
	//Relation
	private User owner;
	//Methods
	public PrivatePL(String name,User user){
		super(name);
		owner=user;
	}
	
	/**
	* <b>Name: verifyUser</b><br>
	* This method verify if the user who is adding songs to the playlist has permission to do it.<br>
	* <b>Pre:</b> The owner must be created. owner!=null.<br>
	* <b>Post:</b> The user has been verified. <br>
	* @param name String. Name of the user. name!="".<br>
	* @return findUser boolean. True if the user has permission or false if the user can't add the song.<br>
	*/	
	public boolean verifyUser(String name){
		boolean findUser=false;
		if (owner.getUserName().equalsIgnoreCase(name)){
			findUser=true;
		}
	return findUser;
	}
	/**
	* <b>Name: addSong</b><br>
	* This method allow to add songs to a private playlist. <br>
	* <b>Pre:</b> The playlist must be created.<br>
	* <b>Post:</b> The song has been added to a playlist.<br>
	* @param objUser User. An object from the User class. userName!=null.<br>
	* @param song Song. An object from the Song class. song!=null.<br>
	* @return message String. Message that confirm or deny if the song was added.
	*/
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

	/**
	* <b>Name: toString</b><br>
	* This method allow to show all the information of a private playlist.<br>
	* <b>Pre:</b>The playlist must already been created. <br>
	* <b>Post:</b>The information of the playlist was shown successfully.<br>
	* @return The information of the private playlist.
	*/
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
package model;
public class PublicPL extends Playlist{
	//Atributes 
	private int grade;//podria ser un arreglo con las calificaciones
	//Methods
	public PublicPL(String name){
		super(name);
		grade=0;
	}

	public void setGrade(int grade){
		this.grade=grade;
	}
	public int getGrade(){
		return grade;
	}

	public String addSong(Song song){
		String message=super.addSong(song);
	return message;
	}

	/**
	* <b>Name: toString</b><br>
	* This method allow to show all the information of a public playlist.<br>
	* <b>Pre:</b>The playlist must already been created. <br>
	* <b>Post:</b>The information of the playlist was shown successfully.<br>
	* @return The information of the public playlist.
	*/
	public String toString(){
		return "\n"+
		"**************  Playlist **************"+
		"\n**  Title: "+getName()+		
		"\n**  Duration: "+uploadDuration()+
		"\n**  Genre: "+uploadGenres()+
		"\n**  Calificacion promedio: "+grade+//corregir
		"\n***********************************";

	}


	
}
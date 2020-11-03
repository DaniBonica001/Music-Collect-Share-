package model;
public class PublicPL extends Playlist{
	//Atributes 
	private int grade;//podria ser un arreglo con las calificaciones
	int counter=0;
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

	public int gradePlaylist(int grade){
		grade=super.gradePlaylist(grade);
		counter+=1;
		int average= (int)grade/counter;

	return average;
	}


	public String addSong(Song song){
		String message=super.addSong(song);
	return message;
	}

	/**
	* <b>Name: toString</b>
	* This method allow to show all the information of a public playlist.
	* <b>Pre:</b>The playlist must already been created. 
	* <b>Post:</b>The information of the playlist was shown successfully.
	* @return The information of the public playlist.
	*/
	public String toString(){
		return "\n"+
		"**************  Playlist **************"+
		"\n**  Title: "+getName()+		
		"\n**  Duration: "+uploadDuration()+
		"\n**  Genre: "+uploadGenres()+
		"\n**  Calificacion promedio: "+gradePlaylist(grade)+//corregir
		"\n***********************************";

	}


	
}
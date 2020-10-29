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

	public void gradePlaylist(int grades){
		grade=grades;
	}


	public String addSong(Song song){
		String message=super.addSong(song);
	return message;
	}



	public String toString(){
		return "\n"+
		"**************  Playlist **************"+
		"\n**  Title: "+getName()+		
		"\n**  Duration: "+ getDuration()+
		"\n**  Genre: "+getGenres()+
		"\n**  Calificacion promedio: "+grade+//corregir
		"\n***********************************";

	}


	
}
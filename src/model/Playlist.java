package model;
public class Playlist{
	//Atributes
	private String name;
	private int duration;
	private Genre []genres;
	//Methods
	public Playlist(String nam){
		name=nam;
		duration=0;
		genres=null;
	}
	//Setters and getters
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	//Set and get of duration
	public void setDuration(int duration){
		this.duration=duration;
	}
	public int getDuration(){
		return duration;
	}
	//Set and get of []genres
	public void setGenres(Genre[]genres){
		this.genres=genres;
	}
	public Genre[] getGenres(){
		return genres;
	}

	public String toString(){
		return "\n"+
				"**************  Playlist **************"+
				"\n**  Title: "+name+
				"\n**  Duration: "+ duration+
				"\n**  Genre: "+genres+
				"\n***********************************";

	}

}
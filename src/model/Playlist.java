package model;
public class Playlist{
	//Constants
	public final static int MAX_SONGS=50;
	//Atributes
	private String name;
	private int duration;
	private Song []songs;
	private Genre []genres;
	//Methods
	public Playlist(String nam){
		name=nam;
		duration=0;
		genres=null;
		songs=new Song [Mcs.MAX_SONGS];

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


	public void gradePlaylist(int grade){
	}


	public String addSong(User userName,Song song){
		boolean exit=false;
		String message="";
		for (int i=0;i<songs.length &&!exit;i++){
			if (songs[i]==null){
				songs[i]=song;
				exit=true;
				message="Se ha añadido la cancion correctamente";
			}
		}
		if (exit=false){
			message="El arreglo de canciones esta lleno. No se pueden agregar mas canciones";
		}
	return message;
	}


	public String addSong(Song song){
		boolean exit=false;
		String message="";
		for (int i=0;i<songs.length &&!exit;i++){
			if (songs[i]==null){
				songs[i]=song;
				exit=true;
				message="Se ha añadido la cancion correctamente";
			}
		}
		if (exit=false){
			message="El arreglo de canciones esta lleno. No se pueden agregar mas canciones";
		}
	return message;
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
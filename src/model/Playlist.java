package model;
public class Playlist{
	//Constants
	public final static int MAX_SONGS=50;
	//Atributes
	private String name;
	private int duration;
	private Song []songs;
	private Genre []genres;

	int completeDuration=0;
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


	public int gradePlaylist(int grade){
		return grade;
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


	public String uploadDuration(){
		int segundos,min,horas,seg;
		String message="";
		for (int i=0;i<songs.length;i++){
			if (songs[i]!=null){
				completeDuration+=songs[i].getDuration();
			}
		}

		if (completeDuration<60){
			message=completeDuration+" segundos";

		} else{
		  	segundos=(int)completeDuration%60;
		  	seg=(int)completeDuration/60;
		  	min=seg%60;
		  	horas=seg/60;
		  	message=horas+" horas "+min+" minutos "+segundos+" segundos";
		}

	return message;
	}


	public String uploadGenres(){
		String message="";
		for (int i=0;i<songs.length;i++){
			if (songs[i]!=null){
				message+=songs[i].getGenre()+",";
			}
		}
	return message;
	}
	
}
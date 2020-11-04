package model;
public class Playlist{
	//Constants
	public final static int MAX_SONGS=50;
	//Atributes
	private String name;
	private int duration;
	private Genre[] genres;
	
	//Relations
	private Song []songs;	

	int completeDuration=0;
	//Methods
	public Playlist(String nam){
		name=nam;
		duration=0;
		genres=new Genre [7];
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
	public void setGenres(Genre[] genres){
		this.genres=genres;
	}
	public Genre[] getGenres(){
		return genres;
	}

	/**
	* <b>Name: addSong</b><br>
	* This method allow to add songs to a playlist without care if is a private or restricted playlist.<br>
	* <b>Pre:</b> The playlist must be created.<br>
	* <b>Post:</b> The song has been added to a playlist.<br>
	* @param userName User. An object from the User class. userName!=null.<br>
	* @param song Song. An object from the Song class. song!=null.<br>
	* @return message String. Message that confirm or deny if the song was added.
	*/
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

	/**
	* <b>Name: addSong</b><br>
	* This method allow to add songs to a public playlist.<br>
	* <b>Pre:</b> The playlist must be created.<br>
	* <b>Post:</b> The song has been added to a public playlist.<br>
	* @param song Song. An object from the Song class. song!=null.<br>
	* @return message String. Message that confirm or deny if the song was added.
	*/
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

	/**
	* <b>Name: uploadDurartion</b>
	* This method allow to calculate the complete duration of the playlist and become it from seconds to hours, minutes and seconds.<br>
	* <b>Pre:</b> The songs array of the playlist must be initialized. songs!=null.<br>
	* <b>Post:</b> The duration of the playlist was calculated and it was become it from seconds to hours, minutes and seconds.<br>
	* @return message String. Variable with the duration of the song in hours, minutes and seconds.
	*/
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

	/**
	* <b>Name: uploadGenres</b>
	* This method allow to upload all the genres from a playlist.<br>
	* <b>Pre:</b> The songs array of the playlist must be initialized. songs!=null.<br>
	* <b>Post:</b> The genres of the playlist was uploaded.<br>
	* @return message String. Variable with the genres of the playlist.
	*/
	public String uploadGenres(){
		
		String message="";
		for (int i=0;i<songs.length;i++){
			if (songs[i]!=null){
				boolean exit=false;
				for (int j=0;j<genres.length && !exit;j++){					

					if (genres[j]==null){
						genres[j]=songs[i].getGenre();
						exit=true;
					}else if (genres[j]!=null && songs[i].getGenre().name().equalsIgnoreCase(genres[j].name())){
						exit=true;						
					}
				}
				
			}
		}


		for (int x=0;x<genres.length;x++){
			if (genres[x]!=null){
				message+=genres[x].name()+",";
			}
		}
	return message;
	}
	
}
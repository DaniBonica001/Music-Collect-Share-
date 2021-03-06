package  model;
public class Song{
	//Atributes
	private String title;
	private String singer;
	private String releaseDate;
	private int duration; //metodo para convertir a horas minutos y segundos 
	private Genre genre;
	//Methods
	public Song(String sTitle, String band, String date, int time, Genre type){
		title=sTitle;
		singer=band;
		releaseDate=date;
		duration=time;
		genre=type;
	}
	//Setters and getters
	//Set and get of title
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	//Set and get of singer
	public void setSinger(String singer){
		this.singer=singer;
	}
	public String getSinger(){
		return singer;
	}
	//Set and get of releaseDate
	public void setReleaseDate(String releaseDate){
		this.releaseDate=releaseDate;
	}
	public String getReleaseDate(){
		return releaseDate;
	}
	//Set and get of duration
	public void setDuration(int duration){
		this.duration=duration;
	}
	public int getDuration(){
		return duration;
	}
	//Set and get of genre
	public void setGenre(Genre genre){
		this.genre=genre;
	}
	public Genre getGenre(){
		return genre;
	}
	
	/**
	* <b>Name: uploadDurartion</b>
	* This method allow to become the duration of a song from seconds to hours, minutes and seconds. <br>
	* <b>Post:</b> The duration of the song was changed from second to hours, minutes and seconds successfully.<br>
	* @param duration int. Variable with the duration of a song in seconds.duration!=null.<br>
	* @return message String. Variable with the duration of the song in hours, minutes and seconds.
	*/
	public String uploadDuration(int duration){
		String message="";
		int segundos,min,horas,seg;
		  if (duration<=60){
		  		message=duration+"segundos";
		  }else{
		  	segundos=(int)duration%60;
		  	seg=(int)duration/60;
		  	min=seg%60;
		  	horas=seg/60;
		  	message=horas+" horas "+min+" minutos "+segundos+" segundos";
		  }
	return message;
	}

	/**
	* <b>Name: toString</b>
	* This method allow to show all the information of a song.<br>
	* <b>Pre:</b>The song must already been created. title!="", singer!= "", releaseDate!="", duration!=null, genre!=null.<br>
	* <b>Post:</b>The information of the song was shown successfully.<br>
	* @return The information of the song.
	*/
	public String toString(){
		return "\n"+
				"**************  Song **************"+
				"\n**  Title: "+title+
				"\n**  Artist: "+singer+
				"\n**  Duration: "+uploadDuration(duration)+
				"\n**  Genre: "+genre+
				"\n***********************************";

	}
}
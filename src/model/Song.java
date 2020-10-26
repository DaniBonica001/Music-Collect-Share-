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
	public String toString(){
		return "**************  Song **************"+
				"\n**  Title: "+title;
				"\n**  Artist: "+singer;
				"\n**  Duration: "+ duration;
				"\n**  Genre: "+genre+
				"\n***********************************";

	}
}
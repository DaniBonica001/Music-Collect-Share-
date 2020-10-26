package model;
public class Mcs{
	//Consants
	public final static int MAX_PLAYLIST=20;
	public final static int MAX_SONGS=50;
	public final static int MAX_USERS=10;
	public final int[]counter;
	//Relations
	public User []users;
	public Song []pool;
	public Playlist []playlists;

	public Mcs(){
		users= new User[MAX_USERS];
		pool= new Song [MAX_SONGS];
		playlists= new Playlist[MAX_PLAYLIST];
		counter= new int[MAX_USERS];
	}


	public User findUser(String name){
		User objUser=null;
		boolean exit=false;
		for (int i=0;i<users.length && !exit;i++){
			if(users[i]!=null && users[i].getUserName().equalsIgnoreCase(name)){
				exit=true;
				objUser=users[i];
			}
		}
	return objUser;
	}

	public Song findSong(String name,String singer){
		Song objSong=null;
		boolean exit=false;
		for (int i=0;i<pool.length && !exit;i++){
			if (pool[i]!=null && pool[i].getTitle().equalsIgnoreCase(name)){
				if (pool[i].getSinger().equalsIgnoreCase(singer)){
					exit=true;
					objSong=pool[i];
				}
			}
		}
	return objSong;
	}

	public String createUser(String name, String password,int age){
		String message="";
		boolean exit=false;
		User findUser=findUser(name);
		if (findUser!=null){
			message="Ya se ha registrado este usuario";
		}else{
			for (int i=0;i<users.length && !exit;i++){
				if (users[i]==null){
					exit=true;
					users[i]= new User(name,password,age);
					message="Se ha registrado el usuario exitosamente";
				}				
			}
		}
	return message;
	}

	public String createSong(String name,String title,String singer,String date,int time,int genre){
		String message="";
		String m="Se registro correctamente el genero";
		boolean exit=false;
		User findUser=findUser(name);
		Song findSong=findSong(title,singer);
		if (findUser!=null){
			updateCategory(name);

			if (findSong!=null){
			message="Error. La cancion puede tener el mismo titulo pero no el mismo artista. Ya esta creada.";
			}else{
				for (int i=0;i<pool.length && !exit;i++){
					if (pool[i]==null){
						if (genre==1){
							pool[i]= new Song (title,singer,date,time,Genre.ROCK);
						}else if (genre==2){
							pool[i]= new Song (title,singer,date,time,Genre.HIPHOP);
						}else if (genre==3){
							pool[i]= new Song (title,singer,date,time,Genre.MUSICA_CLASICA);
						}else if (genre==4){
							pool[i]= new Song (title,singer,date,time,Genre.REGGAE);
						}else if (genre==5){
							pool[i]= new Song (title,singer,date,time,Genre.SALSA);
						}else if (genre==6){
							pool[i]= new Song (title,singer,date,time,Genre.METAL);
						}else if (genre==7){
							pool[i]= new Song (title,singer,date,time,Genre.POP);
						}else{
							m="Error. No se encontro el genero";
						}

					exit=true;
					message=name+" ha registrado la cancion en el pool de canciones";
					}
				}
			}		

			if (exit==false){
				message="Error. El arreglo de canciones ya esta lleno";
			}


		}else{
			message="No se encontro el usuario";
		}
	return message+" Y "+m;
	}

	public String updateCategory(String name){
		String message="";
		int amount=0;
		boolean exit=false;
		for (int i=0;i<users.length && !exit;i++){
			if (users[i].getUserName().equalsIgnoreCase(name)){
				amount=counter[i]+1;				
			}

			if (amount >3 && amount<10){
				message="Se ha actualizado su categoria a: Little contributor";
				users[i].setCategory(Category.LITTLE_CONTRIBUTOR);			
			}else if (amount>=10 && amount<30){
				message="Se ha actualizado su categoria a: Mild contributor";
				users[i].setCategory(Category.MILD_CONTRIBUTOR);			
			}else if (amount>=30){
				message="Se ha actualizado su categoria a: Star contributor";
				users[i].setCategory(Category.STAR_CONTRIBUTOR);			
			}	
				
		}
	return message;
	}

	public String showUsers(){
		String message="";
		for (int i=0;i<users.length;i++){
			if (users!=null){
				message+=users[i].toString();
			}		
		}
						
	return message;
	}


	public String showPool(){
		String message="";
		for (int i=0;i<pool.length;i++){
			if (pool!=null){
				message+=pool[i].toString();
			}		
		}						
	return message;
	}

}
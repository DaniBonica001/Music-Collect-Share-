package model;
public class Mcs{
	//Constants
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

	public Playlist findPlaylist(String name){
		Playlist objPlaylist=null;
		boolean exit=false;
		for (int i=0;i<playlists.length;i++){
			if (playlists[i]!=null && playlists[i].getName().equalsIgnoreCase(name)){
				objPlaylist=playlists[i];
				exit=true;
			}
		}
	return objPlaylist;
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
		User objFindUser=null;
		for (int i=0;i<users.length && !exit;i++){
			if (users[i]!=null && users[i].getUserName().equalsIgnoreCase(name)){
				objFindUser=users[i];
				counter[i]+=1;
				amount= counter[i];
				exit=true;
			}			
		}
		if (amount >3 && amount<10){
			message="Se ha actualizado su categoria a: Little contributor";
			objFindUser.setCategory(Category.LITTLE_CONTRIBUTOR);				
		}else if (amount>=10 && amount<30){
			message="Se ha actualizado su categoria a: Mild contributor";
			objFindUser.setCategory(Category.MILD_CONTRIBUTOR);				
		}else if (amount>=30){
			message="Se ha actualizado su categoria a: Star contributor";
			objFindUser.setCategory(Category.STAR_CONTRIBUTOR);					
		}	
	return message;
	}

	public String createPlaylist(String name, String user){
		User objFindUser=findUser(user);
		Playlist findPlaylist=findPlaylist(name);
		String message="";
		boolean exit=false;

		if (objFindUser!=null){

			if (findPlaylist!=null){
				message="Error. Ya existe una playlist con ese nombre";

			}else {

				for (int i=0;i<playlists.length && !exit;i++){
					if (playlists[i]==null){
						playlists[i]= new PrivatePL(name,objFindUser);
						exit=true;
						message="Se ha creado la playlist";
					}
				}

				if (exit==false){
					message="No se pueden crear mas playlists";
				}
			}

		}else{
			message="El usuario ingresado no existe y no se puede crear la playlist";
		}			

		
	return message;
	}

	public String createPlaylist(String name){
		Playlist findPlaylist=findPlaylist(name);
		String message="";
		boolean exit=false;

		if (findPlaylist!=null){
			message="Error. Ya existe una playlist con ese nombre";
		}else {
			for (int i=0;i<playlists.length && !exit;i++){
				if (playlists[i]==null){
					playlists[i]= new PublicPL(name);
					exit=true;
					message="Se ha creado la playlist";
				}
			}		
			
		}
	return message;
	}
	
	public String createPlaylist(String name,int amount, String[] owners){
		User []adminUsers= new User [amount];
		String message="";
		User objFindUser=null;
		for (int i=0;i<owners.length;i++){
			objFindUser=findUser(owners[i]);
			if (objFindUser!=null){
				adminUsers[i]=objFindUser;
				message="Usuario encontrado";
			}else{
				message="El usuario no existe";
			}
		}

		Playlist findPlaylist=findPlaylist(name);		
		boolean exit=false;

		if (findPlaylist!=null){
			message="Error. Ya existe una playlist con ese nombre";
		}else {
			if (objFindUser!=null){
				for (int i=0;i<playlists.length && !exit;i++){
					if (playlists[i]==null){
						playlists[i]= new RestrictedPL(name,adminUsers);
						exit=true;
						message="Se ha creado la playlist";
					}
				}
			}else{
				message="El usuario ingresado no existe y no se puede crear la playlist";
			}
			
		}
	return message;
	}



	public void gradePlaylist(String playlistName,int grade){
		Playlist objPlaylist=findPlaylist(playlistName);
		if (objPlaylist!=null){
			objPlaylist.gradePlaylist(grade);			
		}

	}


	public String addSong(String playlist,String userName, String song,String singer){
		Playlist objPlaylist=findPlaylist(playlist);
		User objUser=findUser(userName);
		Song objSong=findSong(song,singer);
		String message="";

		if (objPlaylist==null || objUser==null || objSong==null){

			if (objPlaylist==null){
				message+="Error. No se ha encontrado la playlist ingresada";
			}

			if (objUser==null){
				message+="Error. No se ha encontrado el usuario";			
			}

			if (objSong==null){
				message+="Error.No se ha encontrado la cancion";
			}

		}else{
			objPlaylist.addSong(objUser,objSong);
			message="Se registrara la cancion";
		}
	return message;
	}
	





























































































	

	public String showUsers(){
		String message="";
		for (int i=0;i<users.length;i++){
			if (users[i]!=null){
				message+=users[i].toString();
			}		
		}
						
	return message;
	}


	public String showPool(){
		String message="";
		for (int i=0;i<pool.length;i++){
			if (pool[i]!=null){
				message+=pool[i].toString();
			}		
		}						
	return message;
	}

	public String showPlaylists(){
		String message="";
		for (int i=0;i<playlists.length;i++){
			if (playlists[i]!=null){
				message+=playlists[i].toString();
			}		
		}						
	return message;
	}

}
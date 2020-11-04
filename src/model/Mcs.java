package model;
public class Mcs{
	//Constants
	public final static int MAX_PLAYLIST=20;
	public final static int MAX_SONGS=50;
	public final static int MAX_USERS=10;
	//Atributes
	private int[]counter;
	private int counterGrades=0;
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

	/**
	* <b>Name: findUser</b><br>
	* This method find a user. This method is to avoid that a user will be created twice.<br>
	* <b>Pre:</b> The users array must be initialized. users!=null<br>
	* <b>Post:</b><br>The user was or wasn't found successfully.<br>
	* @param name String. Name of the user. name!="".<br>
	* @return objUser User. If the method find the user, it will return it because you can't create the same user twice.<br>
	* But, if the method doesn't find the user, it wouldn't return anything, it would be null and you can create the user.
	*/	
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

	/**
	* <b>Name: findSong</b><br>
	* This method find a song. This method is to avoid that a song will be created twice.<br>
	* <b>Pre:</b> The pool array must be initialized. pool!=null<br>
	* <b>Post:</b><br>The song was or wasn't found successfully.<br>
	* @param name String. Name of the song. name!="".<br>
	* @param singer String. Name of the singer or the band. singer!="".<br>
	* @return objSong Song. If the method find the song, it will return it because you can't create the same song twice.<br>
	* But, if the method doesn't find the song, it wouldn't return anything, it would be null and you can create the song.
	*/	
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

	/**
	* <b>Name: findPlaylist</b><br>
	* This method find a playlist. This method is to avoid that a playlist will be created twice.<br>
	* <b>Pre:</b> The playlists array must be initialized. playlists!=null<br>
	* <b>Post:</b><br>The playlist was or wasn't found successfully.<br>
	* @param name String. Name of the playlist. name!="".<br>
	* @return objPlaylist Playlist. If the method find the playlist, it will return it because you can't create the same playlist twice.<br>
	* But, if the method doesn't find the playlist, it wouldn't return anything, it would be null and you can create the playlist.
	*/	
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

	/**
	* <b>Name: createUser</b><br> 
	* This method allow to create an user with all his/her information and save in the users array.<br>
	* <b>Pre:</b> The users array must be created.<br>
	* <b>Post:</b> The user was created successfully.<br>
	* @param name String. Name of the user. name!="".<br>
	* @param password String. Password of the user. password!="".<br>
	* @param age int. Age of the user. age!=0.<br>
	* @return message String. Message that confirm or deny if the user was created.
	*/
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
			if (exit==false){
				message="Error. No se pueden crear mas usuarios";
			}
		}
	return message;
	}

	/**
	* <b>Name: createSong</b><br>
	* This method allow to create a song with all its information and save it in the pool array.<br>
	* <b>Pre:</b> The pool array must be created.<br>
	* <b>Post:</b> The song was created successfully.<br>
	* @param name String. Name of the user who added the song. name!="".<br>
	* @param title String. Name of the song. title!="".<br>
	* @param singer String. Name of the singer or the band. singer!="".<br>
	* @param date String. The release date of the song. date!="".<br>
	* @param time int. Duration of the song in seconds. time!=0.<br>
	* @param genre int. Option of the genre of the song. genre mayor o igual a 1 Y genre menor o igual a 7<br>
	* @return message String. Message that confirm or deny if the song was created. 
	*/
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

	/**
	* <b>Name: updateCategory</b><br>
	* This method upload the category of the user while the user adds songs to the pool array.<br>
	* <b>Pre:</b> The user must be create. user!=null.<br>
	* <b>Post:</b> The category of the user has been uploaded.<br>
	* @param name String. Name of the user who is adding songs to the pool array. name!="".
	*/	
	public void updateCategory(String name){
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
			objFindUser.setCategory(Category.LITTLE_CONTRIBUTOR);				
		}else if (amount>=10 && amount<30){
			objFindUser.setCategory(Category.MILD_CONTRIBUTOR);				
		}else if (amount>=30){
			objFindUser.setCategory(Category.STAR_CONTRIBUTOR);					
		}	
	}

	/**
	* <b>Name: createPlaylist</b><br>
	* This method allow to create a private playlist.<br>
	* <b>Pre:</b> The playlists array must be created.<br>
	* <b>Post:</b> The private playlist has been created. <br>
	* @param name String. Name of the private playlist. name!="".<br>
	* @param user String. Name of the user who created the private playlist. user!="".<br>
	* @return message String. Message that confirm or deny if the private playlist was created.
	*/	
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

	/**
	* <b>Name: createPlaylist</b><br>
	* This method allow to create a public playlist.<br>
	* <b>Pre:</b> The playlists array must be created.<br>
	* <b>Post:</b> The public playlist has been created. <br>
	* @param name String. Name of the public playlist. name!="".<br>
	* @return message String. Message that confirm or deny if the public playlist was created.
	*/
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

	/**
	* <b>Name: createPlaylist</b><br>
	* This method allow to create a restricted playlist.<br>
	* <b>Pre:</b> The playlists array must be created.<br>
	* <b>Post:</b> The restricted playlist has been created. <br>
	* @param name String. Name of the restricted playlist. name!="".<br>
	* @param amount int. Amount of users with access to the restricted playlist. amount!=0.<br>
	* @param owners String[]. Name of the owners who can access to the restricted playlist. owners!=null.<br>
	* @return message String. Message that confirm or deny if the restricted playlist was created.
	*/		
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

	/**
	* <b>Name: gradePlaylist</b><br>
	* This method allow to grade a public playlist.<br>
	* <b>Pre:</b> The public playlist must be created. <br>
	* <b>Post:</b> The public playlist has been graded. <br>
	* @param playlistName String. Name of the playlist. playlistName!="".<br>
	* @param grade int. Qualification. grade!=0.
	*/	
	public void gradePlaylist(String playlistName,int grade){
		int currentGrade=0;
		Playlist objPlaylist=findPlaylist(playlistName);
		if (objPlaylist!=null){
			if (objPlaylist instanceof PublicPL){
				PublicPL publicPl = (PublicPL) objPlaylist;
				
				currentGrade=publicPl.getGrade();

				int addGrade=grade;
				counterGrades+=1;

				int average=(int)(currentGrade+addGrade)/counterGrades;			
				publicPl.setGrade(average);
			}			

		}

	}

	/**
	* <b>Name: addSong</b><br>
	* This method allow to add songs to a playlist without care if is a public, private or restricted playlist.<br>
	* <b>Pre:</b> The playlist must be created.<br>
	* <b>Post:</b> The song has been added to a playlist.<br>
	* @param playlist String. Name of the playlist where the user wants to add the song. playlist!="".<br>
	* @param userName String. Name of the user who is going to add the song. userName!="".<br>
	* @param song String. Name of the song which it's going to be added to a playlist. song!="".<br>
	* @param singer String. Name of the singer or band. singer!="".<br>
	* @return message String. Message that confirm or deny if the song was added.
	*/
	public String addSong(String playlist,String userName, String song,String singer){
		Playlist objPlaylist=findPlaylist(playlist);
		User objUser=findUser(userName);
		Song objSong=findSong(song,singer);
		String message="Se registrara la cancion";

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
			message+=objPlaylist.addSong(objUser,objSong);
			
		}
	return message;
	}	

	/**
	* <b>Name: showUsers</b><br>
	* This method allow to show all the users.<br>
	* <b>Pre:</b> The users array must be created.<br>
	* <b>Post:</b> The users array has been shown.<br>
	* @return message String. Message with all the information of all the users.
	*/
	public String showUsers(){
		String message="";
		for (int i=0;i<users.length;i++){
			if (users[i]!=null){
				message+=users[i].toString();
			}		
		}
						
	return message;
	}

	/**
	* <b>Name: showPool</b><br>
	* This method allow to show all the songs.<br>
	* <b>Pre:</b> The pool array must be created.<br>
	* <b>Post:</b> The pool array has been shown.<br>
	* @return message String. Message with all the information of all the songs.
	*/
	public String showPool(){
		String message="";
		for (int i=0;i<pool.length;i++){
			if (pool[i]!=null){
				message+=pool[i].toString();
			}		
		}						
	return message;
	}	

	/**
	* <b>Name: showPlaylists</b><br>
	* This method allow to show all the playlist.<br>
	* <b>Pre:</b> The playlists array must be created.<br>
	* <b>Post:</b> The playlists array has been shown.<br>
	* @return message String. Message with all the information of all the playlists.
	*/
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
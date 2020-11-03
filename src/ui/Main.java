package ui;
import model.Mcs;
import java.util.Scanner;
public class Main{

	public static Mcs objMcs;
	public final static Scanner lector = new Scanner(System.in);

	public static void main(String[] args) {
		createMcs();
		boolean menu=true;

		while (menu) {
			System.out.println("\nMenu principal, ingrese una opcion"+
				"\n(1)Crear un nuevo usuario"+
				"\n(2)Crear una cancion"+
				"\n(3)Crear una playlist"+
				"\n(4)Calificar una playlist"+
				"\n(5)Anadir cancion a una playlist"+
				"\n(6)Listar los usuarios"+
				"\n(7)Listar las canciones del pool"+
				"\n(8)Listar las playlists"+
				"\n(0)Salir");
			int option= lector.nextInt();
			lector.nextLine();
			switch(option){
				case 1: createUser();
				break;

				case 2: createSong();
				break;

				case 3: createPlaylist();
				break;

				case 4: gradePlaylist();
				break;

				case 5: addSong();
				break;

				case 6: System.out.println(objMcs.showUsers());
				break;

				case 7: System.out.println(objMcs.showPool());
				break;

				case 8: System.out.println(objMcs.showPlaylists());
				break;

				case 0: System.out.println("¡Bye!");
				menu=false;
				break;

				default:
				System.out.println("Opcion incorrecta");
				break;
			}
		}
	}

	/**
	* <b>Name: createMcs</b><br>
	* This method is to create an object of the Mcs class.
	* <b>Post:</b> The object of the Mcs class has been created.
	*/
	public static void createMcs(){
		objMcs= new Mcs();		
	}

	/**
	* <b>Name: createUser</b><br>
	* This method allow to create an user and save it in the users array.
	* <b>Pre:</b> The objMcs object must already be created. objMcs!=null.
	* <b>Post:</b> The user has been created successfully.
	*/
	public static void createUser(){
		System.out.println("Ingrese su nombre de usuario");
		String name= lector.next();lector.nextLine();

		System.out.println("Ingrese su contrasena");
		String password= lector.nextLine();

		System.out.println("Ingrese su edad");
		int age=lector.nextInt();

		String message;
		message=objMcs.createUser(name,password,age);
		System.out.println(message);
	}

	/**
	* <b>Name: createSong</b><br>
	* This meethod allow to create a song and incluide it in the song's pool.
	* <b>Pre:</b> The objMcs object must already be created. objMcs!=null.
	* <b>Post:</b> The song has been created successfully.
	*/
	public static void createSong(){
		System.out.println("Ingrese el nombre del usuario que registrara una cancion");
		String name= lector.next();lector.nextLine();

		System.out.println("Ingrese el nombre de la cancion");
		String title=lector.nextLine();

		System.out.println("Ingrese el artista o banda de la cancion");
		String singer=lector.nextLine();

		System.out.println("Ingrese la fecha de lanzamiento de la cancion");
		String date=lector.nextLine();

		System.out.println("Ingrese la duracion de la cancion en segundos");
		int time=lector.nextInt();

		System.out.println("Elija el genero de la cancion"+
			"\n(1)Rock"+
			"\n(2)Hip hop"+
			"\n(3)Musica clasica"+
			"\n(4)Reggae"+
			"\n(5)Salsa"+
			"\n(6)Metal"+
			"\n(7)Pop");
		int genre=lector.nextInt();

		String message;
		message=objMcs.createSong(name,title,singer,date,time,genre);
		System.out.println(message);
	}

	/**
	* <b>Name: createPlaylist</b><br>
	* This method allow to create a playlist of any of the three types: private, public or restricted.
	* <b>Pre:</b> The objMcs object must already be created. objMcs!=null.
	* <b>Post:</b> The playlist has been created successfully.
	*/
	public static void createPlaylist(){
		String message;
		System.out.println("Ingrese el nombre de la playlist");
		String name=lector.nextLine();
		System.out.println("Ingrese que tipo de playlist desea crear:"+
							"\n(1)Playlist privada"+
							"\n(2)Playlist publica"+
							"\n(3)Playlist restringida");
		int option=lector.nextInt();
		lector.nextLine();

		switch(option){
			case 1:
			System.out.println("Ingrese el nombre del usuario con acceso a la playlist");
			String owner= lector.nextLine();

			message=objMcs.createPlaylist(name,owner);
			System.out.println(message);
			break;

			case 2:
			message=objMcs.createPlaylist(name);
			System.out.println(message);
			break;

			case 3:
			System.out.println("Ingrese la cantidad de usuarios que tendran acceso a la playlist");
			int amount=lector.nextInt();
			lector.nextLine();
			String []owners= new String [amount];
			for (int i=0;i<owners.length;i++){
				System.out.println("Ingrese el nombre del usuario");
				owners[i]=lector.nextLine();
			}

			message=objMcs.createPlaylist(name,amount,owners);
			System.out.println(message);
			break;

			default:
			System.out.println("Opcion incorrecta");
			break;
		}

	}

	/**
	* <b>Name: gradePlaylist</b><br>
	* This method allow to grade a playlist.
	* <b>Pre:</b> The objMcs object must already be created. objMcs!=null.
	* <b>Post:</b> The playlist has been graded.
	*/
	public static void gradePlaylist(){		
		System.out.println("Ingrese el nombre de la playlist a calificar");
		String playlistName= lector.nextLine();
		System.out.println("Califique la playlist con un valor entre (1)la nota mas baja y (5)la nota mas alta");
		int grade=lector.nextInt();
		lector.nextLine();

		objMcs.gradePlaylist(playlistName,grade);		
	}

	/**
	* <b>Name: addSong</b><br>
	* This method allow to add songs from the song's pool to a playlist private, public or restricted.
	* <b>Pre:</b> The objMcs object must already be created. objMcs!=null.
	* <b>Post:</b> The song has been added to the playlist that the user wants.
	*/
	public static void addSong(){
		System.out.println("Ingrese el nombre donde la playlist donde desea anadir la cancion");
		String playlist=lector.nextLine();

		System.out.println("Ingrese su nombre de usuario para verificar permisos");
		String userName=lector.nextLine();

		System.out.println("Ingrese el nombre de la cancion que desea anadir");
		String song=lector.nextLine();

		System.out.println("Ingrese el nombre del artista ");
		String singer=lector.nextLine();

		String message;
		message=objMcs.addSong(playlist,userName,song,singer);
		System.out.println(message);
	}
}

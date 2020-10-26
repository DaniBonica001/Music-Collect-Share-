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
			System.out.println("Menú principal, ingrese una opcion"+
				"\n(1)Crear un nuevo usuario"+
				"\n(2)Crear una cancion"+
				"\n(7)Listar los usuarios"+
				"\n(8)Listar las canciones del pool"+
				"\n(0)Salir");
			int option= lector.nextInt();
			switch(option){
				case 1: createUser();
				break;

				case 2: createSong();
				break;

				case 7: objMcs.showUsers();
				break;

				case 8: objMcs.showPool();
				break;

				case 0: "¡Bye!";
				break;

			}
		}

	}

	public static void createMcs(){
		objMcs= new Mcs();		
	}

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
	



}

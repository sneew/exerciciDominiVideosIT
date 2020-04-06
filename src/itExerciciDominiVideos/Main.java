package itExerciciDominiVideos;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String enter = "";
		Usuari user;
		List<Usuari> usuaris = new ArrayList<Usuari>();
		
		Date d1 = new Date(2323223232L);
		
		Usuari u1 = new Usuari ("Eloi", "Fernandez", "hola", d1);
		usuaris.add(u1);
		
		user = welcome(enter, usuaris, sc);
		
		userHome(user, sc);
		
	}

	private static Usuari welcome(String enter, List<Usuari> u, Scanner sc) {
		Usuari user = new Usuari();
		System.out.println("Benvingut! Escriu si vols Login o Registrar");
		enter = sc.next();
		
		if (enter.contains("log") || enter.contains("Log")) {
			
			user = login(u, sc);
		} else if (enter.contains("Reg") || enter.contains("reg")) {
			user = newUser(sc);
			u.add(user);
		}	
		
		return user; 
	}

	private static void userHome(Usuari u, Scanner sc) {
		String action;
		System.out.println("Què vols fer, crear nou video (crear) o veure el teu llistat de videos (llistat)?");
		action = sc.next();
		if (action.equals("crear")) {
			createVideo(u);
		} else if(action.equals("llistat")) {		
			listVideo(u);
		}		
	}

	private static Usuari login(List<Usuari> usuaris, Scanner sc) {
		String name, pass;
		Usuari userIntro;
		Usuari userFound = new Usuari();
		boolean isExistingUser = false;
		
		do {
			System.out.println("Introdueix el teu nom");
			name = sc.next();
			System.out.println("Introdueix la contrasenya");
			pass = sc.next();
			userIntro  = new Usuari(name, pass);
			
			for (int i = 0; i<usuaris.size(); i++) {
				if (userIntro.getNom().equals(usuaris.get(i).getNom()) && userIntro.getPassword().equals(usuaris.get(i).getPassword())) {
					userFound = usuaris.get(i);
					isExistingUser = true;
					break;
				}else {
					isExistingUser = false;
				}
			}
			
			if (!isExistingUser) { 
				System.out.println("Usuari o contrasenya incorrectes, torna-ho a provar!");
			} else if (isExistingUser) { 
				System.out.println("Benvingut " + userFound.getNom()+ " " + userFound.getCognom());
			}
		}
		while (!isExistingUser);
			
		return userFound;
	}

	private static Usuari newUser(Scanner sc) {
		String name, surname, pass;
		Date dataR = new Date();
		Usuari user;
		
		System.out.println("Introdueix el nom: ");
		name = sc.next();
		System.out.println("Introdueix el cognom: ");
		surname = sc.next();
		System.out.println("Introdueix la contrasenya: ");
		pass = sc.next();
		user = new Usuari(name, surname, pass, dataR);
		
		System.out.println("Benvingut a la plataforma, " + user.getNom() + " " + user.getCognom());
		
		return user;
	}
}

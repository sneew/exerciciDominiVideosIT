package itExerciciDominiVideos;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Usuari user = new Usuari();
		List<Usuari> usuaris = new ArrayList<Usuari>();
				
		//usuaris inicialitzats de prova
		Date d1 = new Date(2323223232L);
		Usuari u1 = new Usuari ("eloi", "Fernandez", "hola", d1);
		usuaris.add(u1);
		List<String> tgs = new ArrayList<String>();
		tgs.add("tag1");
		tgs.add("tag2");
		List<Video> videosU1 = new ArrayList<Video> ();
		Video v1 = new Video ("www.google.es", "videoooo1", tgs);
		Video v2 = new Video ("www.google.es", "videoooo2", tgs);		
		videosU1.add(v1);
		videosU1.add(v2);
		u1.setVideos(videosU1);
		
		//reg/log
		try {
			user = welcome(usuaris);
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//crear/mostrar videos
		try {
			userHome(user);
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static Usuari welcome(List<Usuari> u) throws NoDataException {
		String enter;
		Usuari user = new Usuari();
		boolean isLogOrReg = false;
		
		do {
			System.out.println("Benvingut! Escriu si vols Login o Registrar");
			enter = stringScanner();
			
			if (enter.equals("login") || enter.equals("Login")) {
				user = login(u);
				isLogOrReg = true;
			} else if (enter.equals("Registrar") || enter.equals("registrar")) {
				user = newUser();
				u.add(user);
				isLogOrReg = true;
			} else {
				System.out.println("no t'he entès!");
				isLogOrReg = false;
			}
		}while (!isLogOrReg);
		
		return user; 
	}

	private static void userHome(Usuari u) throws NoDataException {
		String action;
		boolean isLog = true;
		do {
			System.out.println("Què vols fer, crear nou video (crear), veure llistat de videos (llistat) o tanca sessió (close)?");
			action = stringScanner();
			if (action.equals("crear")) {
				createVideo(u);
			} else if(action.equals("llistat")) {		
				listVideo(u);
			} else if(action.equals("close")) {		
				isLog = false;
				System.out.println("Fins aviat!");
			}	
		}while (isLog);
			
	}

	private static Usuari login(List<Usuari> usuaris) throws NoDataException {
		String name, pass;
		Usuari userIntro;
		Usuari userFound = new Usuari();
		boolean isExistingUser = false;
		
		do {
			System.out.println("Introdueix el teu nom");
			name = stringScanner();
			System.out.println("Introdueix la contrasenya");
			pass = stringScanner();
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

	private static Usuari newUser() throws NoDataException {
		String name, surname, pass;
		Date dataR = new Date();
		Usuari user;
		
		System.out.println("Introdueix el nom: ");
		name = stringScanner();
		System.out.println("Introdueix el cognom: ");
		surname = stringScanner();
		System.out.println("Introdueix la contrasenya: ");
		pass = stringScanner();
		user = new Usuari(name, surname, pass, dataR);
		
		System.out.println("Benvingut a la plataforma, " + user.getNom() + " " + user.getCognom());
		
		return user;
	}

	private static void listVideo(Usuari u) {
		List <Video> videosU = u.getVideos();
		
		for (int i = 0; i < videosU.size(); i++) {
			String titol = videosU.get(i).getTitol();
			System.out.println(titol);
		}
		
	}
	
	private static void createVideo(Usuari u) throws NoDataException {
		String url, ttl;
		List<Video> vs = u.getVideos();
		Video v1;
		int nTgs = 0;
		List<String> tgsU = new ArrayList<String>();
		
		System.out.println("Escriu l'URL del nou video");
		url = stringScanner();
		System.out.println("Escriu el nom del nou video");
		ttl = stringScanner();
		System.out.println("Quants tags vols posar?");
		nTgs = intScanner();
		
		for (int i = 1; i <= nTgs; i++) {
			System.out.println("Tag nº" + i);
			try {
				tgsU.add(stringScanner());
			} catch (NoDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		v1 = new Video (url, ttl, tgsU);
		vs.add(v1);		
	}
	
	private static String stringScanner() throws NoDataException {
		String txt;
		Scanner sc = new Scanner(System.in);
		
		txt = sc.next();
		if(txt.equals(" ")) {
			throw new NoDataException();
		}
		return txt;
	}
	
	private static int intScanner() throws NoDataException{
		int num;
		Scanner sc = new Scanner(System.in);
		
		num = sc.nextInt();
		return num;
	}
}

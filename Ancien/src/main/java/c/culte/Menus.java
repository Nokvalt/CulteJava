package c.culte;

public class Menus {

	/*
	public static void mainMenu()
	{
		
		InvocationASCII.invoquerJordanAbid();
		System.out.println("Bienvenue tapoteur.euse. \n");
		System.out.println("1 - Je me présente à toi, JAVA");
		System.out.println("2 - Je reviendrai plus tard à toi, JAVA");
		
		int choix = saisieInt("Choisis ta voie.");
		switch(choix)
		{
		case 1 : loginMenu();break;
		case 2 :  Singleton.getInstance().getEmf().close(); System.exit(0);
		}		
		mainMenu();
	}
	
	public static void loginMenu()
	{
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		
		connected = daoT.findByLoginAndPassword(login, password);
		
		if(connected==null) 
		{
			System.out.println("Identifiants invalides");
		}
		else if(connected instanceof GrandDev) 
		{
			GrandDevMenu();
		}
		else if(connected instanceof Compileur) 
		{
			CompileurMenu();	
		}

		else if(connected instanceof Indenteur)
		{
			IndenteurMenu();
		}
	}
	
	
	public static void seDeconnecter()
	{
		connected=null;
		mainMenu();
	}
	
	public static void grandDevMenu()
	{
		InvocationASCII.invoquerGosling();
		System.out.println("\nDave, lève toi, et danse avec la vie...");
		System.out.println("1- Bannir un tapoteur");
		System.out.println("2- Rétrograder");
		System.out.println("3- Prélever de l'argent");
		System.out.println("4- Passation de pouvoir");
		System.out.println("5- Se deconnecter");

		int choix = saisieInt("Choisis ta destinée.");

		switch(choix) 
		{
		case 1 : Bannir();break;
		case 2 : Retrograder();break;
		case 3 : PrendreArgent();break;
		case 4 : Passation();break;
		case 5 : seDeconnecter();break;
		}

		grandDevMenu();
			
	}
	
	public static void compileurMenu()
	{
		System.out.println("\n'Compiler m'a permis d'ouvrir mes ports karmiques et de m'élever au dela de la réalité mortelle.' \nAnthony, un grand compileur");
		System.out.println("1- Verser de l'argent");
		System.out.println("2- Se deconnecter");

		int choix = saisieInt("Choisir menu");

		switch(choix) 
		{
		case 1 : addMoney();break;
		case 2 : seDeconnecter();break;
		}

		compileurMenu();
	}
	
	public static void indenteurMenu()
	{
		
	}
	
	
	
	
	*/

}

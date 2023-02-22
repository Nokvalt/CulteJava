package test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import context.Singleton;
import model.*;
import dao.*;
import ascii.*;

public class Test {
	
		
		public static String saisieString(String msg) 
		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			return monScanner.nextLine();
			//return var;
		}
		public static int saisieInt(String msg) 
		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			int var = monScanner.nextInt();
			return var;
		}
		public static double saisieDouble(String msg) 
		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			double var = monScanner.nextDouble();
			return var;
		}
		public static boolean saisieBoolean(String msg) 

		{
			Scanner monScanner = new Scanner(System.in);
			System.out.println(msg);
			boolean var = monScanner.nextBoolean();
			return var;
		}

//		static Tapoteur connected;
//		static IDAOCulte daoC = Singleton.getInstance().getDaoCulte();
//		static IDAODemande daoD = Singleton.getInstance().getDaoDemande();
//		static IDAOActivite daoA = Singleton.getInstance().getDaoActivite();
//		static IDAOFidele daoF = Singleton.getInstance().getDaoFidele();
//		static IDAOTapoteur daoT = Singleton.getInstance().getDaoTapoteur();
//		
//		
//		public static void mainMenu()
//		{
//			
//			InvocationASCII.invoquerJordanAbid();
//			System.out.println("Bienvenue tapoteur.euse. \n");
//			System.out.println("1 - Je me présente à toi, JAVA");
//			System.out.println("2 - Je reviendrai plus tard à toi, JAVA");
//			
//			int choix = saisieInt("Choisis ta voie.");
//			switch(choix)
//			{
//			case 1 : loginMenu();break;
//			case 2 :  Singleton.getInstance().getEmf().close(); System.exit(0);
//			}		
//			mainMenu();
//		}
//		
//		public static void loginMenu()
//		{
//			String login = saisieString("Saisir votre login");
//			String password = saisieString("Saisir votre password");
//			
//			connected = daoT.findByLoginAndPassword(login, password);
//			
//			if(connected==null) 
//			{
//				System.out.println("Identifiants invalides");
//			}
//			else if(connected instanceof GrandDev) 
//			{
//				GrandDevMenu();
//			}
//			else if(connected instanceof Compileur) 
//			{
//				CompileurMenu();	
//			}
//	
//			else if(connected instanceof Indenteur)
//			{
//				IndenteurMenu();
//			}
//		}
//		
//		
//		public static void GrandDevMenu()
//		{
//			InvocationASCII.invoquerGosling();
//			System.out.println("\nDave, lève toi, et danse avec la vie...");
//			System.out.println("1- Bannir un tapoteur");
//			System.out.println("2- Rétrograder");
//			System.out.println("3- Prélever de l'argent");
//			System.out.println("4- Passation de pouvoir");
//			System.out.println("5- Se deconnecter");
//
//			int choix = saisieInt("Choisis ta destinée.");
//
//			switch(choix) 
//			{
//			case 1 : Bannir();break;
//			case 2 : Retrograder();break;
//			case 3 : PrendreArgent();break;
//			case 4 : Passation();break;
//			case 5 : seDeconnecter();break;
//			}
//
//			GrandDevMenu();
//				
//		}
//		
//		public static void CompileurMenu()
//		{
//			System.out.println("\nCompileur");
//			System.out.println("5- Se deconnecter");
//
//			int choix = saisieInt("Choisir menu");
//
//			switch(choix) 
//			{
//			case 1 : ajouterPatient();break;
//			case 2 : afficherFile();break;
//			case 3 : afficherVisites();break;
//			case 4 : partirPause();break;
//			case 5 : seDeconnecter();break;
//			}
//
//			menuSecretaire();
//		}
		
		
		
		
		
		
		
		
		
		
		public static void main(String[] args) {	
		InvocationASCII.invoquerGosling();
		
		
		//Create bdd
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		emf.close();
	}
}

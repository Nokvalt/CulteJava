package test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import c.culte.dao.*;
import c.culte.model.*;

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

		static Tapoteur connected;
		
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
		
		
		
		
		
		public static void main(String[] args) {	
		//InvocationASCII.invoquerGosling();
			
		//Create objects
		/*Adresse a1 = new Adresse ("14","Rue de Christian Clavier","Limoges","87000","Fronce");
		Adresse a2 = new Adresse ("13","Rue du Mulot","Limoges","87000","Fronce");
		Adresse a3 = new Adresse ("55","Rue du Port","Limoges","87000","Fronce");
		
		
		GrandDev Dave = new GrandDev ("Davidson","Dave",a1,LocalDate.now(),"dev","dev","saumon");
		Indenteur JordanRolland = new Indenteur ("Rolland","Jordan",a2,LocalDate.now(),"rolland","rolland");
		Compileur MarianneGuisset = new Compileur ("Guisset","Marianne",a1,LocalDate.now(),"guisset","guisset");
		Fidele FrancisCatrel = new Fidele("Francis", "Catrel", a3, LocalDate.now(), "catrel", "catrel4ever");
		
		Demande demande = new Demande(135, "achat d'un couvre chef svp");
		JordanRolland.setDemande(demande);
		demande.setIndenteur(JordanRolland);
		
		Evenement evenement = new Evenement("fete", LocalDate.now(), "Toulouse", Activite.rassemblement);
		
		Culte culteJava = new Culte(284.5, 4);
		culteJava.getListEvenement().add(evenement);
		Collections.addAll(culteJava.getListTapoteur(), JordanRolland,MarianneGuisset,FrancisCatrel);
		

		//Create bdd
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		culteJava = daoC.save(culteJava);
		
		Dave.setCulte(culteJava);
		Dave = (GrandDev) daoT.save(Dave);
		
		culteJava.setDave(Dave);
		daoC.save(culteJava);
		
		
		JordanRolland.setCulte(culteJava);
		daoT.save(JordanRolland);
		
		MarianneGuisset.setCulte(culteJava);
		daoT.save(MarianneGuisset);
		
		FrancisCatrel.setCulte(culteJava);
		daoT.save(FrancisCatrel);
		
		evenement.setCulte(culteJava);
		daoE.save(evenement);
		
		em.close();*/
		
	}
}

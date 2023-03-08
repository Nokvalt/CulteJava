package c.culte;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import c.culte.config.AppConfig;
import c.culte.dao.IDAOCulte;
import c.culte.dao.IDAODemande;
import c.culte.dao.IDAOEvenement;
import c.culte.dao.IDAOTapoteur;
import c.culte.model.Activite;
import c.culte.model.Adresse;
import c.culte.model.Compileur;
import c.culte.model.Culte;
import c.culte.model.Demande;
import c.culte.model.Evenement;
import c.culte.model.Fidele;
import c.culte.model.GrandDev;
import c.culte.model.Indenteur;
import c.culte.model.Tapoteur;

public class Application {
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



	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IDAOCulte IDAOc = context.getBean(IDAOCulte.class);
		IDAODemande IDAOd = context.getBean(IDAODemande.class);
		IDAOEvenement IDAOe = context.getBean(IDAOEvenement.class);
		IDAOTapoteur IDAOt = context.getBean(IDAOTapoteur.class);



		//Create objects
		Adresse a1 = new Adresse ("14","Rue de Christian Clavier","Limoges","87000","Fronce");
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



		culteJava = IDAOc.save(culteJava);

		Dave.setCulte(culteJava);
		Dave = (GrandDev) IDAOt.save(Dave);

		culteJava.setDave(Dave);
		IDAOc.save(culteJava);


		JordanRolland.setCulte(culteJava);
		IDAOt.save(JordanRolland);

		MarianneGuisset.setCulte(culteJava);
		IDAOt.save(MarianneGuisset);

		FrancisCatrel.setCulte(culteJava);
		IDAOt.save(FrancisCatrel);

		evenement.setCulte(culteJava);
		IDAOe.save(evenement);



		System.out.println("test");



	}

}

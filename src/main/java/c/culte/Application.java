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
	
	IDAODemande IDAOd = context.getBean(IDAODemande.class);
	IDAOEvenement IDAOe = context.getBean(IDAOEvenement.class);
	IDAOTapoteur IDAOt = context.getBean(IDAOTapoteur.class);
	
	

	System.out.println("test");



	}

}

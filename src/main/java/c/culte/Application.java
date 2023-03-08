package c.culte;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import c.culte.dao.*;
import c.culte.model.*;
import c.culte.config.AppConfig;

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
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	IDAOCulte IDAOc = context.getBean(IDAOCulte.class);
	IDAODemande IDAOd = context.getBean(IDAODemande.class);
	IDAOEvenement IDAOe = context.getBean(IDAOEvenement.class);
	IDAOTapoteur IDAOt = context.getBean(IDAOTapoteur.class);
	
	
	public static void main(String[] args) {
		System.out.println("test");
	}
		
}

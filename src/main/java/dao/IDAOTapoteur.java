package dao;

import java.util.List;

import model.Compileur;
import model.Fidele;
import model.GrandDev;
import model.Indenteur;
import model.Tapoteur;

public interface IDAOTapoteur extends IDAO <Tapoteur,Integer> {
	
	public List<Fidele> findAllFidele();
	public List<Indenteur> findAllIndenteur();
	public List<Compileur> findAllCompileur();
	public List<GrandDev> findAllGrandDev();
	public Tapoteur findByLoginAndPassword(String login,String password);

}

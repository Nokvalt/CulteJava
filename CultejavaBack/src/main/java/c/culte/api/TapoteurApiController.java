package c.culte.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.dao.IDAOBannis;
import c.culte.dao.IDAOEvenement;
import c.culte.dao.IDAOTapoteur;
import c.culte.exception.BannisBadRequestException;
import c.culte.exception.EvenementNotFoundException;
import c.culte.exception.PunitionBadRequestException;
import c.culte.exception.TapoteurBadRequestException;
import c.culte.exception.TapoteurNotFoundException;
import c.culte.exception.WrongLoginPasswordException;
import c.culte.model.Adresse;
import c.culte.model.Bannis;
import c.culte.model.Compileur;
import c.culte.model.Evenement;
import c.culte.model.Fidele;
import c.culte.model.GrandDev;
import c.culte.model.Indenteur;
import c.culte.model.Punition;
import c.culte.model.Tapoteur;
import c.culte.request.BannissementRequest;
import c.culte.request.CompileurRequest;
import c.culte.request.ConnexionRequest;
import c.culte.request.FideleRequest;
import c.culte.request.GrandDevRequest;
import c.culte.request.IndenteurRequest;
import c.culte.request.InscriptionRequest;
import c.culte.request.PunitionRequest;
import c.culte.request.TapoteurRequest;
import c.culte.request.UserEditRequest;
import c.culte.response.TapoteurResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tapoteur")
@CrossOrigin("*")
public class TapoteurApiController {
	@Autowired
	IDAOTapoteur daoT;
	
	@Autowired
	IDAOEvenement daoE;
	
	@Autowired
	IDAOBannis daoB;
	
	// --------- CONNEXION --------- //
	@PostMapping("/connexion")
	public TapoteurResponse findByLogin(@RequestBody @Valid ConnexionRequest connexionRequest, BindingResult result){		
		Tapoteur tapoteur = daoT.findByLoginWithoutBannis(connexionRequest.getLogin()).orElseThrow(TapoteurNotFoundException::new);
		TapoteurResponse response = new TapoteurResponse();
		
		if (tapoteur.getPassword().equals(connexionRequest.getPassword())) {
			if (tapoteur instanceof Fidele) {
				response.setRang("Fidele");
			}else if (tapoteur instanceof Compileur) {
				response.setRang("Compileur");
			}else if(tapoteur instanceof Indenteur) {
				response.setRang("Indenteur");
			}else{
				response.setRang("Grand Dev");
				response.setAllDons(((GrandDev) tapoteur).getAllDons());
				response.setArgentVole(((GrandDev) tapoteur).getArgentVole());
			}
			
			BeanUtils.copyProperties(tapoteur, response);
			response.setVoie(tapoteur.getAdresse().getVoie());
			response.setNumero(tapoteur.getAdresse().getNumero());
			response.setCp(tapoteur.getAdresse().getCp());
			response.setVille(tapoteur.getAdresse().getVille());
			response.setPays(tapoteur.getAdresse().getPays());
			
			return response;
			
		}
		
		throw new WrongLoginPasswordException();
	}
	
	// --------- FIND ALL --------- //
	//FIND ALL TAPOTEUR
	@GetMapping
	public List<TapoteurResponse> findAll(){
		List<TapoteurResponse> responses = new ArrayList<>();
		List<Tapoteur> tapoteurs = daoT.findAllWithoutBannis();
		
		for (Tapoteur t : tapoteurs) {
			TapoteurResponse response = new TapoteurResponse();
			if (t instanceof Fidele) {
				response.setRang("Fidele");
			}else if (t instanceof Compileur) {
				response.setRang("Compileur");
			}else if(t instanceof Indenteur) {
				response.setRang("Indenteur");//AJOUTER LES DEMANDES
			}else{
				response.setRang("Grand Dev");
				response.setArgentVole(((GrandDev) t).getArgentVole());
				response.setAllDons(((GrandDev) t).getAllDons());
			}
			
			BeanUtils.copyProperties(t, response);
			response.setVoie(t.getAdresse().getVoie());
			response.setNumero(t.getAdresse().getNumero());
			response.setCp(t.getAdresse().getCp());
			response.setVille(t.getAdresse().getVille());
			response.setPays(t.getAdresse().getPays());
			
			responses.add(response);
		}
		return responses;
	}
	
	//FIND ALL FIDELES
	@GetMapping("/fideles")
	public List<TapoteurResponse> findAllFidele(){
		List<Fidele> fideles = daoT.findAllFidele();
		List<TapoteurResponse> responses = new ArrayList<>();
		
		for (Fidele f : fideles) {
			TapoteurResponse resp = new TapoteurResponse();
			BeanUtils.copyProperties(f, resp);
			
			resp.setVoie(f.getAdresse().getVoie());
			resp.setNumero(f.getAdresse().getNumero());
			resp.setCp(f.getAdresse().getCp());
			resp.setVille(f.getAdresse().getVille());
			resp.setPays(f.getAdresse().getPays());
			
			resp.setRang("Fidele");
			
			responses.add(resp);
		}
		
		return responses;
	}
	
	//FIND ALL COMPILEUR
		@GetMapping("/compileurs")
		public List<TapoteurResponse> findAllCompileur(){
			List<Compileur> compileurs = daoT.findAllCompileur();
			List<TapoteurResponse> responses = new ArrayList<>();
			
			for (Compileur c : compileurs) {
				TapoteurResponse resp = new TapoteurResponse();
				BeanUtils.copyProperties(c, resp);
				
				resp.setVoie(c.getAdresse().getVoie());
				resp.setNumero(c.getAdresse().getNumero());
				resp.setCp(c.getAdresse().getCp());
				resp.setVille(c.getAdresse().getVille());
				resp.setPays(c.getAdresse().getPays());
				
				resp.setRang("Compileur");
				
				responses.add(resp);
			}
			
			return responses;
		}
		
	//FIND ALL INDENTEURS
	@GetMapping("/indenteurs")
	public List<TapoteurResponse> findAllIndenteur(){
		List<Indenteur> indenteurs = daoT.findAllIndenteur();
		List<TapoteurResponse> responses = new ArrayList<>();
					
		for (Indenteur i : indenteurs) {
			TapoteurResponse resp = new TapoteurResponse();
			BeanUtils.copyProperties(i, resp);
			
			resp.setVoie(i.getAdresse().getVoie());
			resp.setNumero(i.getAdresse().getNumero());
			resp.setCp(i.getAdresse().getCp());
			resp.setVille(i.getAdresse().getVille());
			resp.setPays(i.getAdresse().getPays());
			
			resp.setRang("Indenteur");
						
			responses.add(resp);
		}
					
		return responses;
	}
	
	//FIND GRAND DEV
	@GetMapping("/GrandDev")
	public TapoteurResponse findGrandDev(){
		GrandDev d = daoT.findGrandDev();
	
	
		TapoteurResponse resp = new TapoteurResponse();
		BeanUtils.copyProperties(d, resp);
			
		resp.setVoie(d.getAdresse().getVoie());
		resp.setNumero(d.getAdresse().getNumero());
		resp.setCp(d.getAdresse().getCp());
		resp.setVille(d.getAdresse().getVille());
		resp.setPays(d.getAdresse().getPays());
		
		resp.setRang("Grand Dev");
				
		return resp;
	}
	
	// --------- FIND BY ID --------- //
	@GetMapping("/{id}")
	public TapoteurResponse findById(@PathVariable int id){
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new);
		TapoteurResponse response = new TapoteurResponse();
		
		if (tapoteur instanceof Fidele) {
			response.setRang("Fidele");
		}else if (tapoteur instanceof Compileur) {
			response.setRang("Compileur");
		}else if(tapoteur instanceof Indenteur) {
			response.setRang("Indenteur");
		}else{
			response.setRang("Grand Dev");
		}
		
		BeanUtils.copyProperties(tapoteur, response);
		response.setVoie(tapoteur.getAdresse().getVoie());
		response.setNumero(tapoteur.getAdresse().getNumero());
		response.setCp(tapoteur.getAdresse().getCp());
		response.setVille(tapoteur.getAdresse().getVille());
		response.setPays(tapoteur.getAdresse().getPays());
						
		return response;
	}
	
	// --------- ADD --------- //
	//ADD FIDELE
	@PostMapping("/addFidele")
	@JsonView(Views.Fidele.class)
	public Fidele addFidele(@RequestBody @Valid FideleRequest fideleRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
		
		Fidele fidele = new Fidele();
		Adresse adresse = new Adresse(
				fideleRequest.getNumero(),
				fideleRequest.getVoie(),
				fideleRequest.getVille(),
				fideleRequest.getCp(),
				fideleRequest.getPays());
		
		BeanUtils.copyProperties(fideleRequest, fidele);
		
		fidele.setAdresse(adresse);
		return daoT.save(fidele);
	}
	
	//ADD INDENTEUR
	@PostMapping("/addIndenteur")
	@JsonView(Views.Indenteur.class)
	public Indenteur addIndenteur(@RequestBody @Valid IndenteurRequest indenteurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
			
		Indenteur indenteur = new Indenteur();
		Adresse adresse = new Adresse(
					indenteurRequest.getNumero(),
					indenteurRequest.getVoie(),
					indenteurRequest.getVille(),
					indenteurRequest.getCp(),
					indenteurRequest.getPays());
			
		BeanUtils.copyProperties(indenteurRequest, indenteur);
			
		indenteur.setAdresse(adresse);
		return daoT.save(indenteur);
	}
	
	//ADD COMPILEUR
	@PostMapping("/addCompileur")
	@JsonView(Views.Compileur.class)
	public Compileur addCompileur(@RequestBody @Valid CompileurRequest compileurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
				
		Compileur compileur = new Compileur();
		Adresse adresse = new Adresse(
						compileurRequest.getNumero(),
						compileurRequest.getVoie(),
						compileurRequest.getVille(),
						compileurRequest.getCp(),
						compileurRequest.getPays());
				
		BeanUtils.copyProperties(compileurRequest, compileur);
				
		compileur.setAdresse(adresse);
		return daoT.save(compileur);
	}
	
	//ADD GRANDDEV
		@PostMapping("/addGrandDev")
		@JsonView(Views.GrandDev.class)
		public GrandDev addGrandDev(@RequestBody @Valid GrandDevRequest grandDevRequest, BindingResult result) {
			if (result.hasErrors()) {
				throw new TapoteurBadRequestException();
			}
					
			GrandDev dave = new GrandDev();
			Adresse adresse = new Adresse(
					grandDevRequest.getNumero(),
					grandDevRequest.getVoie(),
					grandDevRequest.getVille(),
					grandDevRequest.getCp(),
					grandDevRequest.getPays());
					
			BeanUtils.copyProperties(grandDevRequest, dave);
					
			dave.setAdresse(adresse);
			
			System.out.println(dave);
			return daoT.save(dave);
		}
	
	// --------- EDIT --------- //
	//EDIT FIDELE
	@PutMapping("/editFidele/{id}")
	@JsonView(Views.Fidele.class)
	public Fidele editFidele(@PathVariable int id, @RequestBody @Valid FideleRequest fideleRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
			
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new); 
		if (tapoteur instanceof Fidele fidele){
			Adresse adresse = new Adresse(
				fideleRequest.getNumero(),
				fideleRequest.getVoie(),
				fideleRequest.getVille(),
				fideleRequest.getCp(),
				fideleRequest.getPays());
		
			BeanUtils.copyProperties(fideleRequest, fidele);
			fidele.setAdresse(adresse);
			return daoT.save(fidele);
		}
		
		throw new TapoteurBadRequestException();
	}
	
	//EDIT INDENTEUR
	@PutMapping("/editIndenteur/{id}")
	@JsonView(Views.Indenteur.class)
	public Indenteur editIndenteur(@PathVariable int id, @RequestBody @Valid IndenteurRequest indenteurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
			
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new); 
		if (tapoteur instanceof Indenteur indenteur){
			Adresse adresse = new Adresse(
				indenteurRequest.getNumero(),
				indenteurRequest.getVoie(),
				indenteurRequest.getVille(),
				indenteurRequest.getCp(),
				indenteurRequest.getPays());
		
			BeanUtils.copyProperties(indenteurRequest, indenteur);
			indenteur.setAdresse(adresse);
			return daoT.save(indenteur);
		}
		
		throw new TapoteurBadRequestException();
	}
	
	//EDIT COMPILEUR
	@PutMapping("/editCompileur/{id}")
	@JsonView(Views.Compileur.class)
	public Compileur editCompileur(@PathVariable int id, @RequestBody @Valid CompileurRequest compileurRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
			
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new); 
		if (tapoteur instanceof Compileur compileur){
			Adresse adresse = new Adresse(
					 compileurRequest.getNumero(),
					 compileurRequest.getVoie(),
					 compileurRequest.getVille(),
					 compileurRequest.getCp(),
					 compileurRequest.getPays());
		
			BeanUtils.copyProperties(compileurRequest, compileur);
			compileur.setAdresse(adresse);
			return daoT.save(compileur);
		}
		
		throw new TapoteurBadRequestException();
	}
	
	//EDIT GRAND DEV
	@PutMapping("/editGrandDev/{id}")
	@JsonView(Views.Compileur.class)
	public GrandDev editGrandDev(@PathVariable int id, @RequestBody @Valid GrandDevRequest grandDevRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
			
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new); 
		if (tapoteur instanceof GrandDev dev){
			Adresse adresse = new Adresse(
					grandDevRequest.getNumero(),
					grandDevRequest.getVoie(),
					grandDevRequest.getVille(),
					grandDevRequest.getCp(),
					grandDevRequest.getPays());
		
			BeanUtils.copyProperties(grandDevRequest, dev);
			dev.setAdresse(adresse);
			return daoT.save(dev);
		}
		
		throw new TapoteurBadRequestException();
	}
	
	// --------- DELETE --------- //
	@DeleteMapping("/{id}")
	@JsonView(Views.Tapoteur.class)
	public boolean delete(@PathVariable int id) {
		try {
			this.daoT.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	// --------- INSCRIPTION --------- //
	@PutMapping("/inscriptionEvenement/{tapoteurId}")
	@JsonView(Views.Evenement.class)
	public boolean inscription (@PathVariable int tapoteurId, @RequestBody @Valid InscriptionRequest inscriptionRequest, BindingResult result)
	{
		Tapoteur tapoteur = daoT.findByIdWithInscriptions(tapoteurId).orElseThrow(TapoteurNotFoundException::new);
		Evenement evenement = daoE.findByIdWithInscrits(inscriptionRequest.getEvenementId()).orElseThrow(EvenementNotFoundException::new);
		
		if (tapoteur instanceof Fidele fidele) {
			evenement.getInscrits().add(fidele);
			fidele.getInscriptions().add(evenement);
		
			daoT.save(fidele);
			daoE.save(evenement);
			return true;
		}
		
		throw new TapoteurBadRequestException();
	}
	
	@GetMapping("/mesInscriptions/{tapoteurId}")
	@JsonView(Views.Evenement.class)
	public List<Evenement> findAllByTapoteurId(@PathVariable int tapoteurId) {
		return this.daoE.findAllByInscritsId(tapoteurId);
	}
	
	
	// --------- MODIFICATION PROFIL --------- //
	@PutMapping("/editerUtilisateur/{id}")
	@JsonView(Views.Fidele.class)
	public Tapoteur editUser(@PathVariable int id, @RequestBody @Valid UserEditRequest userRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
		
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new); 
		
		switch (userRequest.getAttribut()) {
		
		case "login":
			tapoteur.setLogin(userRequest.getValue());
			break;
		
		case "password":
			tapoteur.setPassword(userRequest.getValue());
			break;	
			
		case "nom":
			tapoteur.setNom(userRequest.getValue());
			break;
		
		case "prenom":
			tapoteur.setPrenom(userRequest.getValue());
			break;
		
		case "imageProfil":
			tapoteur.setImageProfil(userRequest.getValue());
			break;
			
		case "adresse":
			tapoteur.setAdresse(userRequest.getAdresse());
			break;
		}
		
		return daoT.save(tapoteur);
	}
	
	
	// --------- MODIFICATION RANG TAPOTEUR --------- //
	//Promotion Fidèle / Identeur
	@GetMapping("/promouvoir/{id}")
	@JsonView(Views.Tapoteur.class)
	public Tapoteur promouvoir(@PathVariable int id) {
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new);
		System.out.println("ICIIIIIIIIIIIIIIIIIIIIIII" + tapoteur.getClass());
		Tapoteur newTapoteur;
		
		if (tapoteur instanceof Fidele) {//change en indenteur
			System.out.println("test");
			newTapoteur = new Indenteur();
		}else if(tapoteur instanceof Indenteur) {//change en compileur
			newTapoteur = new Compileur();
		}else {
			throw new TapoteurBadRequestException();
		}
		
		BeanUtils.copyProperties(tapoteur, newTapoteur);
		daoT.delete(tapoteur);
		
		return daoT.save(newTapoteur);
	}
	
	//Rétrogradation Compileur / Indenteur
	@GetMapping("/retrograder/{id}")
	@JsonView(Views.Tapoteur.class)
	public Tapoteur retrograder(@PathVariable int id) {
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new);
		Tapoteur newTapoteur;
		
		if (tapoteur instanceof Indenteur) {
			newTapoteur = new Fidele();
		}else if(tapoteur instanceof Compileur) {//change en compileur
			newTapoteur = new Indenteur();
		}else {
			throw new TapoteurBadRequestException();
		}
		
		BeanUtils.copyProperties(tapoteur, newTapoteur);
		daoT.delete(tapoteur);
		
		return daoT.save(newTapoteur);
	}
	
	//Bannissement
	@PostMapping("/bannissement")
	@JsonView(Views.Bannis.class)
	public Bannis bannissement(@RequestBody @Valid BannissementRequest bannissementRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new BannisBadRequestException();
		}
		
		Bannis bannis = new Bannis();
		Tapoteur tapoteur = daoT.findById(bannissementRequest.getTapoteurId()).orElseThrow(TapoteurNotFoundException::new);
		
		if (daoB.findByTapoteurId(tapoteur.getId()).isEmpty()) {
			System.out.println("test??");
			bannis.setDateBannissement(bannissementRequest.getDateBannissement());
			//bannis.setInfoBanquaires(bannissementRequest.getInfoBanquaires());
			bannis.setMotif(bannissementRequest.getMotif());
			bannis.setNom(tapoteur.getNom());
			bannis.setPrenom(tapoteur.getPrenom());
			bannis.setTapoteur(tapoteur);
			
			daoB.save(bannis);
			
			return bannis;
		}
		
		throw new TapoteurBadRequestException();
		
		
	}
	
	//Nouveau GrandDev
	@GetMapping("/passation/{id}")
	@JsonView(Views.Tapoteur.class)
	public Tapoteur passation(@PathVariable int id) {
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new);
		GrandDev dev = this.daoT.findGrandDev();
		GrandDev newDave = new GrandDev();
		
		//Create new dev
		BeanUtils.copyProperties(tapoteur, newDave);
		daoT.delete(tapoteur);
		newDave.setArgentVole(0.0);
		newDave.setAllDons(dev.getAllDons());
		
		//delete ancien dev
		daoT.delete(dev);
		
		return daoT.save(newDave);
	}
	
	
	// --------- VOLER LA CAGNOTTE --------- //
	@GetMapping("/vider")
	@JsonView(Views.Tapoteur.class)
	public TapoteurResponse viderCagnotte() {
		GrandDev dev = this.daoT.findGrandDev();
		TapoteurResponse response = new TapoteurResponse();
		dev.setArgentVole(dev.getArgentVole() + dev.getAllDons());
		dev.setAllDons(0.0);
		
		BeanUtils.copyProperties(dev, response);
		return response;
	}
	// --------- PUNITIONS --------- //
	@PutMapping("/punition/{id}")
	@JsonView(Views.Tapoteur.class)
	public Tapoteur punition(@PathVariable int id, @RequestBody @Valid PunitionRequest punitionRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new PunitionBadRequestException();
		}
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new);
		tapoteur.setPunition(Punition.valueOf(punitionRequest.getPunition()));
		
		return daoT.save(tapoteur);
	}
	
	@PutMapping("/removePunition/{id}")
	@JsonView(Views.Tapoteur.class)
	public Tapoteur removePunition(@PathVariable int id, BindingResult result) {
		if (result.hasErrors()) {
			throw new PunitionBadRequestException();
		}
		Tapoteur tapoteur = daoT.findById(id).orElseThrow(TapoteurNotFoundException::new);
		tapoteur.setPunition(Punition.valueOf("aucune"));
		
		return daoT.save(tapoteur);
	}
	
}
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

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.dao.IDAOTapoteur;
import c.culte.exception.TapoteurBadRequestException;
import c.culte.exception.TapoteurNotFoundException;
import c.culte.model.Adresse;
import c.culte.model.Compileur;
import c.culte.model.Fidele;
import c.culte.model.GrandDev;
import c.culte.model.Indenteur;
import c.culte.model.Tapoteur;
import c.culte.request.CompileurRequest;
import c.culte.request.FideleRequest;
import c.culte.request.GrandDevRequest;
import c.culte.request.IndenteurRequest;
import c.culte.response.CompileurResponse;
import c.culte.response.FideleResponse;
import c.culte.response.GrandDevResponse;
import c.culte.response.IndenteurResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tapoteur")
@CrossOrigin("*")
public class TapoteurApiController {
	@Autowired
	IDAOTapoteur daoT;
	
	// --------- FIND ALL --------- //
	//FIND ALL TAPOTEUR
	@GetMapping
	@JsonView(Views.Tapoteur.class)
	public List<Tapoteur> findAll(){
		return daoT.findAll();
	}
	
	//FIND ALL FIDELES
	@GetMapping("/fideles")
	public List<FideleResponse> findAllFidele(){
		List<Fidele> fideles = daoT.findAllFidele();
		List<FideleResponse> responses = new ArrayList();
		
		for (Fidele f : fideles) {
			FideleResponse resp = new FideleResponse();
			BeanUtils.copyProperties(f, resp);
			
			responses.add(resp);
		}
		
		return responses;
	}
	
	//FIND ALL COMPILEUR
		@GetMapping("/compileurs")
		public List<CompileurResponse> findAllCompileur(){
			List<Compileur> compileurs = daoT.findAllCompileur();
			List<CompileurResponse> responses = new ArrayList();
			
			for (Compileur c : compileurs) {
				CompileurResponse resp = new CompileurResponse();
				BeanUtils.copyProperties(c, resp);
				
				responses.add(resp);
			}
			
			return responses;
		}
		
	//FIND ALL INDENTEURS
	@GetMapping("/indenteurs")
	public List<IndenteurResponse> findAllIndenteur(){
		List<Indenteur> indenteurs = daoT.findAllIndenteur();
		List<IndenteurResponse> responses = new ArrayList();
					
		for (Indenteur i : indenteurs) {
			IndenteurResponse resp = new IndenteurResponse();
			BeanUtils.copyProperties(i, resp);
						
			responses.add(resp);
		}
					
		return responses;
	}
	
	//FIND GRAND DEV
	@GetMapping("/GrandDev")
	public List<GrandDevResponse> findGrandDev(){
		List<GrandDev> dave = daoT.findAllGrandDev();
		List<GrandDevResponse> responses = new ArrayList();
						
		for (GrandDev d : dave) {
			GrandDevResponse resp = new GrandDevResponse();
			BeanUtils.copyProperties(d, resp);
							
			responses.add(resp);
		}
						
		return responses;
	}
	
	
	/*
	@JsonView(Views.Fidele.class)
	public List<Fidele> findAllFidele(){
		return daoT.findAllFidele();
	}*/
	
	// --------- FIND BY ID --------- //
	
	
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
}

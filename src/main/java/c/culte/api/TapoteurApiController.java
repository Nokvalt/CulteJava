package c.culte.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.dao.IDAOTapoteur;
import c.culte.exception.CulteNotFoundException;
import c.culte.exception.TapoteurBadRequestException;
import c.culte.model.Adresse;
import c.culte.model.Compileur;
import c.culte.model.Fidele;
import c.culte.model.Indenteur;
import c.culte.model.Tapoteur;
import c.culte.request.CompileurRequest;
import c.culte.request.FideleRequest;
import c.culte.request.IndenteurRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tapoteur")
@CrossOrigin("*")
public class TapoteurApiController {
	@Autowired
	IDAOTapoteur daoT;
	@Autowired
	IDAOCulte daoC;
	
	// --------- FIND ALL --------- //
	//FIND ALL TAPOTEUR
	@GetMapping
	@JsonView(Views.Tapoteur.class)
	public List<Tapoteur> findAll(){
		return daoT.findAll();
	}
	
	//FIND ALL FIDELES
	@GetMapping("/fideles")
	@JsonView(Views.Fidele.class)
	public List<Fidele> findAllFidele(){
		return daoT.findAllFidele();
	}
	/*public List<FideleResponse> findAllFidele(){
	List<Fidele> fideles = daoT.findAllFidele();
	return ;
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
		System.out.println(fidele);
		return daoT.save(fidele);
	}
	
	//ADD INDENTEUR
	@PostMapping("/addIndenteur")
	@JsonView(Views.Fidele.class)
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
		System.out.println(indenteur);
		return daoT.save(indenteur);
	}
	
	//ADD COMPILEUR
	@PostMapping("/addCompileur")
	@JsonView(Views.Fidele.class)
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
		System.out.println(compileur);
		return daoT.save(compileur);
	}
	
	
	
	
	// --------- EDIT --------- //
	
	
	// --------- DELETE --------- //
	
	
	
	
}

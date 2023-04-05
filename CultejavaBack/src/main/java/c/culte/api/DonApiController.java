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

import c.culte.dao.IDAODon;
import c.culte.dao.IDAOTapoteur;
import c.culte.exception.DonBadRequestException;
import c.culte.exception.DonNotFoundException;
import c.culte.exception.TapoteurNotFoundException;
import c.culte.model.Don;
import c.culte.model.GrandDev;
import c.culte.model.Tapoteur;
import c.culte.request.DonRequest;
import c.culte.response.DonResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/don")
@CrossOrigin("*")
public class DonApiController {
	@Autowired
	IDAODon daoDon;
	
	@Autowired
	IDAOTapoteur daoTapoteur;
	
	@GetMapping
	public List<DonResponse> findAllDon(){
		List <Don> dons = daoDon.findAllDon();
		List <DonResponse> responses = new ArrayList();
		
		for (Don d : dons) {
			DonResponse response = new DonResponse();
			BeanUtils.copyProperties(d, response);
			response.setTapoteurId(d.getTapoteur().getId());
			response.setTapoteurNom(d.getTapoteur().getNom());
			response.setTapoteurPrenom(d.getTapoteur().getPrenom());
			
			responses.add(response);
		}
		
		return responses;
	}
	
	@GetMapping("/{id}")
	public DonResponse findById(@PathVariable int id) {
		Don don = daoDon.findById(id).orElseThrow(DonNotFoundException::new);
		DonResponse response = new DonResponse();
		
		BeanUtils.copyProperties(don, response);
		response.setTapoteurId(don.getTapoteur().getId());
		response.setTapoteurNom(don.getTapoteur().getNom());
		response.setTapoteurPrenom(don.getTapoteur().getPrenom());
		
		return response;
	}
	
	@PostMapping("/addDon")
	@JsonView(Views.Don.class)
	public Don addDon(@RequestBody @Valid DonRequest donRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new DonBadRequestException();
		}
			
		Don don = new Don();
		Tapoteur tapoteur = this.daoTapoteur.findById(donRequest.getTapoteurId()).orElseThrow(TapoteurNotFoundException::new);
		
		BeanUtils.copyProperties(donRequest, don);
		
		don.setTapoteur(tapoteur);
		
		GrandDev dev = this.daoTapoteur.findGrandDev();
		dev.setAllDons(don.getMontant());
		daoTapoteur.save(dev);
		
		tapoteur.setSommeDon(tapoteur.getSommeDon() + don.getMontant());
		daoTapoteur.save(tapoteur);
		
		return daoDon.save(don);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Don.class)
	public Don edit(@PathVariable int id, @Valid @RequestBody DonRequest donRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new DonBadRequestException();
		}
		
		Don don = this.daoDon.findById(id).orElseThrow(DonNotFoundException::new);
		
		BeanUtils.copyProperties(donRequest, don);
		
		don.setTapoteur(
			this.daoTapoteur
				.findById(donRequest.getTapoteurId())
				.orElseThrow(TapoteurNotFoundException::new)
		);
		
		return this.daoDon.save(don);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoDon.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	

}

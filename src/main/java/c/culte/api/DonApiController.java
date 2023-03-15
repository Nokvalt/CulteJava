package c.culte.api;

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
import c.culte.model.Tapoteur;
import c.culte.request.DonRequest;
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
	@JsonView(Views.Don.class)
	public List<Don> findAllDon(){
		return daoDon.findAllDon();
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

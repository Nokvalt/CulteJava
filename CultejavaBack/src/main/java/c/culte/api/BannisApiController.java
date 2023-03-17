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

import c.culte.dao.IDAOBannis;
import c.culte.dao.IDAOTapoteur;
import c.culte.exception.BannisNotFoundException;
import c.culte.exception.TapoteurBadRequestException;
import c.culte.model.Compileur;
import c.culte.model.Fidele;
import c.culte.model.Indenteur;
import c.culte.request.BannisRequest;
import c.culte.request.FideleRequest;
import c.culte.model.Bannis;
import c.culte.response.CompileurResponse;
import c.culte.response.FideleResponse;
import c.culte.response.GrandDevResponse;
import c.culte.response.IndenteurResponse;
import jakarta.validation.Valid;
import c.culte.response.BannisResponse;

@RestController
@RequestMapping("/api/bannis")
@CrossOrigin("*")
public class BannisApiController {
	@Autowired
	IDAOBannis daoB;
	
	@Autowired
	IDAOTapoteur daoT;
	
	// --------- FIND ALL BANNIS --------- //
	@GetMapping
	public List<BannisResponse> findAll(){
		List<BannisResponse> responses = new ArrayList();
		List <Bannis> bannis = daoB.findAll();
			
		for (Bannis b : bannis) {
			BannisResponse response = new BannisResponse();
			BeanUtils.copyProperties(b, response);
			responses.add(response);
		}
		
		return responses;
	}
	
	// --------- FIND BY ID BANNIS --------- //
	@GetMapping("/{id}")
	public BannisResponse findById(@PathVariable int id){
		BannisResponse response = new BannisResponse();
		Bannis bannis = daoB.findById(id).orElseThrow(BannisNotFoundException::new);

		BeanUtils.copyProperties(bannis, response);

		return response;
	}
	
	// --------- ADD UN BANNIS (BANNISSEMENT) --------- //
	@PostMapping
	public Bannis add(@RequestBody @Valid BannisRequest bannisRequest, BindingResult result){
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
		
		Bannis bannis = new Bannis();
		BeanUtils.copyProperties(bannisRequest, bannis);
		
		return daoB.save(bannis);
	}
	
	// --------- EDIT UN BANNIS  --------- //
	@PutMapping("/{id}")
	public Bannis edit(@PathVariable int id, @RequestBody @Valid BannisRequest bannisRequest, BindingResult result){
		if (result.hasErrors()) {
			throw new TapoteurBadRequestException();
		}
			
		Bannis bannis = daoB.findById(id).orElseThrow(BannisNotFoundException::new);
		BeanUtils.copyProperties(bannisRequest, bannis);
		
		return daoB.save(bannis);
	}
	
	// --------- DELETE UN BANNIS  --------- //
	@DeleteMapping("/{id}")
	public boolean delete(@PathVariable int id){
		try {
			this.daoB.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}

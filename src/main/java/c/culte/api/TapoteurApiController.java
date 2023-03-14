package c.culte.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.dao.IDAOTapoteur;
import c.culte.model.Fidele;

@Controller
@RequestMapping("/api/tapoteur")
@CrossOrigin("*")
public class TapoteurApiController {
	@Autowired
	IDAOTapoteur daoT;
	
	@GetMapping("/fideles")
	@JsonView(Views.Fidele.class)
	public List<Fidele> findAllFidele(){
		return daoT.findAllFidele();
	}
	
}

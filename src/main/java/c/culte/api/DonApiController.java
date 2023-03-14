package c.culte.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import c.culte.dao.IDAODon;
import c.culte.model.Don;

@RestController
@RequestMapping("/api/don")
@CrossOrigin("*")
public class DonApiController {
	@Autowired
	IDAODon daoDon;
	
	@GetMapping
	@JsonView(Views.Don.class)
	public List<Don> findAllDon(){
		return daoDon.findAllDon();
	}

}

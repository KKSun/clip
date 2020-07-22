package com.sqldemo.demo.Controller;

import com.sqldemo.demo.Repo.ClipRepo;
import com.sqldemo.demo.Model.Clip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/sql")
public class MysqlCURD {
	
	@Autowired
  	private ClipRepo ClipRepository;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/add")
	public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String text, @RequestParam String tag) {
		Iterable<Clip> all = ClipRepository.findAll();
		for(Clip c : all){
			if(c.getName().equals(name) && c.getTag().equals(tag)){
				return "tag has been used";
			}
		}
		Clip n = new Clip();
		n.setName(name);
		n.setTag(tag);
		n.setText(text);
		ClipRepository.save(n);
		return "Saved";
  }

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Clip> getAllUsers() {
		return ClipRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/fetch")
	public @ResponseBody String getText(@RequestParam String name, @RequestParam String tag) {
		Iterable<Clip> all = ClipRepository.findAll();
		for(Clip c : all){
			if(c.getName().equals(name) && c.getTag().equals(tag)){
				return c.getText();
			}
		}
		return "";
	}
}
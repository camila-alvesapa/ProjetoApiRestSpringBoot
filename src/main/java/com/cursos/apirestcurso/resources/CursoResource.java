package com.cursos.apirestcurso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.apirestcurso.models.Curso;
import com.cursos.apirestcurso.repository.CursoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController //api rest 
@RequestMapping(value = "/api") //uri padrao
@Api(value="API Rest Cursos") //titulo da api
@CrossOrigin(origins="*") //Liberar todos os dominios de acessar a api
public class CursoResource {
	
	//ponto de injeção do repository, para poder utilizar os métodos para conectar com banco de dados
	@Autowired
	CursoRepository cursoRepository; 
	
	//método para listar todos os cursos salvos no banco de dados
	@GetMapping("/cursos")
	@ApiOperation(value="Retorna uma lista de cursos.")
	public List<Curso> listaCursos(){ //retorna uma lista de cursos
		return cursoRepository.findAll();
	}
	
	//método para listar determinado curso
	@GetMapping("/cursos/{id}")
	@ApiOperation(value="Retorna o curso especificado.")
	public Curso listaCursoEspecífico(@PathVariable(value = "id") long id){ 
		return cursoRepository.findById(id); 
	}
	
	//método para salvar um curso no banco de dados
	@PostMapping("/curso")
	@ApiOperation(value="Salva um novo curso.")
	public Curso salvaCurso(@RequestBody Curso curso) {
		return cursoRepository.save(curso);
	}
		
	//método para deletar um curso do banco de dados
	@DeleteMapping("/curso")
	@ApiOperation(value="Deleta um curso.")
	public void deletaCurso(@RequestBody Curso curso) {
		cursoRepository.delete(curso); 
	}
	
	//método para atualizar um curso no banco de dados
	@PutMapping("/curso")
	@ApiOperation(value="Atualiza um curso.")
	public Curso atualizaCurso(@RequestBody Curso curso) {// 
		return cursoRepository.save(curso); //mandar o id junto também, pois ele irá atualizar os dados desse id 
	}
	
}

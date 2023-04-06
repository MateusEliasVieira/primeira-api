package br.com.cursospringboot.PrimeiroProjeto.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cursospringboot.PrimeiroProjeto.model.Usuario;
import br.com.cursospringboot.PrimeiroProjeto.repository.UsuarioRepository;


@RestController
public class GreetingsController {
	
	/* O springboot por padrão recebe json e retorna json automaticamente 
	 * ou seja, quando eu der uma resposta não preciso usar nenhum método
	 * ou anotação para transformar a resposta em json, o proprio springboot
	 * já entende que deve ser convertido em json a resposta e ele faz isso sozinho.
	 * Porém a opção de trabalhar com xml, yaml ao invés de json, mas nesse caso deve ser especificado,
	 * do contrário será usado json como tipo de contexto.
	 * */
	
	/*
	 * A classe ResponseEntity é uma classe do Spring Framework 
	 * que representa toda a resposta HTTP de uma requisição. 
	 * Ela pode ser usada para enviar uma resposta com 
	 * um status HTTP específico, um corpo de resposta e/ou cabeçalhos 
	 * de resposta personalizados. A classe ResponseEntity é amplamente 
	 * usada no Spring Boot para criar e enviar respostas HTTP personalizadas 
	 * a partir de controladores.
	 * Em resumo, essa classe permite criar uma resposta Http personalizada para uma requisição feita,
	 * passando a resposta(uma string, um objeto, um número...) e o status da resposta Http(OK, Created...)
	 */
	
	 /* 
	    A anotação @RequestBody, pega o json vindo no corpo da requisição http
	    e transforma no objeto desejado. Nesse caso será transformado em um objeto 
	    usuário
	  */
	
	// Diferença entre RequestMapping e GetMapping, é que GetMapping é mais inshuto
	
	@Autowired // Anotação para Injeção de Dependência e Contextos (CDI)
	private UsuarioRepository usuarioRepository;
	
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/nome/{name}", method = RequestMethod.GET)
    public String greetingText(@PathVariable String name) {
        return "Hello " + name + "!";
    }
    
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/salvar/{nome}", method = RequestMethod.GET)
    public String salvar(@PathVariable String nome) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(nome);
    	usuario.setIdade(23);
    	
    	this.usuarioRepository.save(usuario);
    	
    	return "Usuário salvo com sucesso!";
    }
    
    @ResponseBody // Retorna os dados no corpo da resposta
    @GetMapping(value="/listar")
    public ResponseEntity<List<Usuario>> listUsuario(){
    	List<Usuario> list = this.usuarioRepository.findAll();
    	ResponseEntity<List<Usuario>> responseEntity = new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    	return responseEntity;
    }
    
   
    @ResponseBody
    @PostMapping(value="/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){ 
    	 Usuario u = this.usuarioRepository.save(usuario); // Ele salva e retorna o objeto salvo
    	 ResponseEntity<Usuario> responseEntity = new ResponseEntity<Usuario>(u,HttpStatus.CREATED);
    	 return responseEntity;
    }
    
    @ResponseBody
    @PutMapping(value="/atualizar")
    public ResponseEntity<?> atualizar(@RequestBody Usuario usuario){
    	 if(usuario.getId() == null) {
    		 return new ResponseEntity<String>("Informe o id!",HttpStatus.OK);
    	 }
    	 Usuario u = this.usuarioRepository.saveAndFlush(usuario); // Ele atualiza e retorna o objeto atualizado
    	 ResponseEntity<Usuario> responseEntity = new ResponseEntity<Usuario>(u,HttpStatus.CREATED);
    	 return responseEntity;
    }
    
    @ResponseBody
    @DeleteMapping(value="/deletar")
    public ResponseEntity<String> deletar(@RequestParam(name="id") Long id) { // RequestParam pega o parametro vindo no corpo da requisição e joga na variavel
    	this.usuarioRepository.deleteById(id);
    	return new ResponseEntity<String>("Usuário deletado com sucesso!",HttpStatus.OK);
    }
    
    @ResponseBody
    @GetMapping(value="/buscarPorId")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Long id){
    	Optional<Usuario> usuario = usuarioRepository.findById(id);
    	ResponseEntity<Usuario> responseEntity = new ResponseEntity<Usuario>(usuario.get(),HttpStatus.OK);
    	return responseEntity;
    }
    
    @ResponseBody
    @GetMapping(value="/buscarPorNome")
    public ResponseEntity<List<Usuario>> buscarUsuarioPorParteDoNome(@RequestParam(name="nome") String nome){
    	List<Usuario> list = usuarioRepository.findContainName(nome);
    	ResponseEntity<List<Usuario>> responseEntity = new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    	return responseEntity;
    }
    
//    @DeleteMapping(value="/deletar")
//    public void deletarUsuario(@RequestParam("id") Long id) {
//    	usuarioRepository.deleteById(id);
//    }
    
}

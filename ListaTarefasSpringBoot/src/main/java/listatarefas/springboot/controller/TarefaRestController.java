package listatarefas.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import listatarefas.springboot.model.Tarefa;
import listatarefas.springboot.service.TarefaService;

@RestController
@RequestMapping("tarefas")
public class TarefaRestController {
	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping
	public ResponseEntity<Iterable<Tarefa>> buscarTodasAsTarefas(){
		return ResponseEntity.ok(tarefaService.buscarTodasAsTarefas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarefa> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(tarefaService.buscarPorId(id));
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> inserirNovaTarefa(@RequestBody Tarefa tarefa){
		tarefaService.inserirNovaTarefa(tarefa);
		return ResponseEntity.ok(tarefa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Tarefa> atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa){
		tarefaService.atualizarTarefa(id, tarefa);
		return ResponseEntity.ok(tarefa);  
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarTarefa(Long id){
		tarefaService.deletarTarefa(id);
		return ResponseEntity.ok().build();
	}
}

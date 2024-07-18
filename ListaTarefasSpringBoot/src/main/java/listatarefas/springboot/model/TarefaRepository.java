package listatarefas.springboot.model;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TarefaRepository extends CrudRepository<Tarefa, Long> {

}

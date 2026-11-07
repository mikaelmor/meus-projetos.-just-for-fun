import br.unifan.agenda.controller.exception.*;
import br.unifan.agenda.dao.ContatoDAO;
import br.unifan.agenda.model.Contato;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.catalina.connector.Response;
import org.apache.logging.log4j.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contato")
public class ContatoBC {
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody Contato contato) {
        if(ContatoDAO.obterPorEmail(contato.getEmail()) == null)
            ContatoDAO.salvar(contato);
        else
            throw new ContatoJaExiste(contato.getEmail());
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> remover(@PathVariable String email) {
        if(ContatoDAO.remover(email))
            return ResponseEntity.status(200).build();
        return ResponseEntity.status(400).build();
    }

    @GetMapping
    public List <Contato> obterTodos() {
        return ContatoDAO.obterTodos();
    }
    @PutMapping("/{email}")
    public ResponseEntity <Map<String, String>> atualizar(
        @PathVariable String email, @RequestBody Contato novoContato
    )  {
        Contato contatoAtual = ContatoDAO.obterPorEmail(email);
        if(contatoAtual == null)
            throw new ContatoNotFound(email);
        else {
            if(!contatoAtual.getEmail().equals(novoContato.getEmail())) {
                if(ContatoDAO.obterPorEmail(novoContato.getEmail())!= null)
                    throw new ContatoJaExiste(novoContato.getEmail());
            }
        }   
      ContatoDAO.atualizar(contatoAtual, novoContato);
      Map<String, String> body = new HashMap<>();
      body.put("message", "Contato atualizado com sucesso");
      return ResponseEntity.status(200).body(body);
    }

    @GetMapping("/{email}")
    public Contato obterPorEmail(@PathVariable String email){
    Contato contato = ContatoDAO.obterPorEmail(email);
    if (contato == null)
        throw new ContatoNotFound(email);
        return contato; 
    }
}


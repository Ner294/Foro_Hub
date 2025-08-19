package TopicoService.com.miempresa.topicos;

import TopicoRepository.com.miempresa.topicos.TopicoRepository;
import com.miempresa.topicos.model.Topico;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    private final Topicorepository repository;

    public TopicoService(TopicoRepository repository) {
        this.repository = (Topicorepository) repository;
    }

    public List<Topico> findAll() {
        return repository.findAll();
    }

    public Optional<Topico> findById(Long id) {
        return repository.findById(id);
    }

    public Topico save(Topico topico) {
        return repository.save(topico);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

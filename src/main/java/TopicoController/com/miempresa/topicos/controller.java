package TopicoController.com.miempresa.topicos;

import TopicoService.com.miempresa.topicos.TopicoService;
import com.miempresa.topicos.model.Topico;
import com.miempresa.topicos.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos")
public class TopicoController {

    private final Topicoservice service;

    public TopicoController(Topicoservice service) {
        this.service = service;
    }

    @GetMapping
    public List<Topico> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Topico create(@Valid @RequestBody Topico topico) {
        return service.save(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> update(@PathVariable Long id, @Valid @RequestBody Topico topico) {
        return service.findById(id)
                .map(existing -> {
                    existing.setTitulo(topico.getTitulo());
                    existing.setDescripcion(topico.getDescripcion());
                    service.save(existing);
                    return ResponseEntity.ok(existing);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.findById(id)
                .map(existing -> {
                    service.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}

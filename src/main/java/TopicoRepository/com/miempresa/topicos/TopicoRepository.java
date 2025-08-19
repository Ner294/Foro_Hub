package TopicoRepository.com.miempresa.topicos;

import com.miempresa.topicos.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> { }

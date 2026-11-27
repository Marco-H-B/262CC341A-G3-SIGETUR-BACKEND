package pe.edu.uni.sigetur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.uni.sigetur.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { }

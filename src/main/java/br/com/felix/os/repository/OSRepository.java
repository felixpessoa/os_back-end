package br.com.felix.os.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.felix.os.domain.OS;

@Repository
public interface OSRepository extends JpaRepository<OS, Integer>{

}

package me.dio.domain.repository;

import me.dio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Corrigido para acessar propriedade aninhada
    Boolean existsByAccountNumber(String accountNumber); // CORRETO

}

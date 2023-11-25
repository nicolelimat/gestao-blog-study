package br.com.unifal.blog.repository;

import br.com.unifal.blog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> { // Jpa pede a entidade e o tipo da PK dele

}

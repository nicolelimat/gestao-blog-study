package br.com.unifal.blog.integration;

import br.com.unifal.blog.entity.User;
import br.com.unifal.blog.exception.UserNotFoundException;
import br.com.unifal.blog.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //
public class UserServiceIntegrationTest {

    @Autowired
    private UserService service;

    @Test
    @DisplayName("#findById > When the id is null > Thrown an exception")
    void findByIdWhenTheIdIsNullThrownAnException() {
        assertThrows(IllegalArgumentException.class, () ->
                service.findById(null));
    }

    @Test
    @DisplayName("#findById > When the id is not null > When a user is found > Return the user")
    void findByIdWhenTheIdIsNotNullWhenAUserIsFoundReturnTheUser() {
        User user = service.findById(6);  // o valor obrigatoriamente tem que ser válido
        Assertions.assertAll(
                () -> assertEquals(6, user.getId()),
                () -> assertEquals("Mrs. Dennis Schulist", user.getName()),
                () -> assertEquals("Leopoldo_Corkery", user.getUsername()),
                () -> assertEquals("Karley_Dach@jasper.info", user.getEmail()),
                () -> assertEquals("1-477-935-8478 x6430", user.getPhone()),
                () -> assertEquals("ola.org", user.getWebsite())
        );
    }

    @Test
    @DisplayName("#findById > When the id is not null > When no user is found > Throw an exception")
    void findByIdWhenTheIdIsNotNullWhenNoUserIsFoundThrowAnException() {
        Assertions.assertThrows(UserNotFoundException.class, () ->
                service.findById(11));
    }
}

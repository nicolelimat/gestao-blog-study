package br.com.unifal.blog.unit;

import br.com.unifal.blog.entity.User;
import br.com.unifal.blog.exception.UserNotFoundException;
import br.com.unifal.blog.repository.UserRepository;
import br.com.unifal.blog.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService service;

    @Mock // injetando o mock nele
    private UserRepository repository;
    @Test
    @DisplayName("#findById > When the id is null > Thrown an exception")
    void findByIdWhenTheIdIsNuLLThrowAnException() {
        assertThrows(IllegalArgumentException.class, () -> service.findById(null));
    }

    @Test
    @DisplayName("#findById > When the id is not null > When a user is found > Return the user")
    void findByIdWhenTheIdIsNotNullWhenAUserIsFoundReturnTheUser(){
        when(repository.findById(1)).thenReturn(Optional.of(User.builder()
                        .id(1)
                        .name("Nicole")
                        .username("nicolelima")
                .build()));
        User response = service.findById(1);
        assertAll(
                () -> assertEquals(1, response.getId()),
                () -> assertEquals("Nicole", response.getName()),
                () -> assertEquals("nicolelima", response.getUsername())
        );
    }

    @Test
    @DisplayName("#findById > When the id is not null > When no user is found > Throw an exception")
    void findByIdWhenTheIdIsNotNullWhenNoUserIsFoundThrowAnException(){
        when(repository.findById(2)).thenReturn(Optional.empty()); // retornando um valor vazio
        assertThrows(UserNotFoundException.class, () -> service.findById(2));
    }

    // TODO: Implement test cases for getAllUsers
    @Test 
    @DisplayName("#getAllUsers > When the list is not empty > Return a list of users")
    void getAllUsersWhenTheListIsNotEmptyReturnAListOfUsers() {
        List<User> allUsers = new ArrayList<>();
        allUsers.add(User.builder().id(0).name("Nicole").username("nicolelima").build());
        allUsers.add(User.builder().id(1).name("Taylor Swift").username("taylorswift13").build());
        allUsers.add(User.builder().id(2).name("Charmosa").username("charmosa_cat").build());
        allUsers.add(User.builder().id(3).name("Gatão").username("gatao_cat").build());

        when(service.getAllUsers()).thenReturn(allUsers);
        List<User> response = service.getAllUsers();
        assertAll(
                () -> assertEquals(4,response.size()),
                () -> assertEquals(0,response.get(0).getId()),
                () -> assertEquals("Taylor Swift",response.get(1).getName()),
                () -> assertEquals("Charmosa",response.get(2).getName()),
                () -> assertEquals("gatao_cat",response.get(3).getUsername())
        );

    }
}

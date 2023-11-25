package br.com.unifal.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity // bd, fala pro spring que isso é uma entidade
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db", name = "user") // bd, define que é uma tabela do banco de dados, seu scheema e seu usuário
public class User implements Serializable {

    @Id // mostra que é PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para iterar o id e passando a responsabilidae pro proprio mysql
    private Integer id;

    private String name;

    private String username;

    private String email;

    private String phone;

//    @Column(name = "website") // define como está no BD caso o nome esteja diferente
    private String website;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    // TODO: Add a list of comments
}

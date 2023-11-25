package br.com.unifal.blog.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "db", name = "comment")
public class Comment implements Serializable {

    @Id
    private Integer id;

    private String name;

    private String email;

    private String body;

    @ManyToOne // Muitos comentários pertencem a um post
    @JoinColumn(name = "post_id") // indica uma FK
    private Post post;
}

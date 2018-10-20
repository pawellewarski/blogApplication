package pl.akademiakodu.blogApplication.model.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 15)
    private String comment;

    @Embedded
    private AuditEntity auditEntity = new AuditEntity();

    @ManyToOne
    @JoinColumn (name = "postId")
    private Post post;


}

package pl.akademiakodu.blogApplication.model.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentDTO {

    private Long id;
    private String comment;
    private Date added;





}

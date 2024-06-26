package com.easylearn.usermicroservice.persistence;


import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "info")
public class UserEntity {

    @Id
    private String _id;
    @Id
    private String userId;
    @Field
    private String username;
    @Field
    private String role;
    @Field
    private String email;
    @Field
    private String password;
    @Field
    private String created_at;
    @Field
    private String updated_at;
    @Field
    private String avatar;
}

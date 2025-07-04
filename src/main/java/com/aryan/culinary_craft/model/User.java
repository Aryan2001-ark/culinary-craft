package com.aryan.culinary_craft.model;

import com.aryan.culinary_craft.util.IdGenerator;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Builder.Default
    private String id= IdGenerator.generateUUID();

    private String username;
    private String password; // encrypted
    private String role; // e.g., "USER" or "ADMIN"
    private boolean isEncrypted; // true if password is encrypted, false if not
}

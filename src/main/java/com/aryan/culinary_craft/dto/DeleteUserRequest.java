package com.aryan.culinary_craft.dto;

import lombok.Data;

@Data
public class DeleteUserRequest {
    private String usernameToDelete;
    private String requesterUsername;

}


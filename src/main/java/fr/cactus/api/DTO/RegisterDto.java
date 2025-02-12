package fr.cactus.api.dto;

public record RegisterDto(String username, String password, boolean isAdmin, String firstName, String lastName) {
    
}
package fr.cactus.api.dto;

public record RegisterDto(String firstName, String lastName, String username, boolean isAdmin, String password) {
    
}
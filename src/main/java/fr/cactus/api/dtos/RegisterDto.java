package fr.cactus.api.dtos;

public record RegisterDto(String firstName, String lastName, String username, boolean isAdmin, String password) {
    
}
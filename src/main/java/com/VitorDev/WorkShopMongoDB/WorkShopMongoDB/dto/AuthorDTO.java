package com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.dto;

import com.VitorDev.WorkShopMongoDB.WorkShopMongoDB.domain.User;

import java.util.Objects;

public class AuthorDTO {

    private String id;
    private String nome;

    public AuthorDTO(User user) {

        this.id = user.getId();
        this.nome = user.getNome();
    }

    public AuthorDTO( ) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AuthorDTO authorDTO)) return false;
        return Objects.equals(id, authorDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}

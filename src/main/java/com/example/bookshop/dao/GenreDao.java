package com.example.bookshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreDao extends JpaRepository<com.example.bookshop.entity.Genre , Integer> {
}

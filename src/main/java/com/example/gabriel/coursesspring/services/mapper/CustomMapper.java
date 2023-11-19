package com.example.gabriel.coursesspring.services.mapper;


/**
 * Este es un maooer que convertirá entitties a DTO
 * */
public interface CustomMapper <DTO, E>{
    public DTO toDTO(E e);

    public E toEntity(DTO dto);
}

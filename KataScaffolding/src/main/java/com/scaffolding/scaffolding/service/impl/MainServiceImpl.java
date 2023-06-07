package com.scaffolding.scaffolding.service.impl;

import com.scaffolding.scaffolding.dto.MainResponseDTO;
import com.scaffolding.scaffolding.service.IMainService;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements IMainService {
    @Override
    public MainResponseDTO getMethod() {
        return new MainResponseDTO("GET","Recuperar información");
    }

    @Override
    public MainResponseDTO postMethod() {
        return new MainResponseDTO("POST","Añadir información");
    }

    @Override
    public MainResponseDTO putMethod() {
        return new MainResponseDTO("PUT","Actualizar la información");
    }

    @Override
    public MainResponseDTO deleteMethod() {
        return new MainResponseDTO("DELETE","Eliminar información");
    }

    @Override
    public MainResponseDTO patchMethod() {
        return new MainResponseDTO("PATCH","Actualizar un campo");
    }

}

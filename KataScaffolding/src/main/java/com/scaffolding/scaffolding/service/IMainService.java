package com.scaffolding.scaffolding.service;

import com.scaffolding.scaffolding.dto.MainResponseDTO;

public interface IMainService {

    public MainResponseDTO getMethod();

    public MainResponseDTO postMethod();

    public MainResponseDTO putMethod();

    public MainResponseDTO deleteMethod();

    MainResponseDTO patchMethod();
}

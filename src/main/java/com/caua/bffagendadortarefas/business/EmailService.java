package com.caua.bffagendadortarefas.business;

import com.caua.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.caua.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviarEmail(TarefasDTOResponse dto) {emailClient.enviarEmail(dto);
    }
}
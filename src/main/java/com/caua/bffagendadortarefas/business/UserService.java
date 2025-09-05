package com.caua.bffagendadortarefas.business;


import com.caua.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.caua.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.caua.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.caua.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.caua.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.caua.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.caua.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.caua.bffagendadortarefas.infrastructure.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient client;

    public UsuarioDTOResponse saveUser(UsuarioDTORequest usuarioDTORequest){
        return client.saveUser(usuarioDTORequest);
    }

    public String loginUsuario(LoginRequestDTO dto){
        return client.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizaDadosUsuario(UsuarioDTORequest dto, String token){
        return client.atualizaDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(EnderecoDTORequest enderecoDTORequest, Long idEndereco, String token){
        return client.atualizaEndereco(enderecoDTORequest, idEndereco, token);
    }

    public TelefoneDTOResponse atualizaTelefone(TelefoneDTORequest dto, Long idTelefone, String token){
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTOResponse cadastraEndereco(EnderecoDTORequest dto, String token){
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(TelefoneDTORequest dto, String token){
        return client.cadastraTelefone(dto, token);
    }
}

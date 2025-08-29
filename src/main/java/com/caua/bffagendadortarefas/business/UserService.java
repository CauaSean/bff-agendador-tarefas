package com.caua.bffagendadortarefas.business;


import com.caua.bffagendadortarefas.business.dto.EnderecoDTO;
import com.caua.bffagendadortarefas.business.dto.TelefoneDTO;
import com.caua.bffagendadortarefas.business.dto.UsuarioDTO;
import com.caua.bffagendadortarefas.infrastructure.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserClient client;

    public UsuarioDTO saveUser(UsuarioDTO usuarioDTO){
        return client.saveUser(usuarioDTO);
    }

    public String loginUsuario(UsuarioDTO usuarioDTO){
        return client.login(usuarioDTO);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email, String token){
        return client.buscaUsuarioPorEmail(email, token);
    }

    public void deletarUsuarioPorEmail(String email, String token){
        client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizaDadosUsuario(UsuarioDTO usuarioDTO, String token){
        return client.atualizaDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTO atualizaEndereco(EnderecoDTO enderecoDTO, Long idEndereco, String token){
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizaTelefone(TelefoneDTO dto, Long idTelefone, String token){
        return client.atualizaTelefone(dto, idTelefone, token);
    }

    public EnderecoDTO cadastraEndereco(EnderecoDTO dto,String token){
        return client.cadastraEndereco(dto, token);
    }

    public TelefoneDTO cadastraTelefone(TelefoneDTO dto, String token){
        return client.cadastraTelefone(dto, token);
    }
}

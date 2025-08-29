package com.caua.bffagendadortarefas.infrastructure.client;


import com.caua.bffagendadortarefas.business.dto.EnderecoDTO;
import com.caua.bffagendadortarefas.business.dto.TelefoneDTO;
import com.caua.bffagendadortarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UserClient {

    @PostMapping
    UsuarioDTO saveUser(@RequestBody UsuarioDTO usuarioDTO);

    @PostMapping("/login")
    String login(@RequestBody UsuarioDTO usuarioDTO);

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
                                    @RequestHeader("Authorization") String token);

    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTO atualizaDadosUsuario(@RequestBody UsuarioDTO usuarioDTO,
                                    @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTO atualizaEndereco(@RequestBody EnderecoDTO dto,
                                 @RequestParam("id") Long id,
                                 @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTO atualizaTelefone(@RequestBody TelefoneDTO dto,
                                 @RequestParam("id") Long id,
                                 @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTO cadastraEndereco(@RequestBody EnderecoDTO dto,
                                 @RequestHeader("Authorization") String token);

    @PostMapping("/telefone")
    TelefoneDTO cadastraTelefone(@RequestBody TelefoneDTO dto,
                                 @RequestHeader("Authorization") String token);
}

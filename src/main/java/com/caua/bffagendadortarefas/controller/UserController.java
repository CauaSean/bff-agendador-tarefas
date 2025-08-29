package com.caua.bffagendadortarefas.controller;


import com.caua.bffagendadortarefas.business.dto.EnderecoDTO;
import com.caua.bffagendadortarefas.business.dto.TelefoneDTO;
import com.caua.bffagendadortarefas.business.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> saveUser(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(userService.saveUser(usuarioDTO));
    }

    @PostMapping("/login")
    public String login(@RequestBody UsuarioDTO usuarioDTO) {
        return userService(usuarioDTO);
    }

    @GetMapping
    public ResponseEntity<UsuarioDTO> buscaUsuarioPorEmail(@RequestParam("email") String email,
                                                           @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(userService.buscarUsuarioPorEmail(email, token));
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deletaUsuarioPorEmail(@PathVariable String email,
                                                      @RequestHeader ("Authorization") String token){
        userService.deletarUsuarioPorEmail(email, token);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UsuarioDTO> atualizaDadosUsuario(@RequestBody UsuarioDTO usuarioDTO,
                                                           @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(userService.atualizaDadosUsuario(token, usuarioDTO));
    }

    @PutMapping("/endereco")
    public ResponseEntity<EnderecoDTO> atualizaEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestParam ("id") Long id,
                                                        @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(userService.atualizaEndereco(id, dto, token));
    }

    @PutMapping("/telefone")
    public ResponseEntity<TelefoneDTO> atualizaTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestParam ("id") Long id,
                                                        @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(userService.atualizaTelefone(id, dto, token));
    }

    @PostMapping("/endereco")
    public ResponseEntity<EnderecoDTO> cadastraEndereco(@RequestBody EnderecoDTO dto,
                                                        @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(userService.cadastraEndereco(token, dto));
    }

    @PostMapping("/telefone")
    public ResponseEntity<TelefoneDTO> cadastraTelefone(@RequestBody TelefoneDTO dto,
                                                        @RequestHeader ("Authorization") String token){
        return ResponseEntity.ok(userService.cadastraTelefone(token, dto));
    }
}

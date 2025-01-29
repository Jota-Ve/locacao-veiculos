package br.com.ada.caixa.locacaoveiculo.controller;


import br.com.ada.caixa.locacaoveiculo.dto.request.CreateClientRequest;
import br.com.ada.caixa.locacaoveiculo.dto.request.UpdateClienteRequest;
import br.com.ada.caixa.locacaoveiculo.dto.response.ClientResponse;
import br.com.ada.caixa.locacaoveiculo.dto.response.IdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Operation(summary = "Registra um novo cliente", description = "Retorna o id do cleinte criado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Cliente criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação")
    })
    @PostMapping
    public ResponseEntity<IdResponse> create(@RequestBody CreateClientRequest usuario){
        var clienteResponse = new IdResponse(10L);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteResponse);
    }


    @GetMapping // GET http://localhost:8080/clientes
    public ResponseEntity<List<ClientResponse>> getAll(){
        var usuarios = List.of(new ClientResponse(10L, "Joao", "111", "joao@email.com"),
                               new ClientResponse(11L, "Vitor", "222", "vitor@email.com") );

        return ResponseEntity.ok(usuarios);
    }


    @GetMapping("/{clienteId}") // GET http://localhost:8080/clientes/123
    public ResponseEntity<ClientResponse> getById(@PathVariable(name = "clienteId") Long id){
        var usuario = new ClientResponse(id, "Joao", "111", "joao@email.com");
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Long id, @RequestBody UpdateClienteRequest usuario){
        var clienteResponse = new ClientResponse(10L, usuario.nome(), usuario.cpf(), null);
        return ResponseEntity.ok(clienteResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}

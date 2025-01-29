package br.com.ada.caixa.locacaoveiculo.controller;


import br.com.ada.caixa.locacaoveiculo.dto.request.CreateVeiculoRequest;
import br.com.ada.caixa.locacaoveiculo.dto.request.UpdateVeiculoRequest;
import br.com.ada.caixa.locacaoveiculo.dto.response.VeiculoResponse;
import br.com.ada.caixa.locacaoveiculo.dto.response.IdResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Operation(summary = "Registra um novo veículo", description = "Retorna o id do veículo criado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Veículo criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Erro de validação")
    })
    @PostMapping
    public ResponseEntity<IdResponse> create(@RequestBody CreateVeiculoRequest veiculo){
        var veiculoResponse = new IdResponse(10L);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoResponse);
    }
    
    
    @GetMapping("/{veiculoId}") // GET http://localhost:8080/veiculos/123
    public ResponseEntity<VeiculoResponse> getById(@PathVariable(name = "veiculoId") Long id){
        var veiculo = new VeiculoResponse(id, "ABC123", "BYD", "azul");
        return ResponseEntity.ok(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponse> update(@PathVariable Long id, @RequestBody UpdateVeiculoRequest veiculo){
        var veiculoResponse = new VeiculoResponse(10L, null, null, veiculo.cor());
        return ResponseEntity.ok(veiculoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }

}

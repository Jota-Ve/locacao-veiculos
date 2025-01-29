package br.com.ada.caixa.locacaoveiculo.dto.request;

public record CreateClientRequest(
    String nome,
    String cpf,
    String email,
    String senha) {

}

package com.baozistore.controller;

import com.baozistore.model.Pedido;
import com.baozistore.repository.PedidoRepository;
import com.baozistore.repository.ClienteRepository;
import com.baozistore.repository.ProdutoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoController(
            PedidoRepository pedidoRepository,
            ClienteRepository clienteRepository,
            ProdutoRepository produtoRepository) {

        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    // Criar pedido
    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Pedido pedido) {

        if (pedido.getClienteId() == null ||
                !clienteRepository.existsById(pedido.getClienteId())) {
            return ResponseEntity.badRequest()
                    .body("Cliente não encontrado.");
        }

        if (pedido.getProdutoId() == null ||
                !produtoRepository.existsById(pedido.getProdutoId())) {
            return ResponseEntity.badRequest()
                    .body("Produto não encontrado.");
        }

        if (pedido.getQuantidade() == null ||
                pedido.getQuantidade() <= 0) {
            return ResponseEntity.badRequest()
                    .body("Quantidade deve ser maior que zero.");
        }

        pedido.setId(null);

        return ResponseEntity.ok(pedidoRepository.save(pedido));
    }

    // Listar pedidos
    @GetMapping
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    // Buscar pedido pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
        return pedidoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Excluir pedido
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {

        if (!pedidoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        pedidoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

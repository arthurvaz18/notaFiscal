package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.Repository.ClienteRepository;
import com.sonner.notaFiscal.Repository.NotaFiscalRepository;
import com.sonner.notaFiscal.Repository.ProdutoRepository;
import com.sonner.notaFiscal.model.Cliente;
import com.sonner.notaFiscal.model.ItensNota;
import com.sonner.notaFiscal.model.NotaFiscal;
import com.sonner.notaFiscal.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public NotaFiscal criarNotaFiscal(NotaFiscal notaFiscal) {
        BigDecimal valorTotal = BigDecimal.ZERO;

        // Buscar cliente único pelo código exato
        String codigoCliente = notaFiscal.getCliente().getCodigoCliente();
        Cliente cliente = clienteRepository.findOneByCodigoCliente(codigoCliente)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        notaFiscal.setCliente(cliente);

        for (ItensNota item : notaFiscal.getItens()) {
            String codigoProduto = item.getProduto().getCodigoProduto();
            Produto produto = produtoRepository.findOneByCodigoProduto(codigoProduto)
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            item.setProduto(produto);
            item.setValorTotal(produto.getValorProduto().multiply(BigDecimal.valueOf(item.getQuantidadeProduto())));
            item.setNotaFiscal(notaFiscal);

            valorTotal = valorTotal.add(item.getValorTotal());
        }

        notaFiscal.setValorNotaFiscal(valorTotal);
        return notaFiscalRepository.save(notaFiscal);
    }


    @Override
    public List<NotaFiscal> listarNotas() {
        return notaFiscalRepository.findAll();
    }

    @Override
    public Optional<NotaFiscal> buscarNotaPorId(Integer id) {
        return notaFiscalRepository.findById(id);
    }

    @Override
    public void deletarNota(Integer id) {
        notaFiscalRepository.deleteById(id);
    }
}

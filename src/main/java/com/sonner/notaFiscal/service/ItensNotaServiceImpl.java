package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.Repository.ItensNotaRepository;
import com.sonner.notaFiscal.Repository.ProdutoRepository;
import com.sonner.notaFiscal.model.ItensNota;
import com.sonner.notaFiscal.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ItensNotaServiceImpl implements ItensNotaService {


    @Autowired
    private ItensNotaRepository itensNotaRepository;

    public ItensNotaServiceImpl(ItensNotaRepository itensNotaRepository) {
        this.itensNotaRepository = itensNotaRepository;
    }

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<ItensNota> listarTodos() {
        return itensNotaRepository.findAll();
    }

    @Override
    public Optional<ItensNota> buscarPorId(Integer id) {
        return itensNotaRepository.findById(id);
    }

    @Override
    public List<ItensNota> listarPorNotaFiscal(Integer notaFiscalId) {
        return itensNotaRepository.findByNotaFiscalId(notaFiscalId);
    }

    @Override
    public ItensNota atualizarItem(Integer id, ItensNota itemAtualizado) {
        ItensNota item = itensNotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        Produto produto = produtoRepository.findById(itemAtualizado.getProduto().getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        item.setOrdemNota(itemAtualizado.getOrdemNota());
        item.setProduto(produto);
        item.setQuantidadeProduto(itemAtualizado.getQuantidadeProduto());
        item.setValorTotal(produto.getValorProduto().multiply(BigDecimal.valueOf(itemAtualizado.getQuantidadeProduto())));

        return itensNotaRepository.save(item);
    }

    @Override
    public void deletarItem(Integer id) {
        itensNotaRepository.deleteById(id);
    }
}

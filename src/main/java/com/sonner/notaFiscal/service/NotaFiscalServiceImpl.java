package com.sonner.notaFiscal.service;

import com.sonner.notaFiscal.Repository.NotaFiscalRepository;
import com.sonner.notaFiscal.model.Cliente;
import com.sonner.notaFiscal.model.NotaFiscal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {

    @Autowired
    NotaFiscalRepository notaFiscalRepository;

    public NotaFiscalServiceImpl(NotaFiscalRepository notaFiscalRepository) {
        this.notaFiscalRepository = notaFiscalRepository;
    }

    @Override
    public NotaFiscal salvar(NotaFiscal notaFiscal) {
        BigDecimal total = notaFiscal.getItens().stream()
                .map(item->{
                    BigDecimal valorTotal = item.getProduto().getValorProduto().multiply(new BigDecimal(item.getQuantidadeProduto()));
                    item.setValorTotal(valorTotal);
                    item.setNotaFiscal(notaFiscal);
                    return valorTotal;
        })
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return notaFiscalRepository.save(notaFiscal);
    }

    @Override
    public Optional<NotaFiscal> buscarPorId(Integer id) {
        return notaFiscalRepository.findById(id);
    }

    @Override
    public NotaFiscal atualizar(Integer id, NotaFiscal notaFiscal) {
        NotaFiscal existente = notaFiscalRepository.findById(id).orElse(null);
        notaFiscal.setId(existente.getId());
        return notaFiscalRepository.save(notaFiscal);
    }

    @Override
    public List<NotaFiscal> buscarNotaFiscal(Integer id, LocalDate dataNotaFiscal, Cliente cliente) {
        if (id != null && dataNotaFiscal != null && cliente != null) {
            return notaFiscalRepository.findByIdAndDataNotaFiscalAndCliente(id, dataNotaFiscal, cliente);
        }

        if (id != null && dataNotaFiscal != null) {
            return notaFiscalRepository.findByIdAndDataNotaFiscal(id, dataNotaFiscal);
        }

        if (id != null && cliente != null) {
            return notaFiscalRepository.findByIdAndCliente(id, cliente);
        }

        if (dataNotaFiscal != null && cliente != null) {
            return notaFiscalRepository.findByDataNotaFiscalAndCliente(dataNotaFiscal, cliente);
        }

        if (id != null) {
            return notaFiscalRepository.findById(id)
                    .map(Collections::singletonList)
                    .orElse(Collections.emptyList());
        }

        if (dataNotaFiscal != null) {
            return notaFiscalRepository.findByDataNotaFiscal(dataNotaFiscal);
        }

        if (cliente != null) {
            return notaFiscalRepository.findByCliente(cliente);
        }

        return notaFiscalRepository.findAll();
    }


    @Override
    public void deletarNotaFiscal(NotaFiscal notaFiscal) {
        notaFiscalRepository.delete(notaFiscal);
    }



}

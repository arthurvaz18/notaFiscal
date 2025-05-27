package com.sonner.notaFiscal.Repository;

import com.sonner.notaFiscal.model.ItensNota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItensNotaRepository extends JpaRepository<ItensNota, Integer> {
    List<ItensNota> findByNotaFiscalId(Integer notaFiscalId);
}

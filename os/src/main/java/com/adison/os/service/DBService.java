package com.adison.os.service;

import com.adison.os.domain.Cliente;
import com.adison.os.domain.OrdemDeServico;
import com.adison.os.domain.Tecnico;
import com.adison.os.domain.enums.Prioridade;
import com.adison.os.domain.enums.Status;
import com.adison.os.repositorie.ClienteRepository;
import com.adison.os.repositorie.OrdemDeServicoRepository;
import com.adison.os.repositorie.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {
    private final TecnicoRepository tecnicoRepository;

    private final ClienteRepository clienteRepository;

    private final OrdemDeServicoRepository ordemDeServicoRepository;
    @Autowired
    public DBService(TecnicoRepository tecnicoRepository, ClienteRepository clienteRepository,
                             OrdemDeServicoRepository ordemDeServicoRepository) {
        this.tecnicoRepository = tecnicoRepository;
        this.clienteRepository = clienteRepository;
        this.ordemDeServicoRepository = ordemDeServicoRepository;
    }
    public void instanciaDB(){
        Tecnico t1 = new Tecnico(null, "Adison Soares", "069.920.090-36", "(61) 92644-9765");
        Cliente c1 = new Cliente(null, "Betina Campos", "747.525.710-05", "(61) 93552-5880");
        OrdemDeServico os1 = new OrdemDeServico(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);

        t1.getList().add(os1);
        c1.getList().add(os1);

        tecnicoRepository.saveAll(List.of(t1));
        clienteRepository.saveAll(List.of(c1));
        ordemDeServicoRepository.saveAll(List.of(os1));
    }
}

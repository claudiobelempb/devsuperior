package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.RelatorioVendasDTO;
import com.devsuperior.dsmeta.dto.SumarioVendasDTO;
import com.devsuperior.dsmeta.projections.RelatorioVendasProjection;
import com.devsuperior.dsmeta.projections.SumarioVendasProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	@Transactional(readOnly = true)
	public List<RelatorioVendasDTO> relatorioVenda(LocalDate dataStart, LocalDate dataEnd, String name) {
		List<RelatorioVendasProjection> list = repository.searchReportSale(dataStart, dataEnd, name);
		return list.stream().map(x -> new RelatorioVendasDTO(x.getId(), x.getdate(), x.getDeals(), x.getname())).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public List<RelatorioVendasDTO> relatorioVendaJPQL(LocalDate dataStart, LocalDate dataEnd, String name) {
		return repository.searchReportDate(dataStart, dataEnd, name);
	}

	public Page<RelatorioVendasDTO> relatorioVendaPaginado(String dateStart, String dateEnd, String nome, Pageable pegeable) {
		LocalDate dStart, dEnd;
		if (dateEnd == null) {
			dEnd = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			dStart = dEnd.minusYears(1L);
		} else {
			dStart = LocalDate.parse(dateStart);
			dEnd = LocalDate.parse(dateEnd);
		}

		Page<RelatorioVendasProjection> resultadoVenda = repository.searchReportSalePagination(dStart, dEnd, nome, pegeable);
		return resultadoVenda.map(x -> new RelatorioVendasDTO(x.getId(), x.getdate(), x.getDeals(), x.getname()));
	}

	public List<SumarioVendasDTO> sumarioVenda(String dateStart, String dateEnd) {
		LocalDate dStart, dEnd;
		if (dateEnd == null) {
			dEnd = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
			dStart = dEnd.minusYears(1L);
		} else {
			dStart = LocalDate.parse(dateStart);
			dEnd = LocalDate.parse(dateEnd);
		}

		List<SumarioVendasProjection> resultadoSumario = repository.searchSummarySale(dStart, dEnd);
		return resultadoSumario.stream().map(x -> new SumarioVendasDTO(x.getName(), x.getSum())).collect(Collectors.toList());

	}
}

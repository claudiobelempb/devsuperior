package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.RelatorioVendasDTO;
import com.devsuperior.dsmeta.projections.RelatorioVendasProjection;
import com.devsuperior.dsmeta.projections.SumarioVendasProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query(nativeQuery = true, value = "SELECT TB_SALES .ID,DATE,DEALS,NAME FROM TB_SALES "
            + "INNER JOIN TB_SELLER ON (TB_SALES.SELLER_ID = TB_SELLER.ID) "
            + "WHERE DATE BETWEEN :dateStart AND :dateEnd AND UPPER(NAME) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<RelatorioVendasProjection> searchReportSale(LocalDate dateStart, LocalDate dateEnd, String name);

    @Query(value = "SELECT new com.devsuperior.dsmeta.dto.RelatorioVendasDTO(obj.id, obj.date, obj.deals, obj.seller.name) "
            + "FROM Sale obj "
            + "WHERE obj.date BETWEEN :dateStart AND :dateEnd "
            + "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    List<RelatorioVendasDTO> searchReportDate(LocalDate dateStart, LocalDate dateEnd, String name);

    @Query(value = "SELECT new com.devsuperior.dsmeta.dto.RelatorioVendasDTO(obj.id, obj.date, obj.deals, obj.seller.name) "
            + "FROM Sale obj "
            + "WHERE obj.date BETWEEN :dateStart AND :dateEnd "
            + "AND UPPER(obj.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))")
    Page<RelatorioVendasProjection> searchReportSalePagination(LocalDate dateStart, LocalDate dateEnd, String name, Pageable pegeable);

    @Query(value = "SELECT new com.devsuperior.dsmeta.dto.SumarioVendasDTO(obj.seller.name, SUM(obj.amount)) "
            + "FROM Sale obj "
            + "WHERE obj.date BETWEEN :dateStart AND :dateEnd "
            + "GROUP BY obj.seller.name")
    List<SumarioVendasProjection> searchSummarySale(LocalDate dateStart, LocalDate dateEnd);

}

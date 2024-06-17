//package br.com.api.shopping.repositories.implement;
//
//import br.com.api.shopping.dto.ShopReportDTO;
//import br.com.api.shopping.model.Shop;
//import br.com.api.shopping.repositories.IReportRepository;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;
//
//import java.math.BigInteger;
//import java.time.LocalDate;
//import java.util.List;
//
//public class ReportRepositoryImpl implements IReportRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Shop> getShopByFilters(LocalDate dataInicio, LocalDate dataFim, Float valorMinimo) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("select s ");
//        sb.append("from shop s ");
//        sb.append("where s.date >= :dataInicio ");
//
//        if (dataFim != null) {
//            sb.append("and s.date <= :dataFim ");
//        }
//
//        if (valorMinimo != null) {
//            sb.append("and s.total <= :valorMinimo ");
//        }
//
//        Query query = entityManager.createQuery(sb.toString());
//        query.setParameter("dataInicio",
//                dataInicio.atTime(0, 0));
//
//        if (dataFim != null) {
//            query.setParameter("dataFim",
//                    dataFim.atTime(23, 59));
//        }
//
//        if (valorMinimo != null) {
//            query.setParameter("valorMinimo", valorMinimo);
//        }
//        return query.getResultList();
//    }
//
//    @Override
//    public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim) {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
//        sb.append("from shopping.shop sp ");
//        sb.append("where  sp.date >= :dataInicio ");
//        sb.append("and sp.date <= :dataFim ");
//
//        Query nativeQuery = entityManager.createNativeQuery(sb.toString());
//        nativeQuery.setParameter("dataInicio", dataInicio.atTime(0, 0));
//        nativeQuery.setParameter("dataFim", dataFim.atTime(23, 59));
//
//        Object[] result = (Object[]) nativeQuery.getSingleResult();
//
//        return ShopReportDTO.builder()
//                .count(((BigInteger) result[0]).intValue())
//                .total((Double) result[1])
//                .mean((Double) result[2])
//                .build();
//
//    }
//}

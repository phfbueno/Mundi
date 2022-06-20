package br.com.alura.mvc.mudi.repository;

import java.util.List;

import br.com.alura.mvc.mudi.enums.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	

	List<Pedido> findByStatusPedido(StatusPedido statusPedido, Pageable sort);

	@Query("select p from Pedido p join p.usuario u where u.username = :username ")
	List<Pedido> findAllByUsuario(@Param("username")String username);

	@Query("select p from Pedido p join p.usuario u where u.username = :username and p.statusPedido = :statusPedido")
	List<Pedido> findByStatusEUsuario(@Param("statusPedido")StatusPedido statusPedido, @Param("username")String username);

}

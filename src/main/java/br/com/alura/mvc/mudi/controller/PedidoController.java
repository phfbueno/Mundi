package br.com.alura.mvc.mudi.controller;

import javax.validation.Valid;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedidoDto;
import br.com.alura.mvc.mudi.model.Usuario;
import br.com.alura.mvc.mudi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private UsuarioRepository userRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedidoDto requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedidoDto requisicao, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Usuario usuario = userRepository.findByUsername(username);
		Pedido pedido = requisicao.newPedido();
		pedido.setUsuario(usuario);
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}
}

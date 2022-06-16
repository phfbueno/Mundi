package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedidoDto;
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.Usuario;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedidoDto requisicaoNovoPedidoDto ){
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedidoDto requisicaoNovoPedidoDto, BindingResult result) {

        if(result.hasErrors()) {
            return "pedido/formulario";
        }


        Usuario user = usuarioRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        Pedido pedido = requisicaoNovoPedidoDto.newPedido();
        pedido.setUsuario(user);
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}

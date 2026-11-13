package br.com.rotaurbana.controller;

import br.com.rotaurbana.model.dto.UsuarioDTO;
import br.com.rotaurbana.model.entity.Usuario;
import br.com.rotaurbana.model.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("formulario-usuario");
        return mv;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid UsuarioDTO usuarioDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/rota");
        }
        Usuario usuario = new Usuario(usuarioDTO);
        usuarioRepository.save(usuario);
        ModelAndView mv = new ModelAndView("redirect:/usuario");
        return mv;
    }

    @GetMapping
    public ModelAndView consultar() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        ModelAndView mv = new ModelAndView("usuarios");
        mv.addObject("usuarios", usuarios);
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo(@PathVariable Long codigo) {
        Usuario usuario = usuarioRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario-usuario");
        mv.addObject("usuario", usuario);
        mv.addObject("acao", "/usuario/atualizar/" + codigo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public  ModelAndView excluir(@PathVariable Long codigo) {
        usuarioRepository.deleteById(codigo);
        ModelAndView mv = new ModelAndView("redirect:/usuario");
        return mv;
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable Long codigo,
                                  @Valid UsuarioDTO usuarioDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/usuario");
        }
        Usuario usuario = new Usuario(usuarioDTO);
        usuario.setCodigo(codigo);
        usuarioRepository.save(usuario);
        ModelAndView mv = new ModelAndView("redirect:/usuario");
        return mv;
    }
}

package br.com.rotaurbana.controller;

import br.com.rotaurbana.model.dto.ChamadoDTO;
import br.com.rotaurbana.model.entity.Chamado;
import br.com.rotaurbana.model.repository.ChamadoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoRepository chamadoRepository;

    @GetMapping("/novo")
    public ModelAndView novo(ChamadoDTO chamadoDTO) {
        ModelAndView mv = new ModelAndView("formulario-chamado");
        return mv;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid ChamadoDTO chamadoDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("formulario-chamado");
        }
        Chamado chamado = new Chamado(chamadoDTO);
        chamadoRepository.save(chamado);
        return new ModelAndView("redirect:/chamado");
    }

    @GetMapping
    public ModelAndView consultar() {
        List<Chamado> chamados = chamadoRepository.findAll();
        ModelAndView mv = new ModelAndView("chamados");
        mv.addObject("chamados", chamados);
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo(@PathVariable Long codigo) {
        Chamado chamado = chamadoRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario-chamado");
        mv.addObject("chamado", chamado);
        mv.addObject("acao", "/chamado/atualizar/" + codigo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public ModelAndView excluir(@PathVariable Long codigo) {
        chamadoRepository.deleteById(codigo);
        return new ModelAndView("redirect:/chamado");
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable Long codigo,
                                  @Valid ChamadoDTO chamadoDTO, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mv = new ModelAndView("formulario-chamado");
            mv.addObject("acao", "/chamado/atualizar/" + codigo);
            return mv;
        }
        Chamado chamado = new Chamado(chamadoDTO);
        chamado.setCodigo(codigo);
        chamadoRepository.save(chamado);
        return new ModelAndView("redirect:/chamado");
    }
}
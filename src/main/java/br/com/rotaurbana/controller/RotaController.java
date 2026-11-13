package br.com.rotaurbana.controller;

import br.com.rotaurbana.model.dto.RotaDTO;
import br.com.rotaurbana.model.entity.Rota;
import br.com.rotaurbana.model.repository.RotaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/rota")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;

    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("formulario-rota");
        return mv;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid RotaDTO rotaDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/rota");
        }
        Rota rota = new Rota(rotaDTO);
        rotaRepository.save(rota);
        ModelAndView mv = new ModelAndView("redirect:/rota");
        return mv;
    }

    @GetMapping
    public  ModelAndView consultar() {
        List<Rota> rotas = rotaRepository.findAll();
        ModelAndView mv = new ModelAndView("rotas");
        mv.addObject("rotas", rotas);
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo(@PathVariable Long codigo) {
        Rota rota = rotaRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario-rota");
        mv.addObject("rota", rota);
        mv.addObject("acao", "/rota/atualizar/" + codigo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public ModelAndView excluir(@PathVariable Long codigo) {
        rotaRepository.deleteById(codigo);
        ModelAndView mv = new ModelAndView("redirect:/rota");
        return mv;
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable Long codigo,
                                  @Valid RotaDTO rotaDTO, BindingResult result){
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/rota");
        }
        Rota rota = new Rota(rotaDTO);
        rota.setCodigo(codigo);
        rotaRepository.save(rota);
        ModelAndView mv = new ModelAndView("redirect:/rota");
        return mv;
    }
}

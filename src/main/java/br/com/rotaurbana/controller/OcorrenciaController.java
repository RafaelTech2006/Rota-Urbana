package br.com.rotaurbana.controller;

import br.com.rotaurbana.model.dto.OcorrenciaDTO;
import br.com.rotaurbana.model.entity.Ocorrencia;
import br.com.rotaurbana.model.repository.OcorrenciaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @GetMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("formulario-ocorrencia");
        return mv;
    }

    @PostMapping
    public ModelAndView cadastrar(@Valid OcorrenciaDTO ocorrenciaDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/ocorrencia");
        }
        Ocorrencia ocorrencia = new Ocorrencia(ocorrenciaDTO);
        ocorrenciaRepository.save(ocorrencia);
        ModelAndView mv = new ModelAndView("redirect:/ocorrencia");
        return mv;
    }

    @GetMapping
    public ModelAndView consultar() {
        List<Ocorrencia> ocorrencias = ocorrenciaRepository.findAll();
        ModelAndView mv = new ModelAndView("ocorrencias");
        mv.addObject("ocorrencias", ocorrencias);
        return mv;
    }

    @GetMapping("/editar/{codigo}")
    public ModelAndView consultarPorCodigo(@PathVariable Long codigo) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("formulario-ocorrencia");
        mv.addObject("ocorrencia", ocorrencia);
        mv.addObject("acao", "/ocorrencia/atualizar/" + codigo);
        return mv;
    }

    @GetMapping("/excluir/{codigo}")
    public ModelAndView excluir(@PathVariable Long codigo){
        ocorrenciaRepository.deleteById(codigo);
        ModelAndView mv = new ModelAndView("redirect:/ocorrencia");
        return mv;
    }

    @PostMapping("/atualizar/{codigo}")
    public ModelAndView atualizar(@PathVariable Long codigo,
                                  @Valid OcorrenciaDTO ocorrenciaDTO, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("redirect:/ocorrencia");
        }
        Ocorrencia ocorrencia = new Ocorrencia(ocorrenciaDTO);
        ocorrencia.setCodigo(codigo);
        ocorrenciaRepository.save(ocorrencia);
        ModelAndView mv = new ModelAndView("redirect:/ocorrencia");
        return mv;
    }
}

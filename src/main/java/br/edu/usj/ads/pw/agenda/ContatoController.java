package br.edu.usj.ads.pw.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ContatoController {

    @Autowired
    ContatoRepository contatoRepository;
    
    @GetMapping(value="/")
    public ModelAndView getIndex() {
        List<Contato> lista = contatoRepository.findAll();


    
    ModelAndView modelAndView = new ModelAndView("index");
    modelAndView.addObject("lista_contatos", lista);
    return modelAndView;

    }

    @PostMapping(value="/cadastro")
    public String postCadastro(Contato contatoNovo){

        //gravanod no banco 
        contatoRepository.save(contatoNovo);

        return "redirect:/";
    }
        
        @GetMapping(value="/cadastrar")
        public ModelAndView getCadastrar() {

            ModelAndView modelAndView = new ModelAndView("formulario");
            return  modelAndView;
        
        
        }


}



package br.edu.usj.ads.pw.agenda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        
    @GetMapping(value="/cadastrar")
    public ModelAndView getCadastrar() {
        //Contato contato = new Contato();
        ModelAndView modelAndView = new ModelAndView("formulario");
        
        //modelAndView.addObject("dados_contato", contato);
        return  modelAndView;
        
        
    }
    
    @PostMapping(value="/cadastro")
    public String postCadastro(Contato contatoNovo){

        //gravanod no banco 
        contatoRepository.save(contatoNovo);

        return "redirect:/";
    }
    @GetMapping(value="/detalhes/{id}")
    public ModelAndView getDetalhes(@PathVariable Long id) {
        Contato contato = contatoRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("detalhes");
        modelAndView.addObject("dados_contato", contato);

        return modelAndView;
    }

    @GetMapping(value="/deletar/{id}")
    public String getDeletar(@PathVariable Long id ) {
        contatoRepository.deleteById(id);
        
        return "redirect:/";
    }

    @GetMapping(value="/editar/{id}")
    public ModelAndView getEditar(@PathVariable Long id) {
        //ler registro do banco
        Contato contato = contatoRepository.findById(id).get();

        ModelAndView modelAndView = new ModelAndView("formulario");

        modelAndView.addObject("dados_contato", contato);
        
        return modelAndView;
    }
    
    
    

}



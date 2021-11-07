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
    public String postCadastro(String nome, String tipo, String telefone, String email ){
        Contato contatoNovo = new Contato();
        contatoNovo.setId(null);
        contatoNovo.setNome(nome);
        contatoNovo.setTipo(tipo);
        contatoNovo.setTelefone(telefone);
        contatoNovo.setEmail(email);

        //gravanod no banco 
        contatoRepository.save(contatoNovo);

        return "redirect:/";
    }

}

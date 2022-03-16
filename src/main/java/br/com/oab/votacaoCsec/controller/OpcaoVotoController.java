package br.com.oab.votacaoCsec.controller;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.OpcoesVoto;
import br.com.oab.votacaoCsec.service.OpcaoVotoService;
import br.com.oab.votacaoCsec.service.OpcoesVotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OpcaoVotoController {
	
	@Autowired
	OpcoesVotoService opcoesVotoService;

	@Autowired
	OpcaoVotoService opcaoVotoService;
	
	@RequestMapping(value = "/new/opcoes-voto", method = RequestMethod.GET)
	public String getOpcoesVotoForm () {
		return "opcoesVotoForm";
	}
	
	@RequestMapping(value = "/new/opcao-voto", method = RequestMethod.POST)
	public String saveOpcaoVoto (@Validated OpcaoVoto opcaoVoto, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios " +
					"foram preenchidos");

			return "redirect:/new/opcao-voto";
		}



		opcaoVotoService.save(opcaoVoto);
		return "redirect:/new/opcao-voto";
		
	}

	@RequestMapping(value = "/new/opcao-voto", method = RequestMethod.POST)
	public String guardarVotoVotante (@Validated OpcaoVoto opcaoVoto, BindingResult result, RedirectAttributes attributes) {


		opcaoVotoService.save(opcaoVoto);
		return "redirect:/new/opcao-voto";

	}

}

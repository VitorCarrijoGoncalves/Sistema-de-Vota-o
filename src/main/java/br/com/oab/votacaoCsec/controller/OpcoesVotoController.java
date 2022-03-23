package br.com.oab.votacaoCsec.controller;

import br.com.oab.votacaoCsec.enums.StatusSessaoEnum;
import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.OpcoesVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.service.OpcaoVotoService;
import br.com.oab.votacaoCsec.service.OpcoesVotoService;
import br.com.oab.votacaoCsec.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
public class OpcoesVotoController {
	
	@Autowired
	OpcoesVotoService opcoesVotoService;

	@Autowired
	OpcaoVotoService opcaoVotoService;
	
//	@RequestMapping(value = "/new/opcoes-voto", method = RequestMethod.GET)
//	public String getOpcoesVotoForm () {
//		return "opcoesVotoForm";
//	}
	
	@RequestMapping(value = "/new/opcoes-voto", method = RequestMethod.POST)
	public String saveOpcoesVoto (@Validated OpcoesVoto opcoesVoto, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios " +
					"foram preenchidos");

			return "redirect:/new/opcoes-voto";
		}



		opcoesVotoService.save(opcoesVoto);
		return "redirect:/new/opcoes-voto";
		
	}
	
}

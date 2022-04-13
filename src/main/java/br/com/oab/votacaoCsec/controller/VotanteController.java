package br.com.oab.votacaoCsec.controller;

import java.util.List;

import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.OpcoesVoto;
import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.repository.OpcaoVotoListVotanteRepository;
import br.com.oab.votacaoCsec.service.OpcaoVotoListVotanteService;
import br.com.oab.votacaoCsec.service.OpcaoVotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.oab.votacaoCsec.models.Votante;
import br.com.oab.votacaoCsec.service.VotanteService;

@Controller
public class VotanteController {

	@Autowired
	VotanteService votanteService;

	@Autowired
	OpcaoVotoListVotanteService opcaoVotoListVotanteService;

	@RequestMapping(value = "/votantes", method = RequestMethod.GET)
	public ModelAndView getVotantes() {
		ModelAndView mv = new ModelAndView("votantes");
		List<Votante> votantes = votanteService.findAll();
		mv.addObject("votantes", votantes);
		return mv;
	}

	@RequestMapping(value = "/votante/{id}", method = RequestMethod.GET)
	public ModelAndView getVotanteDetails (@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("votanteDetails");
		Votante votante = votanteService.findById(id);
		mv.addObject("votante", votante);
		return mv;
	}

	@RequestMapping(value = "/newvotante", method = RequestMethod.GET)
	public String getVotanteForm () {
		return "votanteForm";
	}

	@RequestMapping(value = "/newvotante", method = RequestMethod.POST)
	public String saveVotante (@Validated Votante votante, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "redirect:/newvotante";
		}

		votanteService.save(votante);
		return "redirect:/votantes";

	}

	/* Método criado para que o requerente, na tela em que ele votar, ele possa informar o seu voto e o método precisa também
	* receber a sessão aqui, para computar o voto do requerente no sistema.*/
	@RequestMapping(value = "/sessao/votar", method = RequestMethod.POST)
	public String guardarVotoVotante (@Validated Votante votante, Sessao sessao, OpcaoVoto opcaoVoto,
									  BindingResult result, RedirectAttributes attributes) {

		votante.setIdOpcaoVoto(opcaoVoto);

		/* Ver em qual view devo retornar, em casos em que ocorre erro. Adaptar a validação para que ela funcione com
		* sessões onde pode a mesma pessoa pode votar mais de uma vez nela.*/
		if (votanteService.isVotanteNaoVotou(votante.getId(), sessao)) {
			return "redirect:/new/opcao-voto";
		}

		opcaoVotoListVotanteService.save(opcaoVoto);
		return "redirect:/new/opcao-voto";

	}




}

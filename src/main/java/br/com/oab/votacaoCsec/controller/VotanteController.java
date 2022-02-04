package br.com.oab.votacaoCsec.controller;

import java.util.List;

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
import br.com.oab.votacaoCsec.service.EleitorService;

@Controller
public class VotanteController {

	@Autowired
	EleitorService eleitorService;

	@RequestMapping(value = "/eleitores", method = RequestMethod.GET)
	public ModelAndView getEleitores() {
		ModelAndView mv = new ModelAndView("eleitores");
		List<Votante> eleitores = eleitorService.findAll();
		mv.addObject("eleitores", eleitores);
		return mv;
	}

	@RequestMapping(value = "/eleitores/{id}", method = RequestMethod.GET)
	public ModelAndView getEleitorDetails (@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("eleitorDetails");
		Votante eleitor = eleitorService.findById(id);
		mv.addObject("eleitor", eleitor);
		return mv;
	}

	@RequestMapping(value = "/neweleitor", method = RequestMethod.GET)
	public String getEleitorForm () {
		return "eleitorForm";
	}

	@RequestMapping(value = "/neweleitor", method = RequestMethod.POST)
	public String saveEleitor (@Validated Votante eleitor, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "redirect:/neweleitor";
		}

		eleitorService.save(eleitor);
		return "redirect:/eleitores";

	}

}

package br.com.oab.votacaoCsec.controller;

import java.util.List;

import br.com.oab.votacaoCsec.models.Fiscal;
import br.com.oab.votacaoCsec.service.FiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FiscalController {

	@Autowired
	FiscalService mesarioService;

	@RequestMapping(value = "/mesarios", method = RequestMethod.GET)
	public ModelAndView getSessoes() {
		ModelAndView mv = new ModelAndView("mesarios");
		List<Fiscal> mesarios = mesarioService.findAll();
		mv.addObject("mesarios", mesarios);
		return mv;
	}

	@RequestMapping(value = "/mesarios/{id}", method = RequestMethod.GET)
	public ModelAndView getSessaoDetails (@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("mesarioDetails");
		Fiscal mesario = mesarioService.findById(id);
		mv.addObject("mesario", mesario);
		return mv;
	}

	@RequestMapping(value = "/newmesario", method = RequestMethod.GET)
	public String getMesarioForm () {
		return "mesarioForm";
	}

	@RequestMapping(value = "/newmesario", method = RequestMethod.POST)
	public String saveMesario (@Validated Fiscal mesario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "redirect:/newmesario";
		}

//		sessao.setDataSessao(LocalDate.now());
		mesarioService.save(mesario);
		return "redirect:/mesarios";

	}

}

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
	FiscalService fiscalService;

	@RequestMapping(value = "/fiscais", method = RequestMethod.GET)
	public ModelAndView getFiscais() {
		ModelAndView mv = new ModelAndView("fiscais");
		List<Fiscal> fiscais = fiscalService.findAll();
		mv.addObject("fiscais", fiscais);
		return mv;
	}

	@RequestMapping(value = "/fiscais/{id}", method = RequestMethod.GET)
	public ModelAndView getFiscalDetails (@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("fiscalDetails");
		Fiscal fiscal = fiscalService.findById(id);
		mv.addObject("fiscal", fiscal);
		return mv;
	}

	@RequestMapping(value = "/newfiscal", method = RequestMethod.GET)
	public String getFiscalForm () {
		return "fiscalForm";
	}

	@RequestMapping(value = "/newfiscal", method = RequestMethod.POST)
	public String saveFiscal (@Validated Fiscal fiscal, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			if (fiscalService.findById(fiscal.getId()) != null) {
				return "redirect:/newfiscal";
			}
		}

//		sessao.setDataSessao(LocalDate.now());
		fiscalService.save(fiscal);
		return "redirect:/fiscais";

	}

}

package br.com.oab.votacaoCsec.controller;

import java.time.LocalDate;
import java.util.List;

import br.com.oab.votacaoCsec.enums.StatusSessaoEnum;
import br.com.oab.votacaoCsec.models.OpcaoVoto;
import br.com.oab.votacaoCsec.models.OpcoesVoto;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.oab.votacaoCsec.models.Sessao;
import br.com.oab.votacaoCsec.service.SessaoService;

@Controller
public class SessaoController {
	
	@Autowired
	SessaoService sessaoService;
	
	@RequestMapping(value = "/sessoes", method = RequestMethod.GET)
	public ModelAndView getSessoes() {
		ModelAndView mv = new ModelAndView("sessoes");
		List<Sessao> sessoes = sessaoService.findAll();
		mv.addObject("sessoes", sessoes);
		return mv;
	}
	
	@RequestMapping(value = "/sessoes/{id}", method = RequestMethod.GET)
	public ModelAndView getSessaoDetails (@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("sessaoDetails");
		Sessao sessao = sessaoService.findById(id);
		mv.addObject("sessao", sessao);
		return mv;
	}
	
	@RequestMapping(value = "/newsessao", method = RequestMethod.GET)
	public String getSessaoForm () {
		return "sessaoForm";
	}
	
	@RequestMapping(value = "/newsessao", method = RequestMethod.POST)
	public String saveSessao (@Validated Sessao sessao, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios " +
					"foram preenchidos");

			return "redirect:/newsessao";
		}

		if (sessaoService.dataSessaoCoincideComOutraSessao(sessao.getDataSessao())) {
			attributes.addFlashAttribute("mensagem", "Já há uma sessão marcada para esta data");
			sessao.setDataSessao(LocalDate.now());
			return "redirect:/newsessao";
		}

		if (sessaoService.validarTemaSessaoNaoERepetido(sessao.getTema())) {
			attributes.addFlashAttribute("mensagem", "Já há um tema definido para outra sessão");
			sessao.setDataSessao(LocalDate.now());
			return "redirect:/newsessao";
		}

		OpcoesVoto opcoesVoto = new OpcoesVoto();
		sessao.setIdOpcoesVoto(opcoesVoto);

		sessao.setStatusSessao(StatusSessaoEnum.AINICIAR);
		sessaoService.save(sessao);
		return "redirect:/sessoes";
		
	}

	@RequestMapping(value = "/iniciar-sessao", method = RequestMethod.GET)
	public String getIniciarSessaoForm () {
		return "inicio-sessao";
	}

	@RequestMapping(value = "/iniciar-sessao", method = RequestMethod.POST)
	public String iniciarSessao (Long idSessao, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios " +
					"foram preenchidos");
			return "redirect:/newsessao";
		}

		Sessao sessao = sessaoService.findById(idSessao);

		if (sessaoService.dataSessaoCoincideComOutraSessao(LocalDate.now())) {
			attributes.addFlashAttribute("mensagem", "Já há uma sessão marcada para esta data");
			sessao.setDataSessao(LocalDate.now());
			return "redirect:/newsessao";
		}

		sessao.setStatusSessao(StatusSessaoEnum.EMANDAMENTO);
		sessaoService.update(sessao);

		return "redirect:/sessoes";

	}

	/* Método criado para que quando o votante autenticar no sistema, e clicar na opção de 'Sessao', ele possa
	* ser redirecionado para uma página, onde ele possa ver as sessões dele disponíveis para ele votar e também
	* um histórico de sessões que ele já votou.
	* SELECT * FROM sessao WHERE votante = ${idVotante} */
	@RequestMapping(value = "/sessao/votante", method = RequestMethod.POST)
	public String getSessaoVotante (@Validated Sessao sessao, @RequestParam Long idVotante) {

		return "redirect:/sessoesVotante";
	}

	/* Método que pega o resultado final de cada sessão, quantos votos teve cada opção desta sessão,
	* horário de início e de encerramento da mesma.
	* SELECT * FROM sessao s
	* LEFT JOIN opcoes_voto_list_opcao_voto ovlov ON ovlov.id = s.id_opcoes_voto_id
	* WHERE status_sessao = 'FINALIZADA' */
	public String getResultadoFinalSessao() {
		return null;
	}

}

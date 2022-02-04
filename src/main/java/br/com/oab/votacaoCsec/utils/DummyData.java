//package br.com.oab.votacaoCsec.utils;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import br.com.oab.votacaoCsec.models.Sessao;
//import br.com.oab.votacaoCsec.repository.SessaoRepository;
//
//@Component
//public class DummyData {
//	
//	@Autowired
//	SessaoRepository sessaoRepository;
//	
////	@PostConstruct
//	public void saveSessao() {
//		
//		List<Sessao> listSessao = new ArrayList<>();
//		
//		Sessao sessao1 = new Sessao();
//		sessao1.setCamara("1ª Câmara");
//		sessao1.setNumeroProcesso(202200019L);
//		sessao1.setPauta("Sessão extraordinária em favor do advogado Fulano");
//		sessao1.setTipoPartes("Requerente - Requerido");
//		sessao1.setRelatorConselheiro("Jacó Carlos Silva Coelho");
//		
//		Sessao sessao2 = new Sessao();
//		sessao2.setCamara("2ª Câmara");
//		sessao2.setNumeroProcesso(202200015L);
//		sessao2.setPauta("Sessão extraordinária em favor do advogado Beltrano");
//		sessao2.setTipoPartes("Requerente - Requerido");
//		sessao2.setRelatorConselheiro("Delzira Santos Menezes");
//		
//		listSessao.add(sessao1);
//		listSessao.add(sessao2);
//		
//		for (Sessao sessao : listSessao) {
//			sessaoRepository.save(sessao);
//			System.out.println("------- SALVANDO DADOS NO BANCO ---------");
//		}
//		
//		
//	}
//
//}

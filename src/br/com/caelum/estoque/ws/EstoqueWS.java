package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService
@Stateless
public class EstoqueWS {
	
	private Map<String, ItemEstoque> repositorio = new HashMap<>();
	
	public EstoqueWS() {
		repositorio.put("ARQ", new ItemEstoque("ARQ", 5));
		repositorio.put("SOA", new ItemEstoque("SOA", 2));
		repositorio.put("TDD", new ItemEstoque("TDD", 3));
		repositorio.put("RES", new ItemEstoque("RES", 4));
		repositorio.put("LOG", new ItemEstoque("LOG", 3));
		repositorio.put("WEB", new ItemEstoque("WEB", 4));
		}
	
		public List<ItemEstoque> getQuantidade (List<String> codigos) {
			List<ItemEstoque> itens = new ArrayList<>();
			
			if (codigos == null || codigos.isEmpty()){
				return itens;
			}
			
			for(String codigo : codigos) {
				if(repositorio.containsKey(codigo)){
					itens.add(repositorio.get(codigo));
				}
				
			}
			return itens;
	}
}

package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.Categoria_LojaEntityDTO;
import br.com.OpetBrothers.repository.entity.Categoria_LojaEntity;

public interface Categoria_LojaDAO 
{
	Categoria_LojaEntityDTO Cadastrar(Categoria_LojaEntity pCategoria_LojaEntity);
	
	Categoria_LojaEntityDTO Atualizar(Categoria_LojaEntity pCategoria_LojaEntity);
	
	Categoria_LojaEntityDTO Excluir(Categoria_LojaEntity pCategoria_LojaEntity);
	
	Categoria_LojaEntityDTO GetCategoria_Loja(int pId);
	
	Categoria_LojaEntityDTO TodasCategorias_Loja();
}

package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.PessoaEntityDTO;
import br.com.OpetBrothers.repository.entity.PessoaEntity;

public interface PessoaDAO 
{

	PessoaEntityDTO Cadastrar(PessoaEntity pPessoaEntity);
	
	PessoaEntityDTO Atualizar(PessoaEntity pPessoaEntity);
	
	PessoaEntityDTO Excluir(PessoaEntity pPessoaEntity);
	
	PessoaEntityDTO GetPessoa(int pId);
	
	PessoaEntityDTO TodasPessoas();
	
}

package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.PessoaFisicaEntityDTO;
import br.com.OpetBrothers.repository.entity.PessoaFisicaEntity;

public interface PessoaFisicaDAO {
	PessoaFisicaEntityDTO Cadastrar(PessoaFisicaEntity pPessoaFisicaEntity);
	
	PessoaFisicaEntityDTO Atualizar(PessoaFisicaEntity pPessoaFisicaEntity);
	
	PessoaFisicaEntityDTO Excluir(PessoaFisicaEntity pPessoaFisicaEntity);
	
	PessoaFisicaEntityDTO GetPessoaFisica(int pId);
	
	PessoaFisicaEntityDTO BuscaIDFacebook(String pId);
	
	PessoaFisicaEntityDTO TodasPessoas();
}

package br.com.OpetBrothers.dao;

import br.com.OpetBrothers.dto.PessoaJuridicaEntityDTO;
import br.com.OpetBrothers.repository.entity.PessoaJuridicaEntity;

public interface PessoaJuridicaDAO {
	
	PessoaJuridicaEntityDTO Cadastrar(PessoaJuridicaEntity pPessoaJuridicaEntity);
	
	PessoaJuridicaEntityDTO Atualizar(PessoaJuridicaEntity pPessoaJuridicaEntity);
	
	PessoaJuridicaEntityDTO Excluir(PessoaJuridicaEntity pPessoaJuridicaEntity);
	
	PessoaJuridicaEntityDTO Login(PessoaJuridicaEntity pPessoaJuridicaEntity);
	
	PessoaJuridicaEntityDTO GetPessoaJuridica(int pId);
	
	PessoaJuridicaEntityDTO TodasLojas();
}

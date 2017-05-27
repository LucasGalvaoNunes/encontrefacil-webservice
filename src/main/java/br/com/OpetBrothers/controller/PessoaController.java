package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.PessoaDAO;
import br.com.OpetBrothers.dto.PessoaEntityDTO;
import br.com.OpetBrothers.repository.PessoaRepository;
import br.com.OpetBrothers.repository.entity.PessoaEntity;

@Path("/Pessoa")
public class PessoaController implements PessoaDAO{

	private PessoaRepository repository = new PessoaRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public PessoaEntityDTO Cadastrar(PessoaEntity pPessoaEntity) {
		return repository.Cadastrar(pPessoaEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public PessoaEntityDTO Atualizar(PessoaEntity pPessoaEntity) {
		return repository.Atualizar(pPessoaEntity);
	}

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public PessoaEntityDTO Excluir(PessoaEntity pPessoaEntity) {
		return repository.Excluir(pPessoaEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public PessoaEntityDTO GetPessoa(@PathParam("pId")int pId) {
		return repository.GetPessoa(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public PessoaEntityDTO TodasPessoas() {
		return repository.TodasPessoas();
	}
	
	
	
}

package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.PessoaFisicaDAO;
import br.com.OpetBrothers.dto.PessoaFisicaEntityDTO;
import br.com.OpetBrothers.repository.PessoaFisicaRepository;
import br.com.OpetBrothers.repository.entity.PessoaFisicaEntity;

@Path("/PessoaFisica")
public class PessoaFisicaController implements PessoaFisicaDAO{
	private PessoaFisicaRepository repository = new PessoaFisicaRepository();

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public PessoaFisicaEntityDTO Cadastrar(PessoaFisicaEntity pPessoaFisicaEntity) {
		return this.repository.Cadastrar(pPessoaFisicaEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public PessoaFisicaEntityDTO Atualizar(PessoaFisicaEntity pPessoaFisicaEntity) {
		return this.repository.Atualizar(pPessoaFisicaEntity);
	}

	@Override
	@DELETE
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Excluir")
	public PessoaFisicaEntityDTO Excluir(PessoaFisicaEntity pPessoaFisicaEntity) {
		return this.repository.Excluir(pPessoaFisicaEntity);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public PessoaFisicaEntityDTO GetPessoaFisica(@PathParam("pId")int pId) {
		return this.repository.GetPessoaFisica(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public PessoaFisicaEntityDTO TodasPessoas() {
		return this.repository.TodasPessoas();
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/BuscaIdFacebook/{pId}")
	public PessoaFisicaEntityDTO BuscaIDFacebook(@PathParam("pId")String pId) {
		return this.repository.BuscaIDFacebook(pId);
	}
	
	
}

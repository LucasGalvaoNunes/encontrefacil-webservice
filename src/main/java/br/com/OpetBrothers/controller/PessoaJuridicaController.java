package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dao.PessoaJuridicaDAO;
import br.com.OpetBrothers.dto.PessoaJuridicaEntityDTO;
import br.com.OpetBrothers.repository.PessoaJuridicaRepository;
import br.com.OpetBrothers.repository.entity.PessoaJuridicaEntity;

@Path("/PessoaJuridica")
public class PessoaJuridicaController implements PessoaJuridicaDAO {

	private PessoaJuridicaRepository repository = new PessoaJuridicaRepository();
	
	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Cadastrar")
	public PessoaJuridicaEntityDTO Cadastrar(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		return this.repository.Cadastrar(pPessoaJuridicaEntity);
	}

	@Override
	@PUT
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Atualizar")
	public PessoaJuridicaEntityDTO Atualizar(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		return this.repository.Atualizar(pPessoaJuridicaEntity);
	}

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Deletar")
	public PessoaJuridicaEntityDTO Excluir(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		return this.repository.Excluir(pPessoaJuridicaEntity);
	}

	@Override
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Login")
	public PessoaJuridicaEntityDTO Login(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		return this.repository.Login(pPessoaJuridicaEntity);
	}

	@Override
	@GET
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/Get/{pId}")
	public PessoaJuridicaEntityDTO GetPessoaJuridica(@PathParam("pId") int pId) {
		return this.repository.GetPessoaJuridica(pId);
	}

	@Override
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/Todas")
	public PessoaJuridicaEntityDTO TodasLojas() {
		return this.repository.TodasLojas();
	}

}

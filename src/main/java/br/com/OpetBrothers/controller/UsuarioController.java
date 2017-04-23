package br.com.OpetBrothers.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.OpetBrothers.dto.UsuarioEntityDTO;
import br.com.OpetBrothers.repository.UsuarioRepository;
import br.com.OpetBrothers.repository.entity.UsuarioEntity;

@Path("/Usuario")
public class UsuarioController {
	private  UsuarioRepository repositoryUsuario = new UsuarioRepository();
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/Cadastrar")
	public UsuarioEntityDTO Cadastrar(UsuarioEntity UsuarioEntity){
		return this.repositoryUsuario.Salvar(UsuarioEntity);
	}
 
	@PUT
	@Produces("application/json")
	@Consumes("application/json")	
	@Path("/Alterar")
	public UsuarioEntityDTO Alterar(UsuarioEntity UsuarioEntity){
		return this.repositoryUsuario.Alterar(UsuarioEntity);
	}
 
	
	@DELETE
	@Produces("application/json")
	@Consumes("application/json")	
	@Path("/Excluir")	
	public UsuarioEntityDTO Excluir(UsuarioEntity pUsuarioEntity){
		return this.repositoryUsuario.Excluir(pUsuarioEntity);
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/Logar")
	public UsuarioEntityDTO Logar(UsuarioEntity pUsuarioEntity){ 
		return this.repositoryUsuario.Logar(pUsuarioEntity);
	}
}

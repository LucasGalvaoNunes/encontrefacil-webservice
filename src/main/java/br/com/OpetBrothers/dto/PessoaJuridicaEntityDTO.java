package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.PessoaJuridicaEntity;

@XmlRootElement(name = "PessoaJuridicaEntityDTO")
public class PessoaJuridicaEntityDTO  extends AbstractDTO<PessoaJuridicaEntity>{

	public PessoaJuridicaEntityDTO()
    {
        super();
    }

    public PessoaJuridicaEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public PessoaJuridicaEntityDTO(boolean pOk, String pMensagem, PessoaJuridicaEntity pPessoaJuridica)
    {
        super(pOk, pMensagem, pPessoaJuridica);
    }

    public PessoaJuridicaEntityDTO(boolean pOk, String pMensagem, List<PessoaJuridicaEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public PessoaJuridicaEntity getPessoaJuridica()
    {
        return getObjeto();
    }

    public void setPessoaJuridica(PessoaJuridicaEntity pPessoaJuridica)
    {
        setObjeto(pPessoaJuridica);
    }
	
}

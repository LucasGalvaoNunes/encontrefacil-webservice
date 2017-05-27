package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.PessoaEntity;

@XmlRootElement(name = "PessoaEntityDTO")
public class PessoaEntityDTO extends AbstractDTO<PessoaEntity> {

	public PessoaEntityDTO()
    {
        super();
    }

    public PessoaEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public PessoaEntityDTO(boolean pOk, String pMensagem, PessoaEntity pPessoa)
    {
        super(pOk, pMensagem, pPessoa);
    }

    public PessoaEntityDTO(boolean pOk, String pMensagem, List<PessoaEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public PessoaEntity getPessoa()
    {
        return getObjeto();
    }

    public void setPessoa(PessoaEntity pPessoa)
    {
        setObjeto(pPessoa);
    }
	
}

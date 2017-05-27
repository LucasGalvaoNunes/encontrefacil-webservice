package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.PessoaFisicaEntity;

@XmlRootElement(name = "PessoaFisicaEntityDTO")
public class PessoaFisicaEntityDTO extends AbstractDTO<PessoaFisicaEntity>{
	public PessoaFisicaEntityDTO()
    {
        super();
    }

    public PessoaFisicaEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public PessoaFisicaEntityDTO(boolean pOk, String pMensagem, PessoaFisicaEntity pPessoaFisicaEntity)
    {
        super(pOk, pMensagem, pPessoaFisicaEntity);
    }

    public PessoaFisicaEntityDTO(boolean pOk, String pMensagem, List<PessoaFisicaEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public PessoaFisicaEntity getPessoaFisicaEntity()
    {
        return getObjeto();
    }

    public void setPessoaFisicaEntity(PessoaFisicaEntity pPessoaFisicaEntity)
    {
        setObjeto(pPessoaFisicaEntity);
    }
}

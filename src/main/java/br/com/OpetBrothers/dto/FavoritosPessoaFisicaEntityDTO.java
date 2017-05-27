package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.FavoritosPessoaFisicaEntity;

@XmlRootElement(name="FavoritosPessoaFisicaEntityDTO")
public class FavoritosPessoaFisicaEntityDTO extends AbstractDTO<FavoritosPessoaFisicaEntity> {

	public FavoritosPessoaFisicaEntityDTO()
    {
        super();
    }

    public FavoritosPessoaFisicaEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public FavoritosPessoaFisicaEntityDTO(boolean pOk, String pMensagem, FavoritosPessoaFisicaEntity pFavoritosPessoaFisica)
    {
        super(pOk, pMensagem, pFavoritosPessoaFisica);
    }

    public FavoritosPessoaFisicaEntityDTO(boolean pOk, String pMensagem, List<FavoritosPessoaFisicaEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public FavoritosPessoaFisicaEntity getFavoritosPessoaFisica()
    {
        return getObjeto();
    }

    public void setFavoritosPessoaFisica(FavoritosPessoaFisicaEntity pFavoritosPessoaFisica)
    {
        setObjeto(pFavoritosPessoaFisica);
    }
	
}

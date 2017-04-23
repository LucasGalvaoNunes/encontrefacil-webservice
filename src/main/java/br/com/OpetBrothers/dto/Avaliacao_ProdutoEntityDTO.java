package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.Avaliacao_ProdutoEntity;

@XmlRootElement(name="Avaliacao_ProdutoEntityDTO")
public class Avaliacao_ProdutoEntityDTO extends AbstractDTO<Avaliacao_ProdutoEntity>
{
	public Avaliacao_ProdutoEntityDTO()
    {
        super();
    }

    public Avaliacao_ProdutoEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public Avaliacao_ProdutoEntityDTO(boolean pOk, String pMensagem, Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity)
    {
        super(pOk, pMensagem, pAvaliacao_ProdutoEntity);
    }

    public Avaliacao_ProdutoEntityDTO(boolean pOk, String pMensagem, List<Avaliacao_ProdutoEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public Avaliacao_ProdutoEntity getAvaliacao_ProdutoEntity()
    {
        return getObjeto();
    }

    public void setAvaliacao_ProdutoEntity(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity)
    {
        setObjeto(pAvaliacao_ProdutoEntity);
    }
}

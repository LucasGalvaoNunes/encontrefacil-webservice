package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.ProdutoEntity;

@XmlRootElement(name = "ProdutoEntityDTO")
public class ProdutoEntityDTO extends AbstractDTO<ProdutoEntity>
{
	public ProdutoEntityDTO()
    {
        super();
    }

    public ProdutoEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProdutoEntityDTO(boolean pOk, String pMensagem, ProdutoEntity pProdutoEntity)
    {
        super(pOk, pMensagem, pProdutoEntity);
    }

    public ProdutoEntityDTO(boolean pOk, String pMensagem, List<ProdutoEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public ProdutoEntity getProdutoEntity()
    {
        return getObjeto();
    }

    public void setProdutoEntity(ProdutoEntity pProdutoEntity)
    {
        setObjeto(pProdutoEntity);
    }
}

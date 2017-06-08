package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.ProdutoDestaqueEntity;

@XmlRootElement(name = "ProdutoDestaqueDestaqueDTO")
public class ProdutoDestaqueEntityDTO extends AbstractDTO<ProdutoDestaqueEntity>{
	public ProdutoDestaqueEntityDTO()
    {
        super();
    }

    public ProdutoDestaqueEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProdutoDestaqueEntityDTO(boolean pOk, String pMensagem, ProdutoDestaqueEntity pProdutoDestaqueEntity)
    {
        super(pOk, pMensagem, pProdutoDestaqueEntity);
    }

    public ProdutoDestaqueEntityDTO(boolean pOk, String pMensagem, List<ProdutoDestaqueEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public ProdutoDestaqueEntity getProdutoDestaqueEntity()
    {
        return getObjeto();
    }

    public void setProdutoDestaqueEntity(ProdutoDestaqueEntity pProdutoDestaqueEntity)
    {
        setObjeto(pProdutoDestaqueEntity);
    }
}

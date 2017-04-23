package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.Marca_ProdutoEntity;

@XmlRootElement(name = "Marca_ProdutoEntityDTO")
public class Marca_ProdutoEntityDTO extends AbstractDTO<Marca_ProdutoEntity>
{
	public Marca_ProdutoEntityDTO()
    {
        super();
    }

    public Marca_ProdutoEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public Marca_ProdutoEntityDTO(boolean pOk, String pMensagem, Marca_ProdutoEntity pMarca_ProdutoEntity)
    {
        super(pOk, pMensagem, pMarca_ProdutoEntity);
    }

    public Marca_ProdutoEntityDTO(boolean pOk, String pMensagem, List<Marca_ProdutoEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public Marca_ProdutoEntity getMarca_ProdutoEntity()
    {
        return getObjeto();
    }

    public void setMarca_ProdutoEntity(Marca_ProdutoEntity pMarca_ProdutoEntity)
    {
        setObjeto(pMarca_ProdutoEntity);
    }
}

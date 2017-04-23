package br.com.OpetBrothers.dto;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.Categoria_ProdutoEntity;

@XmlRootElement(name="Categoria_ProdutoEntityDTO")
public class Categoria_ProdutoEntityDTO extends AbstractDTO<Categoria_ProdutoEntity>
{
	public Categoria_ProdutoEntityDTO()
    {
        super();
    }

    public Categoria_ProdutoEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public Categoria_ProdutoEntityDTO(boolean pOk, String pMensagem, Categoria_ProdutoEntity pCategoria_ProdutoEntity)
    {
        super(pOk, pMensagem, pCategoria_ProdutoEntity);
    }

    public Categoria_ProdutoEntityDTO(boolean pOk, String pMensagem, List<Categoria_ProdutoEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public Categoria_ProdutoEntity getCategoria_ProdutoEntity()
    {
        return getObjeto();
    }

    public void setCategoria_ProdutoEntity(Categoria_ProdutoEntity pCategoria_ProdutoEntity)
    {
        setObjeto(pCategoria_ProdutoEntity);
    }
}

package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.Categoria_LojaEntity;

@XmlRootElement(name="Categoria_LojaEntityDTO")
public class Categoria_LojaEntityDTO extends AbstractDTO<Categoria_LojaEntity>
{
	public Categoria_LojaEntityDTO()
    {
        super();
    }

    public Categoria_LojaEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public Categoria_LojaEntityDTO(boolean pOk, String pMensagem, Categoria_LojaEntity pCategoria_LojaEntity)
    {
        super(pOk, pMensagem, pCategoria_LojaEntity);
    }

    public Categoria_LojaEntityDTO(boolean pOk, String pMensagem, List<Categoria_LojaEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public Categoria_LojaEntity getCategoria_LojaEntity()
    {
        return getObjeto();
    }

    public void setCategoria_LojaEntity(Categoria_LojaEntity pCategoria_LojaEntity)
    {
        setObjeto(pCategoria_LojaEntity);
    }
}

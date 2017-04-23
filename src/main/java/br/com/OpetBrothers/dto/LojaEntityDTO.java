package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.LojaEntity;

@XmlRootElement(name = "LojaEntityDTO")
public class LojaEntityDTO extends AbstractDTO<LojaEntity>
{
	public LojaEntityDTO()
    {
        super();
    }

    public LojaEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public LojaEntityDTO(boolean pOk, String pMensagem, LojaEntity pLojaEntity)
    {
        super(pOk, pMensagem, pLojaEntity);
    }

    public LojaEntityDTO(boolean pOk, String pMensagem, List<LojaEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public LojaEntity getLojaEntity()
    {
        return getObjeto();
    }

    public void setLojaEntity(LojaEntity pLojaEntity)
    {
        setObjeto(pLojaEntity);
    }
}

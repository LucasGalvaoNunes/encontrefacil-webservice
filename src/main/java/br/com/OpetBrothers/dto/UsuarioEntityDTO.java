package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.UsuarioEntity;

@XmlRootElement(name = "UsuarioEntityDTO")
public class UsuarioEntityDTO extends AbstractDTO<UsuarioEntity>
{
	public UsuarioEntityDTO()
    {
        super();
    }

    public UsuarioEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public UsuarioEntityDTO(boolean pOk, String pMensagem, UsuarioEntity pUsuarioEntity)
    {
        super(pOk, pMensagem, pUsuarioEntity);
    }

    public UsuarioEntityDTO(boolean pOk, String pMensagem, List<UsuarioEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public UsuarioEntity getUsuarioEntity()
    {
        return getObjeto();
    }

    public void setUsuarioEntity(UsuarioEntity pUsuarioEntity)
    {
        setObjeto(pUsuarioEntity);
    }
}

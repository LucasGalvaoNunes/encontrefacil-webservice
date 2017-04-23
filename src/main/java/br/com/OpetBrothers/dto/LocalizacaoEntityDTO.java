package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;

@XmlRootElement(name = "LocalizacaoEntityDTO")
public class LocalizacaoEntityDTO extends AbstractDTO<LocalizacaoEntity>
{
	public LocalizacaoEntityDTO()
    {
        super();
    }

    public LocalizacaoEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public LocalizacaoEntityDTO(boolean pOk, String pMensagem, LocalizacaoEntity pLocalizacaoEntity)
    {
        super(pOk, pMensagem, pLocalizacaoEntity);
    }

    public LocalizacaoEntityDTO(boolean pOk, String pMensagem, List<LocalizacaoEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public LocalizacaoEntity getLocalizacaoEntity()
    {
        return getObjeto();
    }

    public void setLocalizacaoEntity(LocalizacaoEntity pLocalizacaoEntity)
    {
        setObjeto(pLocalizacaoEntity);
    }
}

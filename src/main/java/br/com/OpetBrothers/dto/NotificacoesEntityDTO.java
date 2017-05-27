package br.com.OpetBrothers.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.OpetBrothers.repository.entity.NotificacoesEntity;

@XmlRootElement(name = "NotificacoesEntityDTO")
public class NotificacoesEntityDTO extends AbstractDTO<NotificacoesEntity>{

	
	public NotificacoesEntityDTO()
    {
        super();
    }

    public NotificacoesEntityDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public NotificacoesEntityDTO(boolean pOk, String pMensagem, NotificacoesEntity pNotificacoes)
    {
        super(pOk, pMensagem, pNotificacoes);
    }

    public NotificacoesEntityDTO(boolean pOk, String pMensagem, List<NotificacoesEntity> pLista)
    {
        super(pOk, pMensagem, pLista);
    }


    public NotificacoesEntity getNotificacoes()
    {
        return getObjeto();
    }

    public void setNotificacoes(NotificacoesEntity pNotificacoes)
    {
        setObjeto(pNotificacoes);
    }
}

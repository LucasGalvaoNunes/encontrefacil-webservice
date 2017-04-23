

package br.com.OpetBrothers.dto;

import java.util.List;

public abstract class AbstractDTO<T>
{
    /* Atributos normais */
    private boolean      ok;
    private String       mensagem;
    private T       objeto;
    private List<T> lista;
    private int id;
    /* Construtores da classe */
    public AbstractDTO()
    {
        super();
    }

    public AbstractDTO(boolean pOk, String pMensagem)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
    }

    public AbstractDTO(boolean pOk, String pMensagem, T pObjeto)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        objeto = pObjeto;
    }

    public AbstractDTO(boolean pOk, String pMensagem, List<T> pLista)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        lista = pLista;
    }
    
    public AbstractDTO(boolean pOk, String pMensagem, int pId)
    {
        super();
        ok = pOk;
        mensagem = pMensagem;
        id = pId;
    }

    /* Métodos de acesso */
    public boolean isOk()
    {
        return ok;
    }

    public void setOk(boolean pOk)
    {
        ok = pOk;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String pMensagem)
    {
        mensagem = pMensagem;
    }

    protected T getObjeto()
    {
        return objeto;
    }

    protected void setObjeto(T pT)
    {
        objeto = pT;
    }

    public List<T> getLista()
    {
        return lista;
    }

    public void setLista(List<T> pLista)
    {
        lista = pLista;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
    
}

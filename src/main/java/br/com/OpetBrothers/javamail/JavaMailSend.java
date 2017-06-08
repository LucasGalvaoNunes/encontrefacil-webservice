package br.com.OpetBrothers.javamail;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailSend {

	public boolean SendEmail(String pDestinatario, String pMensagem){
		
		String tSenha = "lucasnunes1971";
        String tServidor = "smtp.gmail.com";
        String tPorta = "465";
        String tUsuario = "encontrefacilcomunicacao@gmail.com";

        String tDestino = pDestinatario;
        String tOrigem = "encontrefacilcomunicacao@gmail.com";

        Properties tPropriedades = new Properties();
        tPropriedades.put("mail.smtp.host", tServidor);
        tPropriedades.put("mail.smtp.port", tPorta);
        tPropriedades.put("mail.smtp.user", tUsuario);
        tPropriedades.put("mail.smtp.auth", "true");
        tPropriedades.put("mail.smtp.debug", "true");
        tPropriedades.put("mail.smtp.socketFactory.port", tPorta);
        tPropriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        tPropriedades.put("mail.smtp.socketFactory.fallback", "false");

        // Obtendo o objeto Session
        Session tSessao = Session.getInstance(tPropriedades, new Autenticador(tUsuario, tSenha));

        try
        {
            // Criando a mensagem
            Message tMensagem = new MimeMessage(tSessao);

            // Configurando a mensagem.
            tMensagem.setFrom(new InternetAddress(tOrigem));
            tMensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tDestino));
            tMensagem.setSubject("Codigo de Verificação - Não Responda");
            tMensagem.setText(pMensagem);

            // Enviando a mensagem
            Transport.send(tMensagem);

            return true;
        }
        catch (MessagingException tExcept)
        {
        	return false;
        }
	}
	public String GerarCodigo()
	{
		//Determia as letras que poderão estar presente nas chaves 
		String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ0123456789"; 
		Random random = new Random(); 
		String codigo = ""; 
		int index = -1; 
		for( int i = 0; i < 4; i++ ) 
		{ 
			index = random.nextInt( letras.length() ); 
			codigo += letras.substring( index, index + 1 ); 
		} 
		return codigo;
	}
	
	
	
	private static class Autenticador extends Authenticator
    {
        private String mUsuario;
        private String mSenha;

        public Autenticador(String pUsuario, String pSenha)
        {
            super();
            mUsuario = pUsuario;
            mSenha = pSenha;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(mUsuario, mSenha);
        }
    }
}

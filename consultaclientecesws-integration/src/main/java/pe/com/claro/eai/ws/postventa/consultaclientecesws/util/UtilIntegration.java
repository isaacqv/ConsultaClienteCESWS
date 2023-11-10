package pe.com.claro.eai.ws.postventa.consultaclientecesws.util;

import javax.ws.rs.core.Application;

import com.sun.jersey.api.client.WebResource.Builder;

import pe.com.claro.eai.ws.postventa.consultaclientecesws.types.IncognitoHeader;
import pe.com.claro.eai.ws.postventa.consultaclientecesws.typesiptv.IptvHeader;

public class UtilIntegration extends Application {

	public void setHeaderBuilder(Builder builder, IncognitoHeader header) {

		builder.header(Constantes.IDTRANSACCION, header.getTransactionId());
		builder.header(Constantes.TIMESTAMP, header.getTimestamp());
		builder.header(Constantes.ACCEPT, header.getAccept());
		builder.header(Constantes.MSGID, header.getMsgid());
		builder.header(Constantes.USERID, header.getUserId());
	}
	public void setHeaderBuilderIPTV(Builder builder, IptvHeader header) {

		builder.header(Constantes.IDTRANSACCION, header.getTransactionId());
		builder.header(Constantes.TIMESTAMP, header.getTimestamp());
		builder.header(Constantes.ACCEPT, header.getAccept());
		builder.header(Constantes.MSGID, header.getMsgid());
		builder.header(Constantes.USERID, header.getUserId());
	}
}

package programa.estaciones.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import programa.repositorio.EntidadNoEncontrada;

@ControllerAdvice
public class TratamientoEntidadNoEncontradaException{
	
	@ExceptionHandler(EntidadNoEncontrada.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public RespuestaError toResponse(EntidadNoEncontrada ex) {
		return new RespuestaError("Not found", ex.getMessage());
	}
	
	private static class RespuestaError {
		private String estado;
		private String mensaje;
		
		public RespuestaError(String estado, String mensaje) {
			this.estado = estado;
			this.mensaje = mensaje;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getMensaje() {
			return mensaje;
		}

		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}
	}
}

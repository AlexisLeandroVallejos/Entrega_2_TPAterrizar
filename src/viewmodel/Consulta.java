package viewmodel;

public enum Consulta {
		RESERVA, COMPRA;
		
		private String descripcion;

		static {
			RESERVA.descripcion = "Reservado";
			COMPRA.descripcion = "Comprado";
		}
		
		public String getDescripcion() {
			return descripcion;
		}
}

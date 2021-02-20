
public class Agenda {

	private Contacto[] agenda;
	private int cantContactos = 10;

	public Agenda() {
		this.agenda = new Contacto[cantContactos];
	}

	// añadir contacto
	public void aniadirContacto(Contacto contacto) {

		// NOTA: LOS NULL HACEN QUE ROMPA EL PROGRAMA, ATENTO

		if (existeContacto(contacto)) {
			System.out.println("No se puede introducir el contacto, porque ya existe.\n");
		} else if (agendaLlena()) {
			System.out.println("No se puede introducir el contacto, agenda llena.\n");
		} else {
			boolean encontrado = false;

			for (int i = 0; i < agenda.length && !encontrado; i++) {
				if (agenda[i] == null) {
					agenda[i] = contacto;
					// new Contacto(contacto.getNombre(), contacto.getNumero() );
					encontrado = true;
				}
			}

			if (encontrado) {
				System.out.println("se ha añadido el contacto.\n");
			} else {
				System.out.println("No se ha podido añadir el contacto.\n");
			}
		}
	}

	// si ya existe el contacto devuelve true ||no existe el contacto devuelve false
	public boolean existeContacto(Contacto contacto) {
		boolean bandera = false;

		for (int i = 0; i < agenda.length; i++) {
			if (agenda[i] != null && agenda[i].getNombre().equalsIgnoreCase(contacto.getNombre())) {
				bandera = true;
				return bandera;
			}
		}

		return bandera;
	}

	public void listarContacto() {

		for (int i = 0; i < agenda.length; i++) {
			if (agenda[i] != null) {
				System.out.println("Nombre: " + agenda[i].getNombre() + ", Numero: " + agenda[i].getNumero());
			}
		}

		System.out.println("Fin de la lista.\n");
	}

	public void buscarContacto(String nombre) {
		boolean encontrado = false;
		for (int i = 0; agenda[i] != null && i < agenda.length && !encontrado; i++) {
			if (agenda[i].getNombre().equals(nombre)) {
				System.out.println("Contacto encontrado, Nombre: " + agenda[i].getNombre() + ", Telefono: "
						+ agenda[i].getNumero() + "\n");
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("Contacto no encontrado.\n");
		}
	}

	public void eliminarContacto(String nombre) {
		boolean encontrado = false;
		for (int i = 0; i < agenda.length && encontrado == false; i++) {
			if (agenda[i] != null && agenda[i].getNombre().equals(nombre)) {
				agenda[i] = null;
				encontrado = true;
				System.out.println("Contacto eliminado.\n");
			}
		}

		if (!encontrado) {
			System.out.println("Contacto no encontrado, contacto no eliminado.\n");
		}

	}

	public boolean agendaLlena() {

		for (int i = 0; i < cantContactos; i++) {
			if (agenda[i] == null)
				return false;
		}
		return true;
	}

	public int huecosLibres() {
		int contador = 0;
		for (int i = 0; i < agenda.length; i++) {
			if (agenda[i] == null) {
				contador++;
			}
		}
		return contador;
	}

	// GETTERS Y SETTERS
	public Contacto[] getAgenda() {
		return agenda;
	}

	public void setAgenda(Contacto[] agenda) {
		this.agenda = agenda;
	}

	public int getCantContactos() {
		return cantContactos;
	}

}

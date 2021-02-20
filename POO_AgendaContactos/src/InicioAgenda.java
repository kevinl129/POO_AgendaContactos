import java.util.Scanner;

public class InicioAgenda {
	// static Scanner sn = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);

		Agenda contactos = new Agenda();
		boolean salir = false;
		int opcion = 0;

		while (!salir) {
			System.out.println("INGRESE UNA OPCION." + 
		                       "\n1.Añadir contacto." + 
					           "\n2.Listar contactos."+
					           "\n3.Buscar contacto." + 
					           "\n4.Existe contacto." + 
					           "\n5.Eliminar contacto."+
					           "\n6.Contactos disponibles" + 
					           "\n7.Salir");
			System.out.println("Escribe una de las opciones:");

			opcion = sn.nextInt();
			// elegirOpcion(opcion);

			switch (opcion) {
			case 1:
				System.out.println("Ingrese nombre: ");
				String nombre = sn.next();

				System.out.println("Ingrese telefono: ");
				int numero = sn.nextInt();

				Contacto contactoAgregar = new Contacto(nombre, numero);
				contactos.aniadirContacto(contactoAgregar);

				break;

			case 2:

				contactos.listarContacto();
				break;

			case 3:

				System.out.println("Ingrese el nombre a buscar: ");
				String nombreBuscar = sn.next();
				contactos.buscarContacto(nombreBuscar);

				break;

			case 4:

				System.out.println("Ingrese nombre: ");
				String nombreContacto = sn.next();
				/*
				 * System.out.println("Ingrese telefono: "); int numeroContacto = sn.nextInt();
				 */
				// aca utilizo el sefundo constructor
				Contacto contactoBuscar = new Contacto(nombreContacto);
				boolean existe = contactos.existeContacto(contactoBuscar);
				if (existe) {
					System.out.println("El contacto existe.");
				} else {
					System.out.println("El contacto no existe.");
				}
				break;

			case 5:

				System.out.println("Escrciba nombre contacto a eliminar: ");
				String contactoElim = sn.next();
				contactos.eliminarContacto(contactoElim);

				break;

			case 6:
				if (contactos.huecosLibres() != 0) {
					System.out.println("Espacio en la agenda hay para " + contactos.huecosLibres() + " contactos mas.");
				} else {
					System.out.println("No hay espacio en la agenda");
				}
				break;
			case 7:
				salir = true;
				break;
			default:
				System.out.println("digite una opcion correcta.");
				break;

			}
		}

	}

}

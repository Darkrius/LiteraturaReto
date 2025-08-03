package com.example.LiteraturaReto;

import com.example.LiteraturaReto.model.ResultadoApi;
import com.example.LiteraturaReto.service.ConsumoAPI;
import com.example.LiteraturaReto.service.ConvierteDatos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;


@SpringBootApplication
public class LiteraturaRetoApplication  implements  CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaRetoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mostrarMenu();
	}

	private Scanner teclado = new Scanner(System.in);
	private ConsumoAPI consumoApi = new ConsumoAPI();
	private final String URL_BASE = "https://gutendex.com/books?search=";
	private ConvierteDatos conversor = new ConvierteDatos();


	private void mostrarMenu() {
		int opcion = -1;
		while (opcion != 0) {
			var menu = "";
			System.out.println("\n=== MENÚ PRINCIPAL ===");
			System.out.println("1 - Buscar libro por título o autor");
			System.out.println("0 - Salir");
			System.out.print("Seleccione una opción: ");

			System.out.println(menu);
			opcion = teclado.nextInt();
			teclado.nextLine();

			switch (opcion) {
				case 1 -> buscarLibro();
				case 0 -> System.out.println("Cerrando la aplicación...");
				default -> System.out.println("Opción inválida");
			}
		}
	}


	private void buscarLibro() {

		System.out.println("Que libro desea buscar");
		var libroBuscado = teclado.nextLine();
		String url = URL_BASE + libroBuscado;
		System.out.println("Consultando: " + url);
		String json = consumoApi.obtenerDatos(url);

		var datos = conversor.obtenerDatos(json, ResultadoApi.class);

		System.out.println("Datos obtenidos: " + datos);
	}




}






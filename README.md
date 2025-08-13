# milibreria


En esta pequeña app que es para responder al reto del curso de Alura Latan y Oracle en el curso de programador BackEnd. Esta consiste en demostrar que se aprendieron los conceptos y poder crear una app que consuma desde una API en este caso de https://gutendex.com/.

Hace lo siguiente:

- Permite al usuario consultar libros por títulos y todos los registros que concuerden con el criterio de búsqueda están guardados en la base de dato.
- Brinda una lista de todos los libros existentes en la base de datos.
- Lista de todos los autores de los libros que se hayan consultado.
- consultar autores por fecha de fallecimiento y otros.


El mismo funciona con un menú de texto muy rudimentario, pero funcional. el mismo controla algunos posibles errores de datos mal ingresados, así como sus validaciones y control del mismo.

La estructura de las clases usadas es la siguiente:

    public class Autor {
        private long id;
        private String nombre;
        private Integer nacido;
        private Integer fallecimiento;
    }

    public class Libro {
        private Long id;
        private String título;
        private String idiomas;
        private int nroDescargas;
        private Autor autor;
    }

Dependencias usadas en este proyecto:

        <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.19.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.38</version>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<scope>provided</scope>
		</dependency>


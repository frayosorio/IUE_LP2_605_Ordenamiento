package servicios;

import modelos.Documento;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DocumentoServicio {
    private static String[] encabezados = new String[]{"#", "Primer Apellido", "Segundo Apellido", "Nombres",
            "Documento"};

    public static String[] getEncabezados() {
        return encabezados;
    }

    private static List<Documento> documentos = Collections.emptyList();

    public static void cargar(String nombreArchivo) {
        var ruta = Paths.get(nombreArchivo);

        try (Stream<String> lineas = Files.lines(ruta)) {

            documentos = lineas.skip(1)
                    .filter(linea -> linea != null & !linea.isBlank())
                    .map(linea -> linea.split("[,;]"))
                    .filter(textos -> textos.length >= 4)
                    .map(textos -> new Documento(textos[0], textos[1], textos[2], textos[3]))
                    .collect(Collectors.toList());

            System.out.println(documentos.size());
        } catch (Exception e) {
            System.out.println(e);
            Collections.emptyList();
        }
    }

    public static String[][] getDatosDocumentos() {
        AtomicInteger fila = new AtomicInteger(1);
        return documentos.stream()
                .map(documento -> new String[]{
                        String.valueOf(fila.getAndIncrement()),
                        documento.getApellido1(),
                        documento.getApellido2(),
                        documento.getNombre(),
                        documento.getDocumento()})
                .collect(Collectors.toList())
                .toArray(String[][]::new);
    }
}

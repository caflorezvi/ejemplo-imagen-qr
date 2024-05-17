package co.edu.uniquindio.ejemplo.controlador;

import com.github.aytchell.qrgen.QrGenerator;
import com.github.aytchell.qrgen.config.ErrorCorrectionLevel;
import com.github.aytchell.qrgen.config.ImageFileType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.nio.file.Path;

/**
 * Clase que representa el controlador de la vista Inicio de la aplicación.
 * @author caflorezvi
 */
public class InicioControlador {

    @FXML
    private ImageView imagenSeleccionada;

    @FXML
    private ImageView qrGenerado;

    /**
     * Método que se ejecuta cuando se presiona el botón "Seleccionar imagen".
     * @param actionEvent
     */
    public void seleccionarImagen(ActionEvent actionEvent) {
        abrirFileChooser();
    }

    /**
     * Método que se ejecuta cuando se presiona el botón "Generar QR".
     * @param actionEvent
     * @throws Exception
     */
    public void generarQR(ActionEvent actionEvent) throws Exception{

        // Generar el código QR con la librería QRGen
        QrGenerator generator = new QrGenerator()
                .withSize(300, 300)
                .withMargin(3)
                .as(ImageFileType.PNG)
                .withErrorCorrection(ErrorCorrectionLevel.Q);

        // Escribir el código QR en un archivo temporal, reemplazar "Hello, World!" por el texto que se desea codificar
        Path img = generator
                .writeToTmpFile("Hello, World!");

        // Mostrar el código QR en la interfaz gráfica
        qrGenerado.setImage(new javafx.scene.image.Image(img.toUri().toString()));

    }

    /**
     * Método que permite abrir un FileChooser para seleccionar una imagen.
     */
    private void abrirFileChooser() {

        // Crear un FileChooser para seleccionar la imagen
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");

        // Filtrar los archivos que se pueden seleccionar
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg")
        );

        // Mostrar el FileChooser y obtener la imagen seleccionada
        File imagen = fileChooser.showOpenDialog(null);

        // Mostrar la imagen seleccionada en la interfaz gráfica
        if (imagen != null) {
            imagenSeleccionada.setImage(new javafx.scene.image.Image(imagen.toURI().toString()));
        }

    }

}

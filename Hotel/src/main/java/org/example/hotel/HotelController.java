package org.example.hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class HotelController {

    public Label mensaje;
    public TextArea textArea;
    @FXML
    public ComboBox<String> tipo;
    public ComboBox<Integer> numHab;
    @FXML
    private TextField nombre;

    @FXML
    private TextField apellido;

    @FXML
    private TextField correo;

    @FXML
    private TextField telefono;

    @FXML
    private DatePicker fechaLlegada;

    @FXML
    private DatePicker fechaSalida;

    @FXML
    private Button BReservar;

    @FXML
    private Button habitacionDisponible;

    @FXML
    private Button reservasConfirmadas;

    @FXML
    private Pane loginPane;

    @FXML
    private Pane reservaPane;

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private void handleLogin() {
        String usuario = usuarioField.getText();
        String password = passwordField.getText();

        if (password.equals("1234")) {
            loginPane.setVisible(false);
            reservaPane.setVisible(true);
        } else {
            errorLabel.setText("Contraseña incorrecta");
        }
    }
    @FXML
    public void disponibilidad(){

    }

    @FXML
    private void handleMostrarHabitacionesDisponibles() {
        // Declaración de la variable para la conexión a la base de datos
        Connection con;

        // Credenciales para la conexión a la base de datos
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/HotelCR7";

        try {
            // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
            con = DriverManager.getConnection(url, usuario, password);

            // Creación de un objeto Statement para ejecutar consultas SQL
            Statement st = con.createStatement();

            // Declaración del objeto ResultSet que contendrá los resultados de la consulta
            ResultSet rs;

            String consulta = "SELECT numHabitacion,tipoHabitacion FROM habitacion where disponible=true";

            // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
            rs = st.executeQuery(consulta);

            // Encabezados para las columnas en el TextArea
            textArea.setText("Numero de habitación disponible\t\tTipo de habitación\n");

            // Iterar sobre el ResultSet y mostrar los resultados en el TextArea
            while (rs.next()) {
                int numero = rs.getInt("numHabitacion");
                String tipo = rs.getString("tipoHabitacion");


                // Añadir la información de cada reserva al TextArea
                textArea.appendText(numero + "\t\t\t\t\t\t\t\t" + tipo + "\t\n");
            }

            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    private void registrarReserva() {

        String nom = nombre.getText();
        String ape = apellido.getText();
        String email = correo.getText();
        LocalDate llegada = fechaLlegada.getValue();
        LocalDate salida = fechaSalida.getValue();
        String numeroTel = telefono.getText();
        int numeroHabitacion =numHab.getValue();

        Connection con1;

        // Credenciales para la conexión a la base de datos
        String usuario1="root";
        String password1="1234";
        String url1="jdbc:mysql://localhost:3306/HotelCR7";

        try {
            // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
            con1= DriverManager.getConnection(url1,usuario1,password1);

            String consulta ="INSERT INTO reservas (nombreCliente, apellidoCliente, correo_electronico, numeroTel, fecha_llegada, fecha_salida, numeroHabitacion) " +
                    "VALUES (?,?,?,?,?,?,?)";

            // Creación de un objeto PreparedStatement para ejecutar la consulta SQL
            PreparedStatement stmt = con1.prepareStatement(consulta);
            // Establecimiento de los parámetros de la consulta
            stmt.setString(1, nom);
            stmt.setString(2, ape);
            stmt.setString(3, email);
            stmt.setString(4, numeroTel);
            stmt.setDate(5, Date.valueOf(llegada));
            stmt.setDate(6, Date.valueOf(salida));
            stmt.setInt(7, numeroHabitacion);

            // Ejecución de la consulta SQL
            stmt.executeUpdate();
            // Consulta para actualizar la disponibilidad de la habitación
            String updateHabitacion = "UPDATE habitacion SET disponible = false WHERE numHabitacion = ?";

            PreparedStatement stmtUpdate = con1.prepareStatement(updateHabitacion);
            stmtUpdate.setInt(1, numeroHabitacion);
            stmtUpdate.executeUpdate();

            // Ejecución del UPDATE SQL y MODIFICAMOS de los resultados
            //st.executeUpdate(updateHabitacion);

            con1.close();
            //mensaje.setText("Reserva registrada exitosamente");
        } catch (SQLException e1) {
            e1.printStackTrace();
            // Opcional: mostrar mensaje de error
            //mensaje.setText("Error al registrar la reserva");
        }
    }

    @FXML
    private void eliminarReservas() {
        Connection connection;
        String usuario="root";
        String contrasenya="1234";
        String url="jdbc:mysql://localhost:3306/HotelCR7";

        try {
            connection=DriverManager.getConnection(url,usuario,contrasenya);
            Statement st=connection.createStatement();
            ResultSet rs;
            String consulta="Delete * from reservas where fecha_llegada='"+fechaLlegada.getValue()+"'"+ "and fecha_salida='"+fechaSalida+"'"+" and correo_electronico="+correo.getText();
            rs=st.executeQuery(consulta);

        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }

@FXML
private void mostrarReservas() {
    // Declaración de la variable para la conexión a la base de datos
    Connection con;

    // Credenciales para la conexión a la base de datos
    String usuario = "root";
    String password = "1234";
    String url = "jdbc:mysql://localhost:3306/HotelCR7";

    try {
        // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
        con = DriverManager.getConnection(url, usuario, password);

        // Creación de un objeto Statement para ejecutar consultas SQL
        Statement st = con.createStatement();

        // Declaración del objeto ResultSet que contendrá los resultados de la consulta
        ResultSet rs;

        String consulta = "SELECT * FROM reservas";

        // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
        rs = st.executeQuery(consulta);

        // Encabezados para las columnas en el TextArea
        //textArea.setText("ID\t\tNombre\t\tApellido\t\t\tCorreo\t\t\tTeléfono\t\t\tLlegada\t\t\tSalida\t\t\tHabitación\n");

        // Iterar sobre el ResultSet y mostrar los resultados en el TextArea
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombreCliente");
            String apellido = rs.getString("apellidoCliente");
            String correo = rs.getString("correo_electronico");
            String telefono = rs.getString("numeroTel");
            Date llegada = rs.getDate("fecha_llegada");
            Date salida = rs.getDate("fecha_salida");
            int habitacion = rs.getInt("numeroHabitacion");

            // Añadir la información de cada reserva al TextArea
            textArea.appendText(id + "\t\t" + nombre + "\t\t" + apellido + "\t\t" + correo + "\t\t" + telefono + "\t\t" +
                    llegada + "\t\t" + salida + "\t\t" + habitacion + "\t\n");
        }

        con.close();
    } catch (SQLException e1) {
        e1.printStackTrace();
    }
}
    public void asignarHabitacion() {
        // Declaración de la variable para la conexión a la base de datos
        Connection con;

        // Credenciales para la conexión a la base de datos
        String usuario = "root";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/HotelCR7";

        try {
            // Establecimiento de la conexión con la base de datos utilizando las credenciales y la URL
            con = DriverManager.getConnection(url, usuario, password);

            // Creación de un objeto Statement para ejecutar consultas SQL
            Statement st = con.createStatement();

            // Declaración del objeto ResultSet que contendrá los resultados de la consulta
            ResultSet rs;

            String consulta = "SELECT numHabitacion FROM habitacion WHERE disponible = true and tipoHabitacion=\'"+tipo.getValue()+"\'";

            // Ejecución de la consulta SQL y obtención de los resultados en el ResultSet
            rs = st.executeQuery(consulta);

            // Creación de una lista observable para almacenar los números de habitación
            ArrayList<Integer> habitacionesDisponibles = new ArrayList<>();

            // Iterar sobre el ResultSet y añadir los resultados a la lista observable
            while (rs.next()) {

                //int numero = rs.getInt("numHabitacion");
                habitacionesDisponibles.add(rs.getInt("numHabitacion"));
            }

            ObservableList<Integer> observableList = FXCollections.observableArrayList(habitacionesDisponibles);
            numHab.setItems(observableList);
            // Cierre de la conexión
            con.close();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        tipo.getItems().addAll("Habitación Individual","Habitación Doble","Suite");
        numHab.setOnAction(e ->{
            String tipoSelec=tipo.getValue();

        });

    }

}

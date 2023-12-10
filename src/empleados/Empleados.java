/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados;

/**
 *
 * @author Gabo
 */
public class Empleados {

    private String cedula;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private double sueldo;
    private String fechNacimiento;
    private String nacionalidad;
    private String canton;
    private String idDigital;
    private String correoPertenece;

    public Empleados(String cedula, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String telefono, double sueldo, String fechNacimiento, String nacionalidad, String canton, String idDigital, String correoPertenece) {
        this.cedula = cedula;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.sueldo = sueldo;
        this.fechNacimiento = fechNacimiento;
        this.nacionalidad = nacionalidad;
        this.canton = canton;
        this.idDigital = idDigital;
        this.correoPertenece = correoPertenece;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getFechNacimiento() {
        return fechNacimiento;
    }

    public void setFechNacimiento(String fechNacimiento) {
        this.fechNacimiento = fechNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getIdDigital() {
        return idDigital;
    }

    public void setIdDigital(String idDigital) {
        this.idDigital = idDigital;
    }

    public String getCorreoPertenece() {
        return correoPertenece;
    }

    public void setCorreoPertenece(String correoPertenece) {
        this.correoPertenece = correoPertenece;
    }
    
    
  
}
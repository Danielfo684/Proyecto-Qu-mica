package Proyecto_Quimica.Excepciones;

public class CampoVacioExcepcion extends Exception{
       /**
     * Constructor por defecto para obtener un mensaje más personalizado
     * pase el siguiente parámetro
     * @param campo NOMBRE del campo que requiera que tenga valor distinto de NULL
     */
    public CampoVacioExcepcion(String campo){
        super(String.format("Atención el campo %s no puede ser vacío",campo));

    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author David
 * Hemos refactorizado al Español todas las constantes, variables 
 * y los nombres de los métodos
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] bufer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream flujoSalida = null;

    public static void iniciarArchivos() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(nombreArchivo);
        flujoSalida = new BufferedInputStream(flujoEntrada);
    }
    
    public static int mostrarTextoArchivo() throws IOException
    {
        int total = 0;
        int nLecturas = 0;
        while((nLecturas = flujoEntrada.read(bufer)) != -1) 
        {
            System.out.println(new String(bufer));
            total += nLecturas;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            iniciarArchivos();
            
            int total = mostrarTextoArchivo();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( flujoSalida != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    flujoSalida.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}

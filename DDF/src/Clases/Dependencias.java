/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author jhon_quiceno
 */
public class Dependencias {
    
    char[] _implicantes;
    char[] _implicados;
    boolean _EsTrivial;
    int[] _posicion;
    
    public Dependencias(char[] implicantes , char[] implicados, boolean EStrivial)
    {
        _implicantes=implicantes;
        _implicados=implicados;
        _EsTrivial=EStrivial;
    }
    
    public void setImplicantes(char[] implicantes){ _implicantes=implicantes;}
    public char[] getImplicantes(){ return _implicantes;}
    
    public void setImplicado(char[] implicados){ _implicados=implicados;}
    public char[] getImplicados(){ return _implicados;}
    
    public void setEsTrivial(boolean EsTrivial){ _EsTrivial=EsTrivial;}
    public boolean getEstrivial(){ return _EsTrivial;}
    
    public void setPosicion(int[] Posicion){ _posicion=Posicion;}
    public int[] getPosicion(){ return _posicion;}
       
}

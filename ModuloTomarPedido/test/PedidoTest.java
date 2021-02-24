/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.junit.*;
import com.caprice.datos.common.IRepository;
import com.caprice.dominio.*;
import java.util.ArrayList;

/**
 *
 * @author chelo
 */
public class PedidoTest {

    private static ArrayList<Producto> productos;
    private static ArrayList<Mesa> mesas;
    
    public PedidoTest() {
    }
    
    @Before
    public void setUp()
    {
        productos = new ArrayList<>();
        
        mesas = new ArrayList<>();
        
        productos.add(new Producto(1,"Pizza",100));
        
        productos.add(new Producto(2,"Gaseosa",50));
        
        mesas.add(new Mesa(1,2));
        
        mesas.add(new Mesa(1,4));
    }
    

    @Test
    public void TestNuevoPedido(){     
        
        Pedido pedido = new Pedido(1,2);
        Mesa mesa = mesas.get(0);
        
        pedido.setMesas(mesa);
        
        Producto producto1 = productos.get(0);
        Producto producto2 = productos.get(1);
        
        pedido.agregarLinea(producto1,2);
        pedido.agregarLinea(producto2,3);
        
        double total = pedido.getTotal();
        
        assertEquals(350,total,0);       
        
    }
    
    @Test
    public void TestMesaOcupada(){
        
        Pedido pedido = new Pedido(1,2);
        Mesa mesa = mesas.get(0);
        
        pedido.setMesas(mesa);
        
        EstadoMesa esperado = pedido.getMesaPrincipal().getEstado();
        
        Assert.assertEquals(esperado, EstadoMesa.OCUPADO);  
        
    }
    
    @Test
    public void TestMesaPrincipalOcupada(){
        
        Pedido pedido = new Pedido(1,2);
        Mesa mesa = mesas.get(0);
        Mesa mesa2 = mesas.get(1);
        
        mesa.combinar(mesa2);
        
        pedido.setMesas(mesa);
        
        EstadoMesa esperado = pedido.getMesaPrincipal().getEstado();
        
        Assert.assertEquals(esperado, EstadoMesa.OCUPADO);  
        
    }
    
    @Test
    public void TestMesaPrincipalOcupada2(){
        
        Pedido pedido = new Pedido(1,2);
        Mesa mesa = mesas.get(0);
        Mesa mesa2 = mesas.get(1);
        
        mesa2.combinar(mesa);
        
        pedido.setMesas(mesa);
        
        EstadoMesa esperado = pedido.getMesaPrincipal().getEstado();
        
        Assert.assertEquals(esperado, EstadoMesa.OCUPADO);  
        
    }
}

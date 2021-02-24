/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.caprice.datos.common.RepositoryManager;
import com.caprice.aplicacion.ControladorTomarPedido;
import com.caprice.dominio.EstadoMesa;
import com.caprice.dominio.Mesa;
import com.caprice.dominio.Pedido;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chelo
 */
public class ControladorTomarPedidoTest {
    
    private  ControladorTomarPedido controlador;
    private  RepositoryManager manager;
    
    public ControladorTomarPedidoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {           
        
        manager = new RepositoryManager();
        manager.seedData();
        this.controlador = new ControladorTomarPedido(manager);
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TestCrearVenta(){
        
       
        
        controlador.iniciarPedido();
        double total = controlador.getNuevoPedido().getTotal();
        
        assertEquals(0,total, 0);
    }
    
    @Test
    public void TestListarMesas(){        
        
        Object expected[] =  manager.getRepoMesas().obtener().toArray();       
        
        Object mesas[] = controlador.getMesasLibres().toArray();
        
        System.out.println(mesas);
        
        assertArrayEquals(expected,mesas);
    }
    
    @Test
    public void TestMesaCombinada(){
        
        
        Mesa mesaDisponible =  manager.getRepoMesas().buscarPorID(1);
        Mesa mesaACombinar =  manager.getRepoMesas().buscarPorID(2);   
        Mesa mesaACombinar2 = manager.getRepoMesas().buscarPorID(3);
        
        Object mesasExpected[] = new Object[]{mesaDisponible};
        
        mesaDisponible.combinar(mesaACombinar);     
        mesaDisponible.combinar(mesaACombinar2);
        
        Object mesasReales[] = controlador.getMesasLibres().toArray();
        
        assertArrayEquals(mesasExpected, mesasReales);       
        
    }  
    
    @Test
    public void TestMesaOcupada(){
        
        
        Mesa mesaDisponible =  manager.getRepoMesas().buscarPorID(1);
        Mesa mesaACombinar =  manager.getRepoMesas().buscarPorID(2);        
        Mesa mesaACombinar2 = manager.getRepoMesas().buscarPorID(3);
        
        Object mesasExpected[] = new Object[]{mesaDisponible};
        
        mesaACombinar.ocupar();
        mesaACombinar2.ocupar();
        
        Object mesasReales[] = controlador.getMesasLibres().toArray();
        
        assertArrayEquals(mesasExpected, mesasReales);      
        
    }
    
    @Test
    public void TestAgregarProducto(){
        
        
        controlador.iniciarPedido();
        controlador.setMesa(1);
        controlador.agregarProducto(1, 2);
        controlador.agregarProducto(2, 2);
        
        double totalEsperado = 800;
        
        double real = controlador.getNuevoPedido().getTotal();
        
        assertEquals(totalEsperado, real,0);
    }
    
    @Test
    public void TestCombinarMesa(){
        
        Mesa mesaDisponible =  manager.getRepoMesas().buscarPorID(1);
        Mesa mesaACombinar =  manager.getRepoMesas().buscarPorID(2);
        
        Object mesasExpected[] = new Object[]{mesaDisponible,mesaACombinar};
        mesaDisponible.combinar(mesaACombinar);
        
        controlador.iniciarPedido();
        controlador.setMesa(1);
       
        Object real[] = controlador.getNuevoPedido().getMesas().toArray();
        
        assertArrayEquals(mesasExpected, real);
        
    }
    
    @Test
    public void ConfirmarMesa(){
        
        Mesa mesaDisponible =  manager.getRepoMesas().buscarPorID(1);
        Mesa mesaACombinar =  manager.getRepoMesas().buscarPorID(2);
        
        mesaDisponible.combinar(mesaACombinar);
        
        controlador.iniciarPedido();
        controlador.setMesa(1);
        
        controlador.agregarProducto(1, 1);
        controlador.agregarProducto(2, 1);
        
        controlador.confirmarPedido();
        
        EstadoMesa estados[] = new EstadoMesa[]{EstadoMesa.OCUPADO,EstadoMesa.COMBINADO};
        
        Pedido pedido = manager.getRepoPedidos().buscarPorID(1);
        
        EstadoMesa reales[] = new EstadoMesa[pedido.getMesas().size()];
        
        for(int i=0; i < pedido.getMesas().size(); i++) reales[i] = pedido.getMesas().get(i).getEstado();
        
        assertArrayEquals(estados, reales);
       
      
    }
        
    
}

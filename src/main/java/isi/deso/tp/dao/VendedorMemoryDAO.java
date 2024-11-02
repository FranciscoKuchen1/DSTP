package isi.deso.tp.dao;

import isi.deso.tp.exception.VendedorNoEncontradoException;
import isi.deso.tp.model.Vendedor;
import java.util.ArrayList;
import java.util.List;

public class VendedorMemoryDAO implements VendedorDAO {

    private List<Vendedor> listaVendedores;
    private static VendedorMemoryDAO VendedorMemoryDAO;

    private VendedorMemoryDAO() {
    }

    public static VendedorMemoryDAO getInstance() {
        if (VendedorMemoryDAO.VendedorMemoryDAO == null) {
            VendedorMemoryDAO.VendedorMemoryDAO = new VendedorMemoryDAO();
            VendedorMemoryDAO.VendedorMemoryDAO.listaVendedores = new ArrayList<>();

        }

        return VendedorMemoryDAO.VendedorMemoryDAO;
    }

    @Override
    public List<Vendedor> listarVendedor() {
        return this.listaVendedores;
    }

    @Override
    public void crearVendedor(Vendedor Vendedor) {
        this.listaVendedores.add(Vendedor);
    }

    @Override
    public void actualizarVendedor(Vendedor Vendedor) {
        this.listaVendedores.remove(Vendedor.getId());
        this.listaVendedores.add(Vendedor);
    }

    @Override
    public void eliminarVendedor(int idVendedor) {
        this.listaVendedores.remove(idVendedor);
    }

    @Override
    public List<Vendedor> buscarVendedor(int idVendedor) {
        return this.listaVendedores.stream().filter(Vendedor -> Vendedor.getId() == idVendedor).toList();
    }
    
    public void VendedorNoEncontrado(boolean condicion) throws VendedorNoEncontradoException{
        if(!condicion){
            throw new VendedorNoEncontradoException();
        }
    }
    
    
    @Override
    public Vendedor buscarVendedorPorNombre(String nombre) throws VendedorNoEncontradoException {
        Vendedor vendedor = null;
        VendedorNoEncontradoException excep;
        for(Vendedor v : this.listaVendedores){
            if(v.getNombre().equals(nombre)){
                vendedor = v;
            }
        }
        if(vendedor == null){
            VendedorNoEncontrado(true);
        }
        return vendedor;
    }

}
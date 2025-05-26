package Entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author welvin
 */
public class Compra {

    private int id_compra;
    private int id_Proveedor;
    private Date Fe_compra;
    private float totalCompra;

    public Compra() {
    }

    public Compra(int id_compra, int id_Proveedor, Date Fe_compra, float totalCompra) {
        this.id_compra = id_compra;
        this.id_Proveedor = id_Proveedor;
        this.Fe_compra = Fe_compra;
        this.totalCompra = totalCompra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_Proveedor() {
        return id_Proveedor;
    }

    public void setId_Proveedor(int id_Proveedor) {
        this.id_Proveedor = id_Proveedor;
    }

    public Date getFe_compra() {
        return Fe_compra;
    }

    public void setFe_compra(Date Fe_compra) {
        this.Fe_compra = Fe_compra;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    
}

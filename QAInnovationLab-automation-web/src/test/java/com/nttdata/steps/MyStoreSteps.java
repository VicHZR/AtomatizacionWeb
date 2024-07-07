package com.nttdata.steps;

import com.nttdata.page.MyStorePage;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class MyStoreSteps {
    WebDriver driver;
    MyStorePage page;

    public MyStoreSteps(WebDriver driver) {
        this.driver = driver;
        page = new MyStorePage(driver);
    }

    public void clickInicarSesion() throws InterruptedException {
        page.clickIniciarSesion();
    }

    public void escribirCredenciales(String arg0, String arg1) throws InterruptedException {
        page.sendTextUsuario(arg0);
        page.sendTextContraseña(arg1);
    }

    public void submit() throws InterruptedException {
        page.clickSubmit();
    }

    public void clickCategoria(String arg0) throws InterruptedException {
        page.clickCategoria(arg0);
    }

    public void clickSubCategoria(String arg0) throws InterruptedException {
        page.clickSubCategoria(arg0);
    }

    public void clickPrimerProducto() throws InterruptedException {
        page.clickPrimerProducto();
    }

    public void seleccionarCantidad(int arg0) throws InterruptedException {
        page.seleccionarCantidad(arg0);
    }

    public void clickAgregarCarrito() throws InterruptedException {
        page.clickAgregarCarrito();
    }

    public void validarPopUpProductoAgregado() throws InterruptedException {
        String tiulo_actual = page.getTextTituloModalCarrito();
        assertEquals("Producto añadido correctamente a su carrito de compra", tiulo_actual);
    }

    public float calcularPrecioXUnidades(int arg0) throws InterruptedException {
        return page.getPrecioProductoUnidad() * arg0;
    }

    public void validarPrecioCalculadoCorrectoEnModal(float precioCalculado) throws InterruptedException {
        float precio_modal = page.getPrecioModal();
        assertEquals(precio_modal, precioCalculado, 0.00f);
    }

    public void clickFinalizarCompra() throws InterruptedException {
        page.clickFinalizarCompra();
    }

    public void validarTituloPaginaCarrito() throws InterruptedException {
        String tiulo_actual = page.getTextTituloCarrito();
        assertEquals("CARRITO", tiulo_actual);
    }

    public void validarPrecioCalculadoCorrectoEnCarrito(float precioCalculado) throws InterruptedException {
        float precio_modal = page.getPecioCarrito();
        assertEquals(precio_modal, precioCalculado, 0.00f);
    }
}

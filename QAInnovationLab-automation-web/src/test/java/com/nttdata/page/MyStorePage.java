package com.nttdata.page;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyStorePage {
    private WebDriver driver;
    private By btnInciarSesion = By.xpath("//span[text()='Iniciar sesión']");
    private By txtUsuario = By.xpath("//input[@id='field-email' and @name='email']");
    private By txtContraseña = By.xpath("//input[@id='field-password' and @name='password']");
    private By btnsubmit = By.xpath("//button[@id='submit-login']");
    private By btnPrimerProducto = By.xpath("(//a[@class='thumbnail product-thumbnail'])[1]");
    private By textCantidadProductos = By.xpath("//input[@name='qty' and @id='quantity_wanted']");
    private By btnMasProductos = By.xpath("//button[@class='btn btn-touchspin js-touchspin bootstrap-touchspin-up']");
    private By btnAgregarCarrito = By.xpath("//button[contains(., 'Añadir al carrito')]");
    private By lblPrecioProductoUnidad = By.xpath("//div[@class='current-price']/span[@class='current-price-value']");
    private By lblTituloModalCarrito = By.xpath("//div[@class='modal-content']/div[@class='modal-header']/h4");
    private By lblPrecioTotalModal = By.xpath("(//p[@class='product-total']/span)[2]");
    private By btnFinalizarCompra = By.xpath("//a[contains(., 'Finalizar compra')]");
    private By lblTituloCarrito = By.xpath("//div[@class='card-block']/h1");
    private By lblPrecioTotalCarrito = By.xpath("(//div[@class='cart-summary-line cart-total']/span)[2]");
    private WebDriverWait wait;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickIniciarSesion() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btnInciarSesion));
        WebElement btn_iniciar_sesion = driver.findElement(btnInciarSesion);
        btn_iniciar_sesion.click();
    }

    public void sendTextUsuario(String usuario) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUsuario));
        WebElement txt_usuario = driver.findElement(txtUsuario);
        txt_usuario.sendKeys(usuario);
    }

    public void sendTextContraseña(String contraseña) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtContraseña));
        WebElement txt_usuario = driver.findElement(txtContraseña);
        txt_usuario.sendKeys(contraseña);
    }

    public void clickSubmit() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btnsubmit));
        WebElement btn_submit = driver.findElement(btnsubmit);
        btn_submit.click();
    }

    public void clickCategoria(String arg0) throws InterruptedException {
        By btnCategoria = By.xpath("//a[contains(., '" + arg0 + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(btnCategoria));
        WebElement btn_categoria = driver.findElement(btnCategoria);
        btn_categoria.click();
    }

    public void clickSubCategoria(String arg0) throws InterruptedException {
        By btnSubCategoria = By.xpath("//li//h5/a[contains(text(), '" + arg0 + "')]");
        wait.until(ExpectedConditions.elementToBeClickable(btnSubCategoria));
        WebElement btn_sub_categoria = driver.findElement(btnSubCategoria);
        btn_sub_categoria.click();
    }

    public void clickPrimerProducto() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btnPrimerProducto));
        WebElement btn_categoria = driver.findElement(btnPrimerProducto);
        btn_categoria.click();
    }

    public void seleccionarCantidad(int arg0) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btnMasProductos));
        WebElement text_cantidad = driver.findElement(textCantidadProductos);
        WebElement btn_mas_productos = driver.findElement(btnMasProductos);

        int cantidad_actual = Integer.parseInt(text_cantidad.getAttribute("value"));

        while (cantidad_actual < arg0) {
            btn_mas_productos.click();
            cantidad_actual = Integer.parseInt(text_cantidad.getAttribute("value"));
            if (cantidad_actual == arg0) {
                break;
            }
        }
    }

    public void clickAgregarCarrito() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btnAgregarCarrito));
        WebElement btn_agregar_carrito = driver.findElement(btnAgregarCarrito);
        btn_agregar_carrito.click();
    }

    public float getPrecioProductoUnidad() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPrecioProductoUnidad));
        WebElement lbl_precio_producto_unidad = driver.findElement(lblPrecioProductoUnidad);
        String precioConMoneda = lbl_precio_producto_unidad.getText();

        // Define la expresión regular para extraer el número
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(precioConMoneda);

        if (matcher.find()) {
            // Convertir el texto encontrado a float
            return Float.parseFloat(matcher.group());
        } else {
            throw new RuntimeException("No se pudo encontrar el precio en el texto: " + precioConMoneda);
        }
    }

    public String getTextTituloModalCarrito() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblTituloModalCarrito));
        WebElement lbl_titulo_modal_carrito = driver.findElement(lblTituloModalCarrito);
        String tituloConIcono = lbl_titulo_modal_carrito.getText();

        // Eliminar el ícono del texto
        return tituloConIcono.replaceAll("^\\P{L}+", "").trim();
    }

    public float getPrecioModal() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPrecioTotalModal));
        WebElement lbl_precio_total_modal = driver.findElement(lblPrecioTotalModal);
        String precioConMoneda = lbl_precio_total_modal.getText();

        // Define la expresión regular para extraer el número
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(precioConMoneda);

        if (matcher.find()) {
            // Convertir el texto encontrado a float
            return Float.parseFloat(matcher.group().trim());
        } else {
            throw new RuntimeException("No se pudo encontrar el precio en el texto: " + precioConMoneda);
        }
    }

    public void clickFinalizarCompra() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btnFinalizarCompra));
        WebElement btn_finalizar_compra = driver.findElement(btnFinalizarCompra);
        btn_finalizar_compra.click();
    }

    public String getTextTituloCarrito() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblTituloCarrito));
        WebElement lbl_titulo_carrito = driver.findElement(lblTituloCarrito);
        return lbl_titulo_carrito.getText().trim();
    }

    public float getPecioCarrito() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lblPrecioTotalCarrito));
        WebElement lbl_precio_total_modal = driver.findElement(lblPrecioTotalCarrito);
        String precioConMoneda = lbl_precio_total_modal.getText();

        // Define la expresión regular para extraer el número
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(precioConMoneda);

        if (matcher.find()) {
            // Convertir el texto encontrado a float
            return Float.parseFloat(matcher.group().trim());
        } else {
            throw new RuntimeException("No se pudo encontrar el precio en el texto: " + precioConMoneda);
        }
    }
}

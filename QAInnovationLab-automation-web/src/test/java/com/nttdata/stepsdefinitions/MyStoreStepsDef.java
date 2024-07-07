package com.nttdata.stepsdefinitions;

import com.nttdata.steps.MyStoreSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStoreStepsDef {

    private MyStoreSteps mystore;
    private WebDriver driver;
    private Scenario scenario;
    private float precio_calculado;

    @Before(order = 0)
    public void setUp() {
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @After
    public void quitDriver() {
        driver.quit();
    }


    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver.get("https://qalab.bensg.com/store/");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String arg0, String arg1) throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.clickInicarSesion();
        mystore.escribirCredenciales(arg0, arg1);
        screenShot();
        mystore.submit();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String arg0, String arg1) throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.clickCategoria(arg0);
        screenShot();
        mystore.clickSubCategoria(arg1);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.clickPrimerProducto();
        screenShot();
        mystore.seleccionarCantidad(arg0);
        screenShot();
        mystore.clickAgregarCarrito();
        precio_calculado = mystore.calcularPrecioXUnidades(arg0);
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.validarPopUpProductoAgregado();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.validarPrecioCalculadoCorrectoEnModal(precio_calculado);
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.clickFinalizarCompra();
    }

    @Then("valido el titulo de la pagia del carrito")
    public void validoElTituloDeLaPagiaDelCarrito()  throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.validarTituloPaginaCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() throws InterruptedException {
        mystore = new MyStoreSteps(driver);
        mystore.validarPrecioCalculadoCorrectoEnCarrito(precio_calculado);
    }

    public void screenShot() {
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }
}

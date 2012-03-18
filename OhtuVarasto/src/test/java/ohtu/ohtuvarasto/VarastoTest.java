
package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class VarastoTest {
 
    Varasto varasto;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
 
    @Test
    public void konstruktoriLuoTyhjanVaraston() {

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktorilleAnnetaanNegatiivinenArvo() {
        varasto = new Varasto(-5);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void KaksiOsainenkonstruktorilleAnnetaanNegatiivinenArvo() {
        varasto = new Varasto(-5, -5);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    
    @Test
    public void KaksiOsainenkonstruktoriNormaali() {
        varasto = new Varasto(15, 10);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
        @Test
    public void KaksiOsainenkonstruktoriSaldoLiianIso() {
        varasto = new Varasto(5, 10);
        assertEquals(5, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
 
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaLiikaa() {
        varasto.lisaaVarastoon(50);

        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
        @Test
    public void lisaysLisaanegatiivinen() {
        varasto.lisaaVarastoon(-5);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
        
    @Test
    public void nyhjaaTyhjaa() {
        varasto.lisaaVarastoon(0);
 
        double saatuMaara = varasto.otaVarastosta(-2);
 
        assertEquals(0, saatuMaara, vertailuTarkkuus);
    } 
 
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    } 
    @Test
    public void ottaminenNegatiivisena() {
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }
    @Test
    public void ottaminenLiikaa() {
        
         varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(9);
 
        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);
  
        String s = varasto.toString();
        
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
        assertTrue(s.startsWith("saldo = 6.0"));
    }
}
package org.iesvdm.reservamesa;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReservaMesaTest {

    @Test
    void failTest() {
        fail("TEST SIN IMPLEMENTAR");
    }


    @Test
    void rellenarMesasTest1(){

        //when
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(5);
        reserva.setMesas(new int[5]);
        reserva.rellenarMesas();

        //Do
        for (int i = 0; i < reserva.getMesas().length; i++) {
            assertThat(reserva.getMesas()[i]).isBetween(1, 5);

        }

        //then
            assertThat(reserva.getMesas()).isNotNull();
            assertThat(reserva.getMesas()).hasSize(5);
        }



        @Test
        void rellenarMesasTestArraysNegativo(){

            // When
            ReservaMesa reserva = new ReservaMesa();
            reserva.setTamanioMesa(1);
            reserva.setMesas(new int[-1]);
            reserva.rellenarMesas();

            // Do
            for (int i = 0; i < reserva.getMesas().length; i++) {
                assertThat(reserva.getMesas()[i]).isEqualTo(-1);

            }

            // Then
            assertThat(reserva.getMesas()).isNotNull();
            assertThat(reserva.getMesas()).hasSize(-1);
        }

    @Test
    void rellenarMesasTestArrayVacio(){

    //when
    ReservaMesa reserva = new ReservaMesa();
    reserva.setTamanioMesa(2);
    reserva.setMesas(new int[0]);
    reserva.rellenarMesas();


    //Do
    for (int i = 0; i < reserva.getMesas().length; i++) {
        assertThat(reserva.getMesas()[i]).isEqualTo(0);

    }

    //Then
        assertThat(reserva.getMesas()).isNotNull();
    assertThat(reserva.getMesas()).hasSize(0);

    }

    @Test
    void imprimirTest(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(4);
        reserva.setMesas(new int[4]);
        reserva.rellenarMesas();

        //Do Then
        assertThat(reserva.getMesas()).isNotNull();
        assertThat(reserva.getMesas()).hasSize(4);
        reserva.imprimir();
    }

    @Test
    void imprimirTestArrayVacio(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(0);
        int [] mesas = {};
        reserva.setMesas(mesas);

        //Do Then
        assertThat(reserva.getMesas()).isNotNull();
        assertThat(reserva.getMesas()).hasSize(0);
        reserva.imprimir();
    }


    @Test
    void buscarPrimerMesaVaciaTest(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(4);
        int [] mesas = {1, 2, 0, 4};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarPrimeraMesaVacia();

        //Then
        assertThat(resultado).isEqualTo(2);
    }

    @Test
    void buscarPrimerMesaVaciaTestArrayVacio(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(0);
        int [] mesas = {};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarPrimeraMesaVacia();

        //Then
        assertThat(resultado).isEqualTo(-1);
    }

    @Test
    void buscarPrimerMesaVaciaTestArrayNegativo(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(-1);
        int [] mesas = {-1};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarPrimeraMesaVacia();

        //Then
        assertThat(resultado).isEqualTo(-1);
    }

    @Test
    void buscarMesaParaCompartirTest(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(4);
        int [] mesas = {1, 2, 0, 4};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarMesaParaCompartir(2);

        //Then
        assertThat(resultado).isEqualTo(0);
    }

    @Test
    void buscarMesaParaCompartirTestCompleto(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(4);
        int [] mesas = {2, 2, 3, 4};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarMesaParaCompartir(3);

        //Then
        assertThat(resultado).isEqualTo(-1);
    }

    @Test
    void buscarMesaParaCompartirTestMesaNoDisponible(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(5);
        int [] mesas = {0, 2, 5, 3};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarMesaParaCompartir(6);

        //Then
        assertThat(resultado).isEqualTo(-1);
    }

    @Test
    void buscarMesaCompartirMasCercaDeTestEncontarMesa(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(6);
        int [] mesas = {2, 4, 4, 1};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarMesaCompartirMasCercaDe(1, 3);

        //Then
        assertThat(resultado).isEqualTo(0);

    }

    @Test
    void buscarMesaCompartirMasCercaDeTestNoEncontrarMesa(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(6);
        int [] mesas = {2, 4, 4, 1};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarMesaCompartirMasCercaDe(1, 6);

        //Then
        assertThat(resultado).isEqualTo(-1);

    }

    @Test
    void buscarMesaCompartirMasAlejadaDeTestEncontrarMesa(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(6);
        int [] mesas = {2, 1, 2, 1};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarMesaCompartirMasAlejadaDe(3, 3);

        //Then
        assertThat(resultado).isEqualTo(0);

    }

    @Test
    void buscarMesaCompartirMasAlejadaDeTestNoEncontrarMesa(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(3);
        int [] mesas = {2, 2, 2, 2};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarMesaCompartirMasAlejadaDe(1, 2);

        //Then
        assertThat(resultado).isEqualTo(-1);

    }

    @Test
    void buscarCompartirMesasCensecutivasTestNoEncontrarMesa(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(3);
        int [] mesas = {2, 2, 2, 2};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarCompartirNMesasConsecutivas(2, 5);

        //Then
        assertThat(resultado).isEqualTo(-1);

    }

    @Test
    void buscarCompartirMesasCensecutivasTestEncontrarMesa(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(3);
        int [] mesas = {2, 1, 2, 2};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.buscarCompartirNMesasConsecutivas(2, 3);

        //Then
        assertThat(resultado).isEqualTo(0);

    }

  @Test
    void comensalesTotalesTest(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(3);
        int [] mesas = {2, 1, 2, 2};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.comensalesTotales();

        //Then
        assertThat(resultado).isEqualTo(7);

    }

    @Test
    void comensalesTotalesTestArrayVacio(){
        //When
        ReservaMesa reserva = new ReservaMesa();
        reserva.setTamanioMesa(0);
        int [] mesas = {};
        reserva.setMesas(mesas);

        //Do
        int resultado = reserva.comensalesTotales();

        //Then
        assertThat(resultado).isEqualTo(0);

    }



}

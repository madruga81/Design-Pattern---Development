package com.fiap.dp.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fiap.dp.composite.domain.City;
import com.fiap.dp.composite.domain.Country;
import com.fiap.dp.composite.domain.Plan;
import com.fiap.dp.composite.domain.Region;
import com.fiap.dp.composite.domain.State;

public class PlanTest {

    public static void main(String[] args) {
        Country brasil = new Country("Brasil");

        Country eua = new Country("EUA");

        State sp = new State("SP", brasil);

        State mg = new State("MG", brasil);

        State california = new State("California", eua);

        City saoPaulo = new City("São Paulo", sp);

        City beloHorizonte = new City("Belo Horizonte", mg);

        City losAngeles = new City("Los Angeles", california);

        Region todoOBrasil = new Region("Todo o Brasil");
        todoOBrasil.addPlace(brasil);

        Region spEBeloHorizonte = new Region("SP e Belo Horizonte");
        spEBeloHorizonte.addPlace(sp);
        spEBeloHorizonte.addPlace(beloHorizonte);

        Region cidadeDeSaoPaulo = new Region("Cidade de São Paulo");
        cidadeDeSaoPaulo.addPlace(saoPaulo);

        Region euaECidadeDeSaoPaulo = new Region("EUA e Cidade de São Paulo");
        euaECidadeDeSaoPaulo.addPlace(eua);
        euaECidadeDeSaoPaulo.addPlace(cidadeDeSaoPaulo);

        Region brasilEEua = new Region("Brasil e EUA");
        brasilEEua.addPlace(brasil);
        brasilEEua.addPlace(eua);

        Region estadoDeMg = new Region("Estado de MG");
        estadoDeMg.addPlace(mg);
        
        List plans = new ArrayList();
        plans.add(new Plan(todoOBrasil));
        plans.add(new Plan(spEBeloHorizonte));
        plans.add(new Plan(cidadeDeSaoPaulo));
        plans.add(new Plan(euaECidadeDeSaoPaulo));
        plans.add(new Plan(brasilEEua));
        plans.add(new Plan(estadoDeMg));

        List cities = new ArrayList();
        cities.add(saoPaulo);
        cities.add(beloHorizonte);
        cities.add(losAngeles);

        for (Iterator cityIter = cities.iterator(); cityIter.hasNext();) {
            City city = (City) cityIter.next();
            System.out.print(" | " + city.getName());
        }
        System.out.println();

        for (Iterator planIter = plans.iterator(); planIter.hasNext();) {
            Plan plan = (Plan) planIter.next();
            System.out.print(plan);
            for (Iterator cityIter = cities.iterator(); cityIter.hasNext();) {
                City city = (City) cityIter.next();
                System.out.print(";" + plan.isOfferedIn(city));
            }
            System.out.println();
        }
    }

}

package br.com.fiap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Menu atua como uma fábrica e mantém os objetos flyweight CoffeeFlavour em cache
class Menu {
	private Map<String, CoffeeFlavour> flavours = new ConcurrentHashMap<String, CoffeeFlavour>();

	CoffeeFlavour lookup(String flavorName) {
		if (!flavours.containsKey(flavorName))
			flavours.put(flavorName, new CoffeeFlavour(flavorName));
		return flavours.get(flavorName);
	}

	int totalCoffeeFlavoursMade() {
		return flavours.size();
	}
}

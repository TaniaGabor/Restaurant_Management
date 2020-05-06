package businessLayer;

public interface IRestaurantProcessing {

/** Interfata IRestaurantProcessing
 * contine metoda addMenu_ care va fi implementata in clasa Restaurant si va adauga in lista de meniuri .
 * contine metoda deleteMenu_ care va sterge un meniu din lista.
 * contine metoda editMenu_ care poate edita pretul unui meniu.
 * @param p Meniu de adaugat **/
    void addMenu_(IMenuItem p);
    void deleteMenu_(String nameC);
    void editMenu_(String nameC,Float priceC);

}

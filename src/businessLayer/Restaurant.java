package businessLayer;
import java.util.*;
import java.io.Serializable;
/**Clasa Restaurant reorezinta clasa cea mai importanta pentru acest proiect **/

public class Restaurant extends Observable implements IRestaurantProcessing, Serializable {

    private Map<Order, List<IMenuItem>> restaurantOrder;
    private List<IMenuItem> allmenuItems;


    /**
     * @param object variabila care se verifica a fi diferita de null.
     * cu aceasta metoda am definit invariantul
     * @return returneaza true daca obiectul este diferit de null.
     */
    public boolean iswellFormed(Object object)
    { if(object==null) return false;
    else return true;
    }

    /** Constructorul pentru Restaurant prin care creez un nou HasMap() pentru
     * noi comenzi care vor fi introduse si lista acre contine toate meniurile.
     */
    public Restaurant() {
        this.restaurantOrder = new HashMap<>();
        this.allmenuItems = new ArrayList<>();

    }

    /** Constructor pentru clasa Restaurant
     *
     * @param restaurantOrder noi comenzi care vor fi introduse alaturi de meniurile lor.
     * @param allmenuItems lista care contine toate meniurile.
     */
    public Restaurant(Map<Order, List<IMenuItem>> restaurantOrder, List<IMenuItem> allmenuItems) {
        this.restaurantOrder = restaurantOrder;
        this.allmenuItems = allmenuItems;

    }

    /**
     *
     * @param p reprezinta obiectul de tip IMenuItem care va fi introdus si poate sa fie BaseProduct sau CompositeProduct.
     */
    @Override
    public void addMenu_(IMenuItem p) {
        assert(iswellFormed(p)); /**invariant,verific ca p sa nu fie null **/
        assert(p.compositePrice_()>0);/**preconditie,verific ca pretul sa fie >0  **/
       int size = this.allmenuItems.size();
        allmenuItems.add(p);
        assert(this.allmenuItems.size()==size+1);/**postconditie,verific ca numarul de obiecte s a schimbat  **/

    }

    /**
     *
     * @param nameC reprezinta numele meniului introdus in GUI care urmeaza sa fie introdus in lista.
     */
    @Override
    public void deleteMenu_(String nameC) {

        assert(iswellFormed(nameC));/**invariantul verifica daca nameC este diferit de null**/
        assert(!this.getAllmenuItems().isEmpty());/**preconditia verifica ca lista  sa nu fie goala**/
        int size=this.getAllmenuItems().size();
        Iterator<IMenuItem> itr = this.getAllmenuItems().iterator();/**parcurg lista cu un iterator si sterg din ea**/
        while (itr.hasNext()) {
            IMenuItem item = itr.next();
            if (item instanceof CompositeProduct)
                if (((CompositeProduct) item).getNameCompositeProduct().equals(nameC)) {
                    itr.remove();   /**cazul in care e obiect de tipul CompositeProduct**/

                }
            if (item instanceof BaseProduct) {
                if (((BaseProduct) item).getNameBaseProduct().equals(nameC))
                    itr.remove();/**cazul in care e de tipul BaseProduct**/
            }
        }

        Iterator<IMenuItem> itr1 = this.getAllmenuItems().iterator();
        while (itr1.hasNext()) {  /**cazul in care e de tipul BaseProduct si apare si in lista de CompositeProduct, acesta se sterge si de acolo.**/
            IMenuItem item1 = itr1.next();
            if (item1 instanceof CompositeProduct) {
                Iterator<IMenuItem> itr2 = ((CompositeProduct) item1).getMenuComposite().iterator();
                while (itr2.hasNext()) {
                    IMenuItem item2 = itr2.next();
                    if (item2 instanceof BaseProduct) {
                        if (((BaseProduct) item2).getNameBaseProduct().equals(nameC)) {
                            itr1.remove();/**sterg obiectul din lista**/
                        }
                    }
                }

            }

        }
        assert(this.getAllmenuItems().size()==size-1);/**verific ca s a modificat numarul de meniuri**/

    }

    @Override
    public void editMenu_(String nameC, Float priceC) {

        assert(iswellFormed(nameC)) ;/**invariant, verific daca numele nu este null**/
        assert(iswellFormed(priceC));/**invariant, verific daca pretul nu este null**/
        assert(priceC>0);/**preconditie, pretul care urmeaza a fi setata e >0**/
        if (this.getAllmenuItems().isEmpty() == false) {
            for (IMenuItem themenu : this.getAllmenuItems()) {
                if (themenu instanceof CompositeProduct) {
                    if (((CompositeProduct) themenu).getNameCompositeProduct().equals(nameC)) {


                        ((CompositeProduct) themenu).setPrice(priceC); /**este de tipul CompositeProduct*/


                    }
                }
                if (themenu instanceof BaseProduct) {
                    if (((BaseProduct) themenu).getNameBaseProduct().equals(nameC))
                        ((BaseProduct) themenu).setPrice(priceC);/**este de tipul BaseProduct**/

                }

            }
        }
        if (this.getAllmenuItems().isEmpty() == false) {
            for (IMenuItem themenu : this.getAllmenuItems()) {
                if (themenu instanceof CompositeProduct) {/**modific obiectul si in lista de CompositeProduct**/
                    for (IMenuItem a : ((CompositeProduct) themenu).getMenuComposite()) {
                        if (a instanceof BaseProduct)
                            if (((BaseProduct) a).getNameBaseProduct().equals(nameC)) {
                                ((BaseProduct) a).setPrice(priceC);
                                ((CompositeProduct) themenu).setPrice(themenu.compositePrice_());
                            }
                    }
                }
            }


        }

    }


    /**
     *
     * @return ne da Mapul de restaurantOrder, care contine Orderuri si MenuItems.
     */
    public Map<Order, List<IMenuItem>> getRestaurantOrder() {
        return restaurantOrder;
    }


    /**
     *
     * @return getter pentru a returna lista de meniuri.
     */
    public List<IMenuItem> getAllmenuItems() {
        return allmenuItems;
    }

    /**
     *
     * @return metoda toString pentru a ma ajuta la afisarea pe ecran.
     */

    @Override
    public String toString() {
        return "Restaurant{" +
                "allmenuItems=" + allmenuItems +
                '}';
    }


}

package businessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Observable implements Serializable {
    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public transient List<Observer> observerList;
    public Observable()
    {

        this.observerList=new ArrayList<>();
    }
    public void addObserver(Observer observer)
    {
        this.observerList.add(observer);
    }
    public void notifyObservers()
    {
        for(Observer observer:this.observerList)
        {
            observer.update();
        }
    }
}

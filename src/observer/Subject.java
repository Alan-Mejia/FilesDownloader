package observer;

import downloader.Downloader;

import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observerArrayList = new ArrayList<>();
    private String status;


    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status=status;
        notifyObservers();
    }

    public void registerNewObserver(Observer observer){
        observerArrayList.add(observer);
        notifyObservers();
    }

    public void unregisterObserver(Observer observer){
        observerArrayList.remove(observer);
    }

    public void notifyObservers(){
        for(Observer aux: observerArrayList){
            aux.update();
        }
    }

}
